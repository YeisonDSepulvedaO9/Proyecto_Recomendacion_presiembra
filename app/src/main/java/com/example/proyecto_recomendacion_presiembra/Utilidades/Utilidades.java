package com.example.proyecto_recomendacion_presiembra.Utilidades;

public class Utilidades {

/*
    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="Usuario";
    public static final String CAMPO_ID_USUARIO="id_usuario";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_NOMBRE_USUARIO="nom_usuario";
    public static final String CAMPO_CULTIVO_INTERES_u="cultivo_int_u";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+"("+CAMPO_ID_USUARIO+" " +
            "INTEGER AUTOINCREMENT, "+CAMPO_CORREO+" TEXT PRIMARY KEY,"+CAMPO_NOMBRE_USUARIO+
            " TEXT,"+CAMPO_CULTIVO_INTERES_u+" TEXT)";

/*
    //Constantes campos tabla cultivo
    public static final String TABLA_CULTIVO="cultivos_informacion";
    public static final String CAMPO_ID_CULTIVO="id_cultivo";
    public static final String CAMPO_NOMBRE_CULTIVO="nombre_cultivo";
    public static final String CAMPO_TIEMPO_CULTIVO="tiempo_cultivo";


    public static final String CREAR_TABLA_CULTIVO="CREATE TABLE " +
            ""+TABLA_CULTIVO+" ("+CAMPO_ID_CULTIVO+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE_CULTIVO+" TEXT, "+CAMPO_TIEMPO_CULTIVO+ "INTEGER)";


    public static final String insertar_cultivo="INSERT " +
            ""+TABLA_CULTIVO+" ("+"buenas"+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE_CULTIVO+" TEXT, "+CAMPO_TIEMPO_CULTIVO+ "INTEGER)";


    //Oferta

    public static final String TABLA_OFERTAO="cultivos_oferta";
    public static final String CAMPO_ID_OFERTA="id_oferta";
    public static final String CAMPO_OFERTA="nombre_oferta";
    public static final String CAMPO_MES="tiempo_oferta";
    public static final String PORCENTAJE="tiempo_cultivo";





    //Contantes tabla usuario_cultivo

    public static final String TABLA_USUARIO_CULTIVO="usuario_cultivos";

        /*public static final String CREAR_TABLA_USUARIO_CULTIVO="CREATE TABLE " +
            ""+TABLA_USUARIO_CULTIVO+" ("+CAMPO_ID_CULTIVO+" INTEGER AUTOINCREMENT, "
            +CAMPO_NOMBRE_MASCOTA+" TEXT, "+CAMPO_RAZA_MASCOTA+" TEXT,"+CAMPO_ID_DUENIO+" INTEGER)";*/




    //Constantes campos tabla realizar realizar reporte

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

}
