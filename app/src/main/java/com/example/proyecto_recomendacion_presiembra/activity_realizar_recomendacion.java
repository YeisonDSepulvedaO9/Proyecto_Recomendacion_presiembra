package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto_recomendacion_presiembra.Utilidades.Utilidades;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


import java.util.Calendar;

public class activity_realizar_recomendacion extends AppCompatActivity implements View.OnClickListener {

    ImageButton boton_fecha;
    EditText txt_fecha,id;
    TextView TextView_lat, TextView_long;
    Switch switch_gps;

    Button recom_proceso;
    Spinner recom_municipios,recom_cultivos;
    EditText recom_fecha, recom_hectareas;
    ConexionSQLiteHelper conna,conne;


    private int dia, mes, año;
    private View swit_GPS;
    private View view_switch;
    private LocationManager ubicacion;
    double lati=0,longi=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_recomendacion);


        recom_municipios= (Spinner) findViewById(R.id.recom_spinner_municipio);
        recom_hectareas = (EditText) findViewById(R.id.recom_txt_hectareas);
        recom_cultivos = (Spinner) findViewById(R.id.recom_spinner_cultivos);
        recom_fecha = (EditText) findViewById(R.id.recom_txt_fecha);
        recom_proceso= (Button) findViewById(R.id.recom_button_proceso);
        id=(EditText) findViewById(R.id.id);





        //Spiner seleccionar municipio
        Spinner spinner_municipios = findViewById(R.id.recom_spinner_municipio);
        ArrayAdapter adapter_municipios = ArrayAdapter.createFromResource(
                this,
                R.array.municipios,
                android.R.layout.simple_spinner_item);
        adapter_municipios.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_municipios.setAdapter(adapter_municipios);

        //Spiner seleccionar cultivos
        Spinner spinner_cultivos = findViewById(R.id.recom_spinner_cultivos);
        ArrayAdapter adapter_cultivos = ArrayAdapter.createFromResource(
                this,
                R.array.cultivos,
                android.R.layout.simple_spinner_item);
        adapter_cultivos.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_cultivos.setAdapter(adapter_cultivos);

        //Boton calendario

        boton_fecha = (ImageButton) findViewById(R.id.calndar_button);
        txt_fecha = (EditText) findViewById(R.id.recom_txt_fecha);
        boton_fecha.setOnClickListener(this);

        //Switch
        switch_gps = (Switch) findViewById(R.id.switch_GPS);
        TextView_lat = (TextView) findViewById(R.id.textView13);
        TextView_long = (TextView) findViewById(R.id.textView14);
    }
    public void onClick_realizar_report(View view) {
        registrarReporte();
    }
        private void registrarReporte() {

        conne=new ConexionSQLiteHelper(this,"bd_realizar_a1",null,1);
        SQLiteDatabase sqDB=conne.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_MUNICIPIO,recom_municipios.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_HECTAREAS,recom_hectareas.getText().toString());
        values.put(Utilidades.CAMPO_CULTIVO_INTERES,recom_cultivos.getSelectedItem().toString());
        values.put(Utilidades.CAMPO_FECHA,recom_fecha.getText().toString());

        Long idResultante=sqDB.insert(Utilidades.TABLA_REGISTRO,Utilidades.CAMPO_ID_RE_REPORTE,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        sqDB.close();
    }


    // GPS PERMISOS
    public void localizacion() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        }
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //Location loc = ubicacion.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        Location loc = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(ubicacion!=null){

            lati=loc.getLatitude();
            longi= loc.getLongitude();

            Log.d("Latitud",String.valueOf(lati));
            Log.d("Longitud",String.valueOf(longi));
            TextView_lat.setText(String.valueOf(lati));
            TextView_long.setText(String.valueOf(longi));
        }
    }

    //Validar shiwtch para activar GPS
    public void onClick_GPS(View view_switch) {
        this.view_switch = view_switch;
        if (view_switch.getId()==R.id.switch_GPS){
            if (switch_gps.isChecked()){
                localizacion();
            }else {
            }
        }
    }
    @Override
    public void onClick(View viewCalenadario) {
        if (viewCalenadario==boton_fecha){
            final Calendar calendario= Calendar.getInstance();
            dia= calendario.get(Calendar.DAY_OF_MONTH);
            mes= calendario.get(Calendar.MONTH);
            año= calendario.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int año, int mes_año, int dia) {
                    txt_fecha.setText(dia+"-"+(mes_año+1)+"-"+año);

                }
            },año,mes,dia);
            datePickerDialog.show();
            datePickerDialog.getDatePicker().setMinDate(calendario.getTimeInMillis());
        }
    }



}

