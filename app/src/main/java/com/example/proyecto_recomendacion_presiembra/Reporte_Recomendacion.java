package com.example.proyecto_recomendacion_presiembra;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reporte_Recomendacion extends AppCompatActivity implements View.OnClickListener {

    Button volver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificado_reporte);
        //volver2=(Button) findViewById(R.id.volver);
        //volver2.setOnClickListener(this);




        String cultivo_fin= getIntent().getStringExtra("culti_fin");
        String fecha_ini= getIntent().getStringExtra("fecha_ini");
        String fecha_final= getIntent().getStringExtra("fecha_final");
        String productividad= getIntent().getStringExtra("productividad");

        System.out.println("el correo inicio aaa. "+cultivo_fin);
        System.out.println("el correo regis  aaa "+fecha_ini);
        System.out.println("el correo inicio aaa. "+fecha_final);
        System.out.println("el correo regis  aaa "+productividad);






        String users= getIntent().getStringExtra("useraIni");
        String correo= getIntent().getStringExtra("useraRego");
        if(correo==null){
             correo=users;
        }

        System.out.println("el correo inicio aaa. "+users);
        System.out.println("el correo regis  aaa "+correo);



    }

    @Override

    public void onClick(View view) {

        Intent i= new Intent(Reporte_Recomendacion.this,Activity_inicio_sesion.class );

        startActivity(i);

    }
}