package com.example.demo.Model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Centro_FormacionRepository extends JpaRepository <Centro_Formacion, Integer> {
    
}