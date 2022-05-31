package com.example.proyecto_recomendacion_presiembra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Proceso_recomendacion {


    String municipio;
    String hectareas;
    String cultivo;
    String fecha;
    int dias;


    public Proceso_recomendacion(String municipio, String hectareas, String cultivo, String fecha, int dias) {
        this.municipio = municipio;
        this.hectareas = hectareas;
        this.cultivo = cultivo;
        this.fecha = fecha;

    }

    public Date sumarDiasAFecha(String fecha, int dias) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaActual = new Date();
        Date fecha_fin = formato.parse(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha_fin);
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        Date suma_fecha= calendar.getTime();
        System.out.println("Suma es" + (suma_fecha));
        return suma_fecha;
    }


    public void calculo(String fecha, String cultivo,String hectareas){

        String dateParts[] = fecha.split("-");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];
        String [] ofertaalta;
        String [] ofertamedia;
        String [] ofertabaja;
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
    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }



}
