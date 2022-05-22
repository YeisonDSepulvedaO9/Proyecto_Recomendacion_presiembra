package com.example.proyecto_recomendacion_presiembra;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class Perfil extends AppCompatActivity implements View.OnClickListener {

    EditText nom, muni, cul;
    Button per;
    daUsuario dao1;
    ListView lista;

    daUsuario da;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        nom = findViewById(R.id.Nombre_registro);
        muni = findViewById(R.id.Municipio_registro);
        cul = findViewById(R.id.cultivo_registro);

        per = (Button) findViewById(R.id.volver_p);
        per.setOnClickListener(this);
        dao1 = new daUsuario(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.registrar:
                //nom.setText();
                String m = muni.getText().toString();
                String c = cul.getText().toString();

                break;




        }
    }
}