package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Menu_consulta_reportes extends AppCompatActivity {




        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_menu_consulta_reportes);


        }

/*
    public boolean conectarMySQL()
    {
        try{
            //Cargamos el driver del conector JDBC
            Class.forName(driver).newInstance ();
            //Establecemos la conexión con el Servidor MySQL indicándole como parámetros la url construida,
            //la Base de Datos a la que vamos a conectarnos, y el usuario y contraseña de acceso al servidor
            conexionMySQL = DriverManager.getConnection(urlMySQL + baseDatos, user, password);
            //Comprobamos que la conexión se ha establecido
            if(!conexionMySQL.isClosed())
            {
                estadoConexion = true;
                Toast.makeText(MainActivity.this,"Conexión Establecida", Toast.LENGTH_LONG).show();
            }
        }catch(Exception ex)
        {
            Toast.makeText(MainActivity.this,"Error al comprobar las credenciales:" + ex.getMessage(), Toast.LENGTH_LONG).show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_consulta_reportes);
    }

            public void abrirConexion(View view)
            {
                Intent intent = new Intent(this,ConsultasSQL.class);
                //Si el valor devuelto por la función es true, pasaremos los datos de la conexión a la siguiente Activity
                if(conectarMySQL() == true)
                {
                    Toast.makeText(this, "Los datos de conexión introducidos son correctos.", Toast.LENGTH_LONG).show();
                    intent.putExtra("servidor", edServidor.getText().toString());
                    intent.putExtra("puerto", edPuerto.getText().toString());
                    intent.putExtra("usuario", edUsuario.getText().toString());
                    intent.putExtra("password", edPassword.getText().toString());
                    intent.putExtra("datos", baseDatos);
                    startActivity(intent);
                }
            }
            */
        }