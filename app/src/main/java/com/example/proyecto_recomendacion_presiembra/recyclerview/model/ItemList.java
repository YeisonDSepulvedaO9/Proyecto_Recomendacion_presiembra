package com.example.proyecto_recomendacion_presiembra.recyclerview.model;

import java.io.Serializable;

public class ItemList implements Serializable {


    private String id;
    private String titulo;
    private String fechainicio;
    private String fechafinal;

    public ItemList(String id,String titulo, String fechainicio, String fechafinal) {
        this.id=id;
        this.titulo = titulo;
        this.fechainicio = fechainicio;
        this.fechafinal= fechafinal;
    }


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }
}
