package com.example.proyecto_recomendacion_presiembra;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class Perfil extends AppCompatActivity  {

    EditText nom, muni, cul;
    Button per;
    ListView lista;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        findViewById(R.id.titulo);
        findViewById(R.id.textView28);
        findViewById(R.id.fecha_regis);
        findViewById(R.id.resgis_culti);



        Button boton_perfil= (Button) findViewById(R.id.volver_perfil_menu);
        boton_perfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view_boton_perfil) {
                Intent B_perf= new Intent(Perfil.this, activity_menu_principal.class);
                startActivity(B_perf);
                finish();
            }
        });

    }


}