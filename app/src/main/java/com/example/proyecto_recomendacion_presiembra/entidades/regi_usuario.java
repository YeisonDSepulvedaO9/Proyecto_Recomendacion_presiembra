package com.example.proyecto_recomendacion_presiembra.entidades;

import java.io.Serializable;




public class regi_usuario implements Serializable {

    private Integer id_usuario;
    private String usuario;
    private String correo;
    private String cultivo;

    public regi_usuario(Integer id_usuario, String usuario, String correo, String cultivo) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.correo = correo;
        this.cultivo = cultivo;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }
}
