package com.example.proyecto_recomendacion_presiembra.entidades;

public class User {


    String idusuer;
    String nombreuser;
    String cultivoreco;
    String rentabilida;



    public User(String idusuer, String nombreuser, String cultivoreco, String rentabilida) {
        this.idusuer = idusuer;
        this.nombreuser = nombreuser;
        this.cultivoreco = cultivoreco;
        this.rentabilida = rentabilida;
    }

    public String getIdusuer() {
        return idusuer;
    }

    public void setIdusuer(String idusuer) {
        this.idusuer = idusuer;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }


    public String getCultivoreco() {
        return cultivoreco;
    }

    public void setCultivoreco(String cultivoreco) {
        this.cultivoreco = cultivoreco;
    }

    public String getRentabilida() {
        return rentabilida;
    }

    public void setRentabilida(String rentabilida) {
        this.rentabilida = rentabilida;
    }
}
