package com.example.proyecto_recomendacion_presiembra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.proyecto_recomendacion_presiembra.Utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOMBREE = "PoyectoPresiembra.db";

    public ConexionSQLiteHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NOMBREE, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqDB) {

        sqDB.execSQL(Utilidades.CREAR_TABLA_REGISTRO);
        sqDB.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqDB, int ver_antigua, int ver_nueva) {
        sqDB.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        //sqDB.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_REGISTRO);
        sqDB.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CULTIVO);
        onCreate(sqDB);


    }
}