package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class menu_re extends AppCompatActivity implements View.OnClickListener {


    ImageButton papa;
    ImageButton fresa;
    ImageButton alverja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_re);

        papa = (ImageButton) findViewById(R.id.papa);
        papa.setOnClickListener(this);

        fresa = (ImageButton) findViewById(R.id.fresa);
        fresa.setOnClickListener(this);

        alverja = (ImageButton) findViewById(R.id.alverja);
        alverja.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.papa:
                Intent i = new Intent(menu_re.this, menu_arveja.class);
                startActivity(i);
                finish();
                break;
        }

        switch (view.getId()) {
            case R.id.fresa:
                Intent i = new Intent(menu_re.this,menu_fresa.class);
                startActivity(i);
                finish();
                break;
        }
        switch (view.getId()) {
            case R.id.alverja:
                Intent i = new Intent(menu_re.this, menu_papa.class);
                startActivity(i);
                finish();
                break;
        }
    }
}