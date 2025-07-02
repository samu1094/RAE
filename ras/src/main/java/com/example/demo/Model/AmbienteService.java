package com.example.demo.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AmbienteService {
    
    @Autowired
    private AmbienteRepository ambienteRepository;

    public List<Ambiente> getAllAmbientes() {
        return ambienteRepository.findAll();
    }

    public Ambiente saveAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    public Ambiente getAmbienteById(Integer id) {
        return ambienteRepository.findById(id).orElse(null);
    }

    public void deleteAmbiente(Integer id) {
        ambienteRepository.deleteById(id);
    }
}
