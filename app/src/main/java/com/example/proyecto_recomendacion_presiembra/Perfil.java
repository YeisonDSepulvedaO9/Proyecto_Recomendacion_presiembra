package com.example.proyecto_recomendacion_presiembra;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;


public class Perfil extends AppCompatActivity  {

    TextView nombre, correo,cultivo,municipio;
    Button per;
    ListView lista;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        perfil("http://192.168.0.10/proyecto_presiembra/perfil.php");



        nombre= (TextView) findViewById(R.id.nombre_perfil);
        correo=(TextView) findViewById(R.id.correo_perfil);
        municipio=(TextView) findViewById(R.id.municipio_perfil);
        cultivo=(TextView) findViewById(R.id.cultivo_perfil);
        Button buscar= (Button) findViewById(R.id.buscar);



        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 perfil("http://192.168.0.10/proyecto_presiembra/perfil.php");
            }
        });



            //String nombree= getIntent().getStringExtra("usuario");
            //System.out.println("el correo perfil "+users);



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
    private void perfil(String URL){
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        nombre.setText(jsonObject.getString("usu_nombre"));
                        correo.setText(jsonObject.getString("usu_correo"));
                        municipio.setText(jsonObject.getString("usu_municipio"));
                        cultivo.setText(jsonObject.getString("usu_cultivo"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error contactarse con el administrador",Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue_recomen= Volley.newRequestQueue(this);
        requestQueue_recomen.add(jsonArrayRequest);
    }


}