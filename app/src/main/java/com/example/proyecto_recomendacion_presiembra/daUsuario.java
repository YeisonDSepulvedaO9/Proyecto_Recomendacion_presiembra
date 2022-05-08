package com.example.proyecto_recomendacion_presiembra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class daUsuario {
    Context c;
    usuario u;
    ArrayList<usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDusuario";
    String tabla = "create table  if not exists Usuario (id integer primary key autoincrement,correo text ,contraseña text,repetir_con text ,nombre text,municipio text , cultivo text )";

    public daUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new usuario();

    }

    public boolean insertarUsuario(usuario u) {
        if (buscar(u.getCorreo()) == 0) {

            ContentValues values = new ContentValues();
            values.put("correo", u.getCorreo());
            values.put("contraseña", u.getContraseña());
            values.put("repetir_con", u.getRepetir_con());
            values.put("Nombre", u.getNombre());
            values.put("municipio", u.getMunicipio());
            values.put("cultivo", u.getCultivo());
            return (sql.insert("usuario", null, values) > 0);
        } else {

            return false;
        }
    }

    public int buscar(String u) {
        int x = 0;
        lista = selectusuario();
        for (usuario us : lista) {
            if (us.getCorreo().equals(u)) {
                x++;
            }

        }
        return x;

    }


    public ArrayList<usuario> selectusuario() {
        ArrayList<usuario> lista = new ArrayList<usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from Usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                usuario u = new usuario();
                u.setId(cr.getInt(0));
                u.setCorreo(cr.getString(1));
                u.setContraseña(cr.getString(2));
                u.setRepetir_con(cr.getString(3));
                u.setNombre(cr.getString(4));
                u.setMunicipio(cr.getString(5));
                u.setCultivo(cr.getString(6));
                lista.add(u);


            } while (cr.moveToNext());
        }
        return lista;
    }

    public int login(String u,String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from Usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(1).equals(u) && cr.getString(2).equals(p)) {

                    a++;
                }

            } while (cr.moveToNext());


        }
        return a;
    }

    public int cargar(String n,String m,String c) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from Usuario", null);
        if (cr != null && cr.moveToFirst()) {


            do {
                if (cr.getString(4).equals(n) && cr.getString(5).equals(m)&& cr.getString(6).equals(c)) {



                    a++;
                }

            } while (cr.moveToNext());
        }
        return a;
    }
        public usuario getUsuario(String u , String p){
        lista=selectusuario();
        for (usuario us:lista){
            if(us.getCorreo().equals(u)&&us.getContraseña().equals(p)){

            return us;
        }
        }
        return null;

    }
    public usuario getusuariobyId(int id){
        lista=selectusuario();
        for (usuario us:lista){
            if(us.getId()==id){
                return us;
            }
        }
        return null;
    }


}





