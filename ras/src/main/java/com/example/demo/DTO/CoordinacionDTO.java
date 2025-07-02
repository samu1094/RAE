package com.example.demo.DTO;

public class CoordinacionDTO {
    private int codCoordinacion;
    private String nombreCoordinacion;
    private String nombreCentro;

    public CoordinacionDTO(int codCoordinacion, String nombreCoordinacion, String nombreCentro) {
        this.codCoordinacion = codCoordinacion;
        this.nombreCoordinacion = nombreCoordinacion;
        this.nombreCentro = nombreCentro;
    }

    public int getCodCoordinacion() {
        return codCoordinacion;
    }

    public void setCodCoordinacion(int codCoordinacion) {
        this.codCoordinacion = codCoordinacion;
    }

    public String getNombreCoordinacion() {
        return nombreCoordinacion;
    }

    public void setNombreCoordinacion(String nombreCoordinacion) {
        this.nombreCoordinacion = nombreCoordinacion;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }
}
 