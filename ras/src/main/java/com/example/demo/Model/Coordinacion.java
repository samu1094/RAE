package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Coordinacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_coordinacion")
    private int cod_coordinacion;

    private String nombre_coordinacion;

    @ManyToOne
    @JoinColumn(name = "cod_centro")
    private Centro_Formacion centroFormacion;

    public int getCod_coordinacion() {
        return cod_coordinacion;
    }

    public void setCod_coordinacion(int cod_coordinacion) {
        this.cod_coordinacion = cod_coordinacion;
    }

    public String getNombre_coordinacion() {
        return nombre_coordinacion;
    }

    public void setNombre_coordinacion(String nombre_coordinacion) {
        this.nombre_coordinacion = nombre_coordinacion;
    }

    public Centro_Formacion getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(Centro_Formacion centroFormacion) {
        this.centroFormacion = centroFormacion;
    }
}
