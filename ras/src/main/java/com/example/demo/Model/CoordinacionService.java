package com.example.demo.Model;

import com.example.demo.DTO.CoordinacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoordinacionService {

    @Autowired
    private CoordinacionRepository coordinacionRepository;

    @Autowired
    private Centro_FormacionRepository centroFormacionRepository;

    // Obtener todas las coordinaciones con el nombre del centro
    public List<CoordinacionDTO> obtenerTodas() {
        List<Coordinacion> lista = coordinacionRepository.findAll();

        return lista.stream()
                .map(c -> new CoordinacionDTO(
                c.getCod_coordinacion(),                  
                c.getNombre_coordinacion(),               
                c.getCentroFormacion().getNom_centro()     
))

                .collect(Collectors.toList());
    }

    // Crear una nueva coordinación asociada a un centro existente
    public Coordinacion crear(Coordinacion coordinacion, int codCentro) {
        Optional<Centro_Formacion> centroOpt = centroFormacionRepository.findById(codCentro);

        if (centroOpt.isPresent()) {
            coordinacion.setCentroFormacion(centroOpt.get());
            return coordinacionRepository.save(coordinacion);
        } else {
            throw new RuntimeException("Centro con código " + codCentro + " no encontrado");
        }
    }

    // Obtener por ID
    public Coordinacion obtenerPorId(int id) {
        return coordinacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordinación no encontrada"));
    }

    // Eliminar
    public void eliminar(int id) {
        coordinacionRepository.deleteById(id);
    }

    // Actualizar
    public Coordinacion actualizar(int id, Coordinacion coordinacionActualizada, int codCentro) {
        Coordinacion existente = obtenerPorId(id);
        existente.setCod_coordinacion(coordinacionActualizada.getCod_coordinacion());

        Centro_Formacion centro = centroFormacionRepository.findById(codCentro)
                .orElseThrow(() -> new RuntimeException("Centro no encontrado"));

        existente.setCentroFormacion(centro);

        return coordinacionRepository.save(existente);
    }
}
