package com.example.proyecto_recomendacion_presiembra.entidades;

import java.io.Serializable;

public class reali_report implements Serializable {
    private Integer id_repote;
    private String municipio;
    private String hectareas;
    private String cultivo;
    private String fecha;

    public reali_report(Integer id_repote, String municipio, String hectareas, String cultivo, String fecha) {
        this.id_repote = id_repote;
        this.municipio = municipio;
        this.hectareas = hectareas;
        this.cultivo = cultivo;
        this.fecha = fecha;
    }

    public Integer getId_repote() {
        return id_repote;
    }

    public void setId_repote(Integer id_repote) {
        this.id_repote = id_repote;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getHectareas() {
        return hectareas;
    }

    public void setHectareas(String hectareas) {
        this.hectareas = hectareas;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
