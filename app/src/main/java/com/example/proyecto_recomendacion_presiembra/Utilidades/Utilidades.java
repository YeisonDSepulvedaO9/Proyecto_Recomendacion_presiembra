package com.example.proyecto_recomendacion_presiembra.Utilidades;

public class Utilidades {

    //Constantes campos tabla realizar reporte
    public static final String TABLA_REGISTRO="TABLA_REALIZAR_RECOMENDACIONO";
    public static final String CAMPO_ID_RE_REPORTE="id_report";
    public static final String CAMPO_MUNICIPIO="municipio";
    public static final String CAMPO_HECTAREAS="hectareas";
    public static final String CAMPO_CULTIVO_INTERES="cultivo_int";
    public static final String CAMPO_FECHA="fecha_r";

    public static final String CREAR_TABLA_REGISTRO="CREATE TABLE " +
            ""+TABLA_REGISTRO+"("+CAMPO_ID_RE_REPORTE+" " +
            "INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_MUNICIPIO+" TEXT,"+CAMPO_HECTAREAS+
            " TEXT,"+CAMPO_CULTIVO_INTERES+" TEXT,"+CAMPO_FECHA+" TEXT)";


    /*Constantes campos tabla mascota
    public static final String TABLA_MASCOTA="mascota";
    public static final String CAMPO_ID_MASCOTA="id_mascota";
    public static final String CAMPO_NOMBRE_MASCOTA="nombre_mascota";
    public static final String CAMPO_RAZA_MASCOTA="raza_mascota";
    public static final String CAMPO_ID_DUENIO="id_duenio";

    public static final String CREAR_TABLA_MASCOTA="CREATE TABLE " +
            ""+TABLA_MASCOTA+" ("+CAMPO_ID_MASCOTA+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE_MASCOTA+" TEXT, "+CAMPO_RAZA_MASCOTA+" TEXT,"+CAMPO_ID_DUENIO+" INTEGER)";*/
}
