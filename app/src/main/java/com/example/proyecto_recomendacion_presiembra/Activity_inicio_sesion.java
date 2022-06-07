package com.example.proyecto_recomendacion_presiembra;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Activity_inicio_sesion extends AppCompatActivity {

    EditText user_correo;
    EditText user_pass;
    Button iniciar_sesion;
    Button registrar;
    Button invitado;
    String user, passw;
    String URL_SERVIDOR="http://192.168.0.10/proyecto_presiembra/validar_usuario.php";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        user_correo = (EditText) findViewById(R.id.inicio_sesion);
        user_pass = (EditText) findViewById(R.id.Password_sesion);
        iniciar_sesion = (Button) findViewById((R.id.sesion_i));
        registrar = (Button)findViewById(R.id.re);
        invitado =(Button) findViewById(R.id.invitado);


        //invitado
        invitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_recomandador) {
                Intent intentinvitado = new Intent(Activity_inicio_sesion.this, activity_realizar_recomendacion.class);
                startActivity(intentinvitado);
                finish();
            }
        });
        //Evento click iniciar sesion

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_recomandador) {
                Intent i = new Intent(Activity_inicio_sesion.this, registrar.class);
                startActivity(i);
                finish();
            }
        });

        //Evento click iniciar sesion
        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_boton_inicio) {
                user= user_correo.getText().toString();
                passw=user_pass.getText().toString();

                if(user.isEmpty()){
                    user_correo.setError("Ingresar correo");
                    user_correo.requestFocus();
                    return;
                }
                if(passw.isEmpty()){
                    user_pass.setError("Ingresar correo");
                    user_pass.requestFocus();
                    return;
                }
                if(!user.isEmpty() && !passw.isEmpty()){
                        validar_sesion(URL_SERVIDOR);
                    }else{
                        Toast.makeText(getApplicationContext(), "No se permiten espacios vacios, registrase o inicia sesión", Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
    //Metodo validar sesion
    private void validar_sesion(String URL) {
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Intent intent_logg=new Intent(Activity_inicio_sesion.this, activity_menu_principal.class);
                    intent_logg.putExtra("usuario",intent_logg);
                    Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_SHORT).show();
                    startActivity(intent_logg);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"ERROR CONEXION URL UBICACION BASE DE DATOS: "+error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>parametros=new HashMap<String,String>();
                parametros.put("usuario",user_correo.getText().toString());
                parametros.put("password",user_pass.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}