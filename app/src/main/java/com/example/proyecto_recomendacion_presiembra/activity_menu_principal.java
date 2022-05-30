package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.proyecto_recomendacion_presiembra.inicio;


public class activity_menu_principal extends AppCompatActivity {


    Class icinio;
    ImageView boton_perfil,boton_recomendador,boton_histori_recomen,boton_log_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);



        String users= getIntent().getStringExtra("useraIni");
        String correo= getIntent().getStringExtra("useraRego");
        String user=correo;

        System.out.println("el correo inicio. "+users);
        System.out.println("el correo registro "+correo);


        // Boton para perfil
        boton_perfil= (ImageView) findViewById(R.id.ImButton_perfil);
        boton_perfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view_boton_perfil) {
                Intent B_perf= new Intent(activity_menu_principal.this,Perfil.class);
                startActivity(B_perf);
                finish();
            }
        });


        // Boton para recomendacion activity
        boton_recomendador= (ImageView) findViewById(R.id.IBoton_recomendador);
        boton_recomendador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_recomendador) {
                Intent B_recom= new Intent(activity_menu_principal.this, activity_realizar_recomendacion.class);
                startActivity(B_recom);
                finish();
            }
        });

        // Boton para hitorial recomendacion
        boton_histori_recomen= (ImageView) findViewById(R.id.ImButton_historiala);
        boton_histori_recomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_recomandador) {
                Intent B_hist= new Intent(activity_menu_principal.this,inicio.class);
                startActivity(B_hist);
                finish();
            }
        });
        // Boton cerrar sesion n
        boton_log_out= (ImageView) findViewById(R.id.Butt_log_out);
        boton_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_log_out) {
                SharedPreferences preferences=getSharedPreferences("recuperarPreferneces", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                Intent B_logout_intentet= new Intent(getApplicationContext(),Activity_inicio_sesion.class);
                startActivity(B_logout_intentet);
                finish();
            }
        });


    }


}