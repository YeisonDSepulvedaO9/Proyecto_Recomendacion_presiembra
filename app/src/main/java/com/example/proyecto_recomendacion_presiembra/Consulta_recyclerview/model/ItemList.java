package com.example.proyecto_recomendacion_presiembra.Consulta_recyclerview.model;

import java.io.Serializable;

public class ItemList implements Serializable {

    private String cultivo_name;
    private String fecha_inicio;
    private String fecha_final;


    public ItemList(String cultivo_name, String fecha_inicio, String fecha_final) {
        this.cultivo_name=cultivo_name;
        this.fecha_inicio=fecha_inicio;
        this.fecha_final=fecha_final;
    }

    public String getCultivo_name() {
        return cultivo_name;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }


}
