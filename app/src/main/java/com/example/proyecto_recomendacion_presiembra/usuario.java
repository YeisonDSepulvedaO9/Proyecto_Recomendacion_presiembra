package com.example.proyecto_recomendacion_presiembra;

public class usuario {
    int id;
    String correo,contraseña,repetir_con,nombre,municipio,cultivo;

public usuario(){

}

    public usuario(String correo, String contraseña, String repetir_con, String nombre, String municipio, String cultivo) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.repetir_con = repetir_con;
        this.nombre = nombre;
        this.municipio = municipio;
        this.cultivo = cultivo;
    }

    public boolean isNull(){
    if(correo.equals(" ")&&contraseña.equals("")&&repetir_con.equals("")&&nombre.equals("")&&municipio.equals("")&&cultivo.equals("")){
        return  false;
    }else{

        return true;
    }


}
    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", repetir_con='" + repetir_con + '\'' +
                ", nombre='" + nombre + '\'' +
                ", municipio='" + municipio + '\'' +
                ", cultivo='" + cultivo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRepetir_con() {
        return repetir_con;
    }

    public void setRepetir_con(String repetir_con) {
        this.repetir_con = repetir_con;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }
}