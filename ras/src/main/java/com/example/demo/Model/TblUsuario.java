// TblUsuario.java
package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_usuario")
public class TblUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private int cod_usuario;

    private String tipo_docu;
    private Integer num_docu;
    private String nomb_comple;
    private String apelli_comple;
    private Long telefono;
    private String email;
    private String password;
    private String rol_usuario;
    public int getCod_usuario() {
        return cod_usuario;
    }
    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }
    public String getTipo_docu() {
        return tipo_docu;
    }
    public void setTipo_docu(String tipo_docu) {
        this.tipo_docu = tipo_docu;
    }
    public Integer getNum_docu() {
        return num_docu;
    }
    public void setNum_docu(Integer num_docu) {
        this.num_docu = num_docu;
    }
    public String getNomb_comple() {
        return nomb_comple;
    }
    public void setNomb_comple(String nomb_comple) {
        this.nomb_comple = nomb_comple;
    }
    public String getApelli_comple() {
        return apelli_comple;
    }
    public void setApelli_comple(String apelli_comple) {
        this.apelli_comple = apelli_comple;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRol_usuario() {
        return rol_usuario;
    }
    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }
}
