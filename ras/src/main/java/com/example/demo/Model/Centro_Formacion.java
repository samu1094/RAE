package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Centro_Formacion {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cod_centro")
        private int cod_centro;

    private String nom_centro;
    private String direccion_centro;
    private String ciudad_centro;

    @OneToMany(mappedBy = "centroFormacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coordinacion> coordinaciones;
    
    public int getCod_centro() {
        return cod_centro;
    }
    public void setCod_centro(int cod_centro) {
        this.cod_centro = cod_centro;
    }
    public String getNom_centro() {
        return nom_centro;
    }
    public void setNom_centro(String nom_centro) {
        this.nom_centro = nom_centro;
    }
    public String getDireccion_centro() {
        return direccion_centro;
    }
    public void setDireccion_centro(String direccion_centro) {
        this.direccion_centro = direccion_centro;
    }
    public String getCiudad_centro() {
        return ciudad_centro;
    }
    public void setCiudad_centro(String ciudad_centro) {
        this.ciudad_centro = ciudad_centro;
    }
    public List<Coordinacion> getCoordinaciones() {
        return coordinaciones;
    }

    public void setCoordinaciones(List<Coordinacion> coordinaciones) {
        this.coordinaciones = coordinaciones;
    }
}
    

