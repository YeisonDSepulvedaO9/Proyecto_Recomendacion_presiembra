package com.example.proyecto_recomendacion_presiembra.inventory;
import java.io.Serializable;


public class Municipios implements Serializable {

    private String municipio;


    public Municipios() {
    }

    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String name) {
        this.municipio = name;
    }

}