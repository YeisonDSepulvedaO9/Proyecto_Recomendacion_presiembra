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
        setContentView(R.layout.activity_reporte_recomendacion);
        volver2=(Button) findViewById(R.id.volver);
        volver2.setOnClickListener(this);


    }



    @Override

    public void onClick(View view) {

        Intent i= new Intent(Reporte_Recomendacion.this,Activity_inicio_sesion.class );
        startActivity(i);

    }
}