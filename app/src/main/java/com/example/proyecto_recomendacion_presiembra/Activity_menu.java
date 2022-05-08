package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Activity_menu extends AppCompatActivity {

    Button boton_perfil,boton_recomendador,boton_histori_recomen,boton_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        // Boton para perfil
        boton_perfil= (Button) findViewById(R.id.ImButton_perfil);
        boton_perfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view_boton_perfil) {
                Intent B_perf= new Intent(Activity_menu.this,Perfil.class);
                startActivity(B_perf);
            }
        });


        // Boton para recomendacion activity
        boton_recomendador= (Button) findViewById(R.id.IBoton_recomendador);
        boton_recomendador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_recomendador) {
                Intent B_recom= new Intent(Activity_menu.this, activity_realizar_recomendacion.class);
                startActivity(B_recom);
            }
        });

        // Boton para hitorial recomendacion
        boton_histori_recomen= (Button) findViewById(R.id.ImButton_historial);
        boton_histori_recomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_recomandador) {
                Intent B_hist= new Intent(Activity_menu.this,Menu_consulta_reportes.class);
                startActivity(B_hist);
            }
        });

    }
}