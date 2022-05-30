package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        Animation animacion1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        ImageView imagenlogo= findViewById(R.id.IV_logo);
        ImageView imagenbienvenida= findViewById(R.id.IV_bienvenida);

        imagenlogo.setAnimation(animacion1);
        imagenbienvenida.setAnimation(animacion2);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splas = new Intent(splash.this, Activity_inicio_sesion.class);
                startActivity(splas);
                finish();
            }
        },4000);
    }

}