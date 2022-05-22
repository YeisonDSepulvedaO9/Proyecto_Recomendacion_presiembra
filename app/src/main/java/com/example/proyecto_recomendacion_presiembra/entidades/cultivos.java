package com.example.proyecto_recomendacion_presiembra.entidades;



public class cultivos {


    private Integer id_cultivo;
    private String cultivo;
    private String tiempo;

    public cultivos(Integer id_cultivo, String cultivo, String tiempo) {
        this.id_cultivo = id_cultivo;
        this.cultivo = cultivo;
        this.tiempo = tiempo;
    }

    public Integer getId_cultivo() {
        return id_cultivo;
    }

    public void setId_cultivo(Integer id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
