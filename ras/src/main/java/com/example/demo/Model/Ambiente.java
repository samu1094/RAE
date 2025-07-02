package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ambiente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_amb")
    private int cod_amb;

    private String nom_amb;
    private Integer capacidad_amb;
    private String piso_amb;
    public int getCod_amb() {
        return cod_amb;
    }
    public void setCod_amb(int cod_amb) {
        this.cod_amb = cod_amb;
    }
    public String getNom_amb() {
        return nom_amb;
    }
    public void setNom_amb(String nom_amb) {
        this.nom_amb = nom_amb;
    }
    public Integer getCapacidad_amb() {
        return capacidad_amb;
    }
    public void setCapacidad_amb(Integer capacidad_amb) {
        this.capacidad_amb = capacidad_amb;
    }
    public String getPiso_amb() {
        return piso_amb;
    }
    public void setPiso_amb(String piso_amb) {
        this.piso_amb = piso_amb;
    }


}
