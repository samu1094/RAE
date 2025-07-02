package com.example.demo.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Centro_FormacionService {
    
    @Autowired
    private Centro_FormacionRepository centro_FormacionRepository;

    public List<Centro_Formacion> getAllCentros() {
        return centro_FormacionRepository.findAll();
    }

    public Centro_Formacion saveCentros(Centro_Formacion centro_formacion) {
        return centro_FormacionRepository.save(centro_formacion);
    }

    public Centro_Formacion getCentrosById(Integer id) {
        return centro_FormacionRepository.findById(id).orElse(null);
    }

    public void deleteCentro(Integer id) {
        centro_FormacionRepository.deleteById(id);
    }
}
