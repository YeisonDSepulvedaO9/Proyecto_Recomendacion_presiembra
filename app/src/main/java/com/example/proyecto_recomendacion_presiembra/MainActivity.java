package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText idrecomendacion, hectareas,cultivo_r, fecha;
    Button insert, update, delete, view;
    Spinner municipio;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idrecomendacion = findViewById(R.id.recomendacion_r);
        municipio = findViewById(R.id.contact_municipio);
        hectareas = findViewById(R.id.dob);
        cultivo_r = findViewById(R.id.cultivo_t);
        fecha = findViewById(R.id.fecha);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);

// Spinner
        Spinner spinner_municipiosrr = findViewById(R.id.contact_municipio);
        ArrayAdapter adapter_municipiosrr = ArrayAdapter.createFromResource(
                this,
                R.array.municipios,
                android.R.layout.simple_spinner_item);
        adapter_municipiosrr.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_municipiosrr.setAdapter(adapter_municipiosrr);

        //INSERTAR
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recomenTXT = idrecomendacion.getText().toString();
                String muciptTXT = spinner_municipiosrr.getSelectedItem().toString();;
                String hectTXT = hectareas.getText().toString();
                String cultTXT = cultivo_r.getText().toString();
                String fechaTXT = fecha.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(recomenTXT, muciptTXT, hectTXT, cultTXT,fechaTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "Nueva entrada insertada", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Nueva entrada no insertada", Toast.LENGTH_SHORT).show();
            }        });

        //ACTUALIZAR
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recomenTXT = idrecomendacion.getText().toString();
                String muciptTXT = municipio.getSelectedItem().toString();
                String hectTXT = hectareas.getText().toString();
                String cultTXT = cultivo_r.getText().toString();
                String fechaTXT = fecha.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(recomenTXT, muciptTXT, hectTXT,cultTXT, fechaTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "Entrada actualizada", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Nueva Entrada no actualizada", Toast.LENGTH_SHORT).show();
            }        });

        //ELIMINAR
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recomenTXT = idrecomendacion.getText().toString();
                Boolean checkudeletedata = DB.deletedata(recomenTXT);
                if(checkudeletedata==true)
                    Toast.makeText(MainActivity.this, "Entrada eliminada", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entrada no eliminada", Toast.LENGTH_SHORT).show();
            }        });

        //CONSULTAR
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No existe ese registro", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Recomendacion :"+res.getString(0)+"\n");
                    buffer.append("Municipio :"+res.getString(1)+"\n");
                    buffer.append("Hectareas :"+res.getString(2)+"\n");
                    buffer.append("Cultivo interés :"+res.getString(3)+"\n");
                    buffer.append("Fecha :"+res.getString(4)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Registros");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}
