package com.example.proyecto_recomendacion_presiembra.inventory;
import java.io.Serializable;

public class Cultivos implements Serializable {


    private String name;
    private int image;

    public Cultivos() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}