package com.example.proyecto_recomendacion_presiembra.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String correo_usu;
    private String nombre_usu;


    public Usuario(String correo_usu, String nombre_usu) {

        this.correo_usu = correo_usu;
        this.nombre_usu = nombre_usu;
    }
    public String getCorreo_usu() {
        return correo_usu;
    }

    public void setCorreo_usu(String municipio_usu) {
        this.correo_usu = correo_usu;
    }

    public String setNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

}
