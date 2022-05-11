package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_inicio_sesion extends AppCompatActivity implements View.OnClickListener {

    EditText inicio;
    EditText password;
    Button sesion;
    Button registrar;
    Button invitado;
    daUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        inicio = findViewById(R.id.inicio_sesion);
        password = findViewById(R.id.Password_sesion);
        sesion = (Button) findViewById((R.id.sesion_i));
        registrar = (Button) findViewById(R.id.re);
        invitado = (Button) findViewById(R.id.invitado);

        sesion.setOnClickListener(this);
        registrar.setOnClickListener(this);
        invitado.setOnClickListener(this);
        dao = new daUsuario(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.sesion_i:
                String u = inicio.getText().toString();
                String p = password.getText().toString();
                if (u.equals("") && p.equals("")) {

                    Toast.makeText(this, "ERROR: campos vacios", Toast.LENGTH_LONG).show();

                } else if (dao.login(u, p) == 1) {
                    usuario ux = dao.getUsuario(u, p);
                    Toast.makeText(this, "Datos correctos , bienvenido", Toast.LENGTH_LONG).show();
                    Intent i3 = new Intent(Activity_inicio_sesion.this, Activity_menu.class);
                    i3.putExtra("id", ux.getId());
                    startActivity(i3);

                } else {
                    Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.re:
                Intent i = new Intent(Activity_inicio_sesion.this, registrar.class);
                startActivity(i);
                finish();
                break;


            case R.id.invitado:
                Intent i4 = new Intent(Activity_inicio_sesion.this, registrar.class);
                startActivity(i4);
                finish();
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}