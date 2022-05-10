package com.example.proyecto_recomendacion_presiembra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "presiembra.db";
    private static final String TABLA_REALIZAR_RECOMENDACION = "realizar_recomendacion";
    private static final String TABLA_CULTIVOS = "cultivos";
    private static final String TABLA_CORRDENADAS = "coordenadas";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null,DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table "+ TABLA_REALIZAR_RECOMENDACION +"(" +
                "idrecomendacion TEXT primary key, " +
                "municipio TEXT not null, " +
                "hectareas TEXT not null, " +
                "cultivo_r TEXT not null," +
                "fecha TEXT not null)");

        DB.execSQL("create Table "+ TABLA_CULTIVOS +"(" +
                "idrecomendacion TEXT primary key, " +
                "municipio TEXT not null, " +
                "hectareas TEXT not null, " +
                "cultivo_r TEXT not null," +
                "fecha TEXT not null)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists "+ TABLA_REALIZAR_RECOMENDACION);
        DB.execSQL("drop Table if exists "+ TABLA_CULTIVOS);

    }

    public Boolean insertuserdata(String idrecomendacion, String municipio, String hectareas, String cultivo_r, String fecha)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idrecomendacion", idrecomendacion);
        contentValues.put("municipio", municipio);
        contentValues.put("hectareas", hectareas);
        contentValues.put("cultivo_r", cultivo_r);
        contentValues.put("fecha", fecha);

        long result=DB.insert(TABLA_REALIZAR_RECOMENDACION, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateuserdata(String idrecomendacion, String municipio, String hectareas, String cultivo_r, String fecha)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idrecomendacion", idrecomendacion);
        contentValues.put("municipio", municipio);
        contentValues.put("hectareas", hectareas);
        contentValues.put("cultivo_r", cultivo_r);
        contentValues.put("fecha", fecha);

        Cursor cursor = DB.rawQuery("Select * from realizar_recomendacion where idrecomendacion = ?", new String[]{idrecomendacion});
        if (cursor.getCount() > 0) {
            long result = DB.update(TABLA_REALIZAR_RECOMENDACION, contentValues, "idrecomendacion=?", new String[]{idrecomendacion});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Boolean deletedata (String idrecomendacion)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from realizar_recomendacion where idrecomendacion = ?", new String[]{idrecomendacion});
        if (cursor.getCount() > 0) {
            long result = DB.delete(TABLA_REALIZAR_RECOMENDACION, "idrecomendacion=?", new String[]{idrecomendacion});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from realizar_recomendacion", null);
        return cursor;
    }
}




