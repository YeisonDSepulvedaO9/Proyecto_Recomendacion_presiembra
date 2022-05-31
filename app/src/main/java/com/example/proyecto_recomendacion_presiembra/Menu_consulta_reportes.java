package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto_recomendacion_presiembra.entidades.User;

import java.util.ArrayList;
import java.util.List;

public class Menu_consulta_reportes extends AppCompatActivity {

        Button boton_regresar_menu;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_consulta_reportes);


                // Boton regreso
                boton_regresar_menu= (Button) findViewById(R.id.regresar_consulta);
                boton_regresar_menu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view_boton_recomandador) {
                                Intent B_regre_consul= new Intent(Menu_consulta_reportes.this, activity_menu_principal.class);
                                startActivity(B_regre_consul);
                        }
                });


        }



        }