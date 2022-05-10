package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class registrar extends AppCompatActivity implements View.OnClickListener {

   EditText usuario_registrar, contrasena_registar, contrasenaconfirmacion_registar, nombre_r;

   Spinner Opcion,opcionesc;
   Button registrarse;
   Button volver;
   daUsuario dao;


   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_registrar);

      usuario_registrar=(EditText)findViewById(R.id.usuario_registrar);
      contrasena_registar=(EditText)findViewById(R.id.contrasena_registar);
      contrasenaconfirmacion_registar=(EditText)findViewById(R.id.contrasenaconfirmacion_registar);
      nombre_r=(EditText)findViewById(R.id.nombre_r);

      Opcion =(Spinner)findViewById(R.id.municipio);
      opcionesc=(Spinner)findViewById(R.id.cultivo_t);

      registrarse=(Button)findViewById(R.id.registrar);
      registrarse.setOnClickListener(this);

      volver=(Button)findViewById(R.id.volver);
      volver.setOnClickListener(this);



      dao =new daUsuario(this);

      //Rellenar spinner de municipio
      String [] opcion ={"Soacha","Sibate"};
      ArrayAdapter <String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcion);

      Opcion.setAdapter(adapter);

      //Rellenar spinner de cultivo

      String [] opciones ={"papa","fresa","alverja"};
      ArrayAdapter <String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
      opcionesc.setAdapter(adapter1);






   }
   public void onClick(View v){

      switch (v.getId()){
         case R.id.registrar:

            usuario u =new usuario();
            u.setCorreo(usuario_registrar.getText().toString());
            u.setContraseña(contrasena_registar.getText().toString());
            u.setRepetir_con(contrasenaconfirmacion_registar.getText().toString());
            u.setNombre(nombre_r.getText().toString());
            u.setMunicipio(Opcion.getSelectedItem().toString());
            u.setCultivo(opcionesc.getSelectedItem().toString());
            if(!u.isNull()) {

               Toast.makeText(this, "ERROR : campos vacios", Toast.LENGTH_LONG).show();
            }else if(dao.insertarUsuario(u)){
               Toast.makeText(this,"Registro Existoso !!!",Toast.LENGTH_LONG).show();


               Intent i= new Intent(registrar.this,Reporte_Recomendacion.class );
               startActivity(i);


            }else{

               Toast.makeText(this, "Usuario ya registrado !!", Toast.LENGTH_LONG).show();
            }



            break;

         case R.id.volver:
            Intent i5= new Intent(registrar.this,Perfil.class );
            startActivity(i5);
            break;

      }
   }

   @Override
   public void onPointerCaptureChanged(boolean hasCapture) {
      super.onPointerCaptureChanged(hasCapture);
   }
}

