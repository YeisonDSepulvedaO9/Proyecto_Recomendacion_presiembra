package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
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

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


import java.util.Calendar;

public class activity_realizar_recomendacion extends AppCompatActivity implements View.OnClickListener {

    ImageButton boton_fecha;
    Button boton_proceso;
    Spinner S_recom_municipios,S_recom_cultivos;
    EditText ET_recom_fecha, ET_recom_hectareas;
    TextView TextView_lat, TextView_long;
    Switch switch_gps;
    DBHelpera DB;

    private int dia, mes, año;
    private View swit_GPS;
    private View view_switch;
    private LocationManager ubicacion;
    double lati=0,longi=0;

    private GoogleMap nMap;
    private Marker marcador;
    double lat=0.0, lng= 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_recomendacion);


        S_recom_municipios= findViewById(R.id.S_recom_municipios);
        ET_recom_hectareas = findViewById(R.id.ET_recom_hectareas);
        S_recom_cultivos = findViewById(R.id.S_recom_cultivos);
        ET_recom_fecha = findViewById(R.id.ET_recom_fecha);
        boton_proceso= findViewById(R.id.B_recom_proceso);
        DB = new DBHelpera(this);


        //Spiner seleccionar municipio
        Spinner spinner_municipios = findViewById(R.id.S_recom_municipios);
        ArrayAdapter adapter_municipios = ArrayAdapter.createFromResource(
                this,
                R.array.municipios,
                android.R.layout.simple_spinner_item);
        adapter_municipios.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_municipios.setAdapter(adapter_municipios);

        //Spiner seleccionar cultivos
        Spinner spinner_cultivos = findViewById(R.id.S_recom_cultivos);
        ArrayAdapter adapter_cultivos = ArrayAdapter.createFromResource(
                this,
                R.array.cultivos,
                android.R.layout.simple_spinner_item);
        adapter_cultivos.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_cultivos.setAdapter(adapter_cultivos);

        //Boton calendario

        boton_fecha = (ImageButton) findViewById(R.id.calndar_button);
        ET_recom_fecha = (EditText) findViewById(R.id.ET_recom_fecha);
        boton_fecha.setOnClickListener(this);

        //Switch
        switch_gps = (Switch) findViewById(R.id.switch_GPS);
        TextView_lat = (TextView) findViewById(R.id.textView13);
        TextView_long = (TextView) findViewById(R.id.textView14);

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

    //Calendario
    public void onClick(View viewCalenadario) {
        if (viewCalenadario==boton_fecha){
            final Calendar calendario= Calendar.getInstance();
            dia= calendario.get(Calendar.DAY_OF_MONTH);
            mes= calendario.get(Calendar.MONTH);
            año= calendario.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int año, int mes_año, int dia) {
                    ET_recom_fecha.setText(dia+"-"+(mes_año+1)+"-"+año);
                }
            },año,mes,dia);
            datePickerDialog.show();
        }
    }

}

