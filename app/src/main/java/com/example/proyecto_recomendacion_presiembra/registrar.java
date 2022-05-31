package com.example.proyecto_recomendacion_presiembra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyecto_recomendacion_presiembra.entidades.Usuario;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class registrar extends AppCompatActivity {

   EditText usuario_registrar, contrasena_registar, contrasenaconfirmacion_registar, nombre_r;
   Spinner cultivo_opti,municipio_opcion;
   Button registrarse;
   Button volver;

   String ausuario,anombre;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_registrar);

      nombre_r=(EditText)findViewById(R.id.nombre_r);
      usuario_registrar=(EditText)findViewById(R.id.usuario_registrar);
      contrasena_registar=(EditText)findViewById(R.id.contrasena_registar);
      contrasenaconfirmacion_registar=(EditText)findViewById(R.id.contrasenaconfirmacion_registar);
      municipio_opcion =(Spinner)findViewById(R.id.municipio);
      cultivo_opti=(Spinner)findViewById(R.id.cultivo);


      registrarse=(Button)findViewById(R.id.registrar);
      volver=(Button)findViewById(R.id.volver);


      //Spiner seleccionar municipio
      Spinner spinner_municipios = findViewById(R.id.municipio);
      ArrayAdapter adapter_municipios = ArrayAdapter.createFromResource(
              this,
              R.array.municipios,
              android.R.layout.simple_spinner_item);
      adapter_municipios.setDropDownViewResource(android.R.layout.simple_spinner_item);
      spinner_municipios.setAdapter(adapter_municipios);


      //Spiner seleccionar cultivos
      Spinner spinner_cultivos = findViewById(R.id.cultivo);
      ArrayAdapter adapter_cultivos = ArrayAdapter.createFromResource(
              this,
              R.array.fruits,
              android.R.layout.simple_spinner_item);
      adapter_cultivos.setDropDownViewResource(android.R.layout.simple_spinner_item);
      spinner_cultivos.setAdapter(adapter_cultivos);



// Aciones boton registrarse
      registrarse.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view_registrarse) {

            String reg_nombre=nombre_r.getText().toString();
            String reg_usuario=usuario_registrar.getText().toString();
            String reg_contra=contrasena_registar.getText().toString();
            String reg_contra_rep=contrasenaconfirmacion_registar.getText().toString();
            String reg_muni=municipio_opcion.getSelectedItem().toString();
            String reg_culti=cultivo_opti.getSelectedItem().toString();


            Usuario usera=new Usuario(ausuario,anombre);
            usera.setNombre_usu(ausuario);
            usera.setNombre_usu(anombre);



            if(reg_usuario.isEmpty()|| reg_contra.isEmpty()|| reg_contra_rep.isEmpty()||reg_nombre.isEmpty()){
               Toast.makeText(registrar.this,"Llenar todos los campos",Toast.LENGTH_LONG).show();
            }else{

               if(validarnombre(reg_nombre)==true){
                  Toast.makeText(registrar.this,"Nombre no debe contener numeros",Toast.LENGTH_LONG).show();
               }else {
                  if (reg_contra.length()<6){
                     Toast.makeText(registrar.this,"Contraseña debe ser de mas de 6",Toast.LENGTH_LONG).show();
                  }else{
                     if(validarcontraseña(reg_contra)==true){
                        Toast.makeText(registrar.this,"La contraselña debe tener numeros y letras",Toast.LENGTH_LONG).show();
                     }else{
                        if(reg_contra.equals(reg_contra_rep)){
                           ejecutarServicio("http://192.168.0.10/proyecto_presiembra/register.php");
                           Toast.makeText(registrar.this,"Registro exitoso",Toast.LENGTH_LONG).show();
                           Intent registro= new Intent(registrar.this, activity_menu_principal.class);
                           registro.putExtra("useraRego",reg_usuario);
                           startActivity(registro);
                           finish();
                        }else{
                           Toast.makeText(registrar.this,"la contraseña no coinciden",Toast.LENGTH_LONG).show();
                        }
                     }
                  }
               }
            }
         }
      });

      //Boton regresar inicio sesion

      volver.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view_boton_recomandador) {
            Intent i = new Intent(registrar.this, Activity_inicio_sesion.class);
            startActivity(i);
            finish();
         }
      });
   }


   ////Validar correo
   public boolean validarCorreo(String correo){
      if(correo.indexOf("@")!=-1 && (correo.length()==1)){
         Toast.makeText(this,"Correo no debe empezar por @",Toast.LENGTH_LONG).show();
         return false;
      }else{
         Pattern p= Pattern.compile("[0-9]");
         return true;
      }
   }


   //Validar contraseña
   public boolean validarcontraseña(String contraseña){
      boolean numero= false;
      boolean letras=false;
      for(int x=0;x<contraseña.length();x++){
         char c= contraseña.charAt(x);
         //si no esta entre a y z, ni entre A y Z, ni un espacio
         if(((c>='a' && c<='z') || (c>='A' && c<='Z') || c=='ñ' ||c=='Ñ'
                 || c=='á'|| c=='é'|| c== 'í'|| c=='ó'|| c=='ú'
                 ||c=='Á'|| c=='É'|| c== 'Í'|| c=='Ó'|| c=='Ú')){
            letras =true;
         } if ((c >'0' && c <=9 )){
            numero=true;
         }
      }
      if (numero==true && letras== true){
         return true;
      }
      return false;
   }

   //validar nombre
   public boolean validarnombre(String cadena){
      for(int x=0;x<cadena.length();x++){
         char c= cadena.charAt(x);
         //si no esta entre a y z, ni entre A y Z, ni un espacio
         if(((c>='a' && c<='z') || (c>='A' && c<='Z') || c=='ñ' ||c=='Ñ'
                 || c=='á'|| c=='é'|| c== 'í'|| c=='ó'|| c=='ú'
                 ||c=='Á'|| c=='É'|| c== 'Í'|| c=='Ó'|| c=='Ú')){
            return false;
         }
      }
      return true;
   }



//conexion para envio de datos a php y base de datos Mysql

   private void ejecutarServicio(String URL){
      StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
         @Override
         public void onResponse(String response) {
            Toast.makeText(getApplicationContext(),"Operacion exitosa",Toast.LENGTH_LONG).show();
         }
      }, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
         }
      }) {
         @Nullable
         @Override
         protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> parametros_registro=new HashMap<String,String>();
            parametros_registro.put("nombre_usu",nombre_r.getText().toString());
            parametros_registro.put("correo_usu",usuario_registrar.getText().toString());
            parametros_registro.put("pass_usu",contrasena_registar.getText().toString());
            parametros_registro.put("municipio_usu",municipio_opcion.getSelectedItem().toString());
            parametros_registro.put("cultivo_usu",cultivo_opti.getSelectedItem().toString());
            return parametros_registro;

         }
      };
      RequestQueue requestQueue= Volley.newRequestQueue(this);
      requestQueue.add(stringRequest);

   }
}