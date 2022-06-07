package com.example.proyecto_recomendacion_presiembra;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.proyecto_recomendacion_presiembra.Spiner.CustomSpinner;
import com.example.proyecto_recomendacion_presiembra.Spiner.CultivoAdapter;
import com.example.proyecto_recomendacion_presiembra.inventory.Datos_custom_spinner;


import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class activity_realizar_recomendacion extends AppCompatActivity implements View.OnClickListener, CustomSpinner.OnSpinnerEventsListener {

    ImageButton boton_fecha;
    TextView TextView_lat, TextView_long,txt_fecha;
    Switch switch_gps;

    Button recom_proceso;
    Spinner recom_municipios, recom_cultivos;
    EditText  recom_hectareas;
    TextView recom_cordenadas,recom_fecha, recom_ubicacion;


    private int dia, mes, año;
    private View swit_GPS;
    private View view_switch;
    private LocationManager ubicacion;
    double lati = 0, longi = 0;
    LocationManager locationManager;
    String ubicacion_recom;

        private CustomSpinner spinner_cultivos;
        private CultivoAdapter adapter;
        String cultivo_final;
        String hecta;


        String munici,culti,fech;
        String rec_municipio,rec_cultivo,rec_fecha,rec_hectraras;
        int rec_culti_fin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_recomendacion);


        recom_municipios= (Spinner) findViewById(R.id.recom_spinner_municipio);
        recom_hectareas = (EditText) findViewById(R.id.recom_txt_hectareas);
        recom_cultivos = (Spinner) findViewById(R.id.recom_spinner_cultivos);
        recom_fecha = (TextView) findViewById(R.id.recom_txt_fecha);
        recom_proceso= (Button) findViewById(R.id.recom_button_proceso);
        recom_cordenadas=(TextView) findViewById(R.id.coord);
        recom_ubicacion=(TextView) findViewById(R.id.ubica);



        //Spiner seleccionar municipio
        Spinner spinner_municipios = findViewById(R.id.recom_spinner_municipio);
        ArrayAdapter adapter_municipios = ArrayAdapter.createFromResource(
                this,
                R.array.municipios,
                android.R.layout.simple_spinner_item);
        adapter_municipios.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_municipios.setAdapter(adapter_municipios);


        // Spinner cultivos personalizado
        spinner_cultivos = findViewById(R.id.recom_spinner_cultivos);
        spinner_cultivos.setSpinnerEventsListener(this);

        adapter = new CultivoAdapter(activity_realizar_recomendacion.this, Datos_custom_spinner.getFruitList());
        spinner_cultivos.setAdapter(adapter);


        //Boton calendario
        boton_fecha = (ImageButton) findViewById(R.id.calndar_button);
        txt_fecha = (TextView) findViewById(R.id.recom_txt_fecha);
        boton_fecha.setOnClickListener(this);

        //Switch
        switch_gps = (Switch) findViewById(R.id.switch_GPS);
        TextView_lat = (TextView) findViewById(R.id.coord);
        TextView_long = (TextView) findViewById(R.id.ubica);

    }

    //Validar shiwtch para activar GPS
    public void onClick_GPS(View view_switch) {
        this.view_switch = view_switch;
        if (view_switch.getId()==R.id.switch_GPS){
            if (switch_gps.isChecked()){
                localizacion();
            }else{
                TextView_lat.setText("");
                TextView_long.setText("");
            }
            return;
        }
    }
    @Override

    //Metodo para boton calendario y obtener una fecha actual o futura
    public void onClick(View viewCalenadario) {
        if (viewCalenadario==boton_fecha){
            final Calendar calendario= Calendar.getInstance();
            dia= calendario.get(Calendar.DAY_OF_MONTH);
            mes= calendario.get(Calendar.MONTH);
            año= calendario.get(Calendar.YEAR);
            hecta =recom_hectareas.getText().toString();

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int año, int mes_año, int dia) {
                    txt_fecha.setText(dia+"/"+(mes_año+1)+"/"+año);
                }
            },año,mes,dia);
            datePickerDialog.show();
            datePickerDialog.getDatePicker().setMinDate(calendario.getTimeInMillis());
        }
    }

    // GPS PERMISOS para obtener coordenadas
    public void localizacion() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}
                    , 1000);
            return;
        }
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        if(ubicacion!=null){

            lati=loc.getLatitude();
            longi= loc.getLongitude();

            Log.d("Latitud",String.valueOf(lati));
            Log.d("Longitud",String.valueOf(longi));

                Geocoder geocoder= new Geocoder(getApplicationContext(), Locale.getDefault());
            try{
                List<Address> direcion = geocoder.getFromLocation(lati, longi,1);
                ubicacion_recom= (direcion.get(0).getAddressLine(0));
                System.out.println(ubicacion_recom);
                recom_cordenadas.setText(ubicacion_recom);

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        recom_ubicacion.setText("Latitud: "+lati+ " Longitud: "+longi);

    }
//Metodo para enviar los datos a la base de datos
    private void ejecutarRecomendacion(String URL) {
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Recomendacion exitosa",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error contactarse con el administrador",Toast.LENGTH_LONG).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros_recomendacion=new HashMap<String,String>();
                parametros_recomendacion.put("municipio_recom",recom_municipios.getSelectedItem().toString());
                parametros_recomendacion.put("hectareas_recom",rec_hectraras);
                parametros_recomendacion.put("cultivo_recom",rec_cultivo);
                parametros_recomendacion.put("fecha_recom",recom_fecha.getText().toString());
                parametros_recomendacion.put("cordenadas_recom",recom_cordenadas.getText().toString());
                parametros_recomendacion.put("ubicacion_recom",recom_ubicacion.getText().toString());
                return parametros_recomendacion;
            }
        };
        RequestQueue requestQueue_recomen= Volley.newRequestQueue(this);
        requestQueue_recomen.add(stringRequest);
    }
    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        spinner_cultivos.setBackground(getResources().getDrawable(R.drawable.bg_spinner_fruit_up));
    }
    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        spinner_cultivos.setBackground(getResources().getDrawable(R.drawable.bg_spinner_fruit));
    }
    public void onClickFinal(View view) {
        rec_municipio= recom_municipios.getSelectedItem().toString();
        rec_fecha= recom_fecha.getText().toString();
        rec_hectraras=recom_hectareas.getText().toString().trim();

//Set error para verificar que realmente llenen todos los campos para una optima recomendacion
        if(rec_hectraras.isEmpty()){
            recom_hectareas.setError("Digitar hectareas del cultivo estimados");
            recom_hectareas.requestFocus();
            return;
        }
        if(rec_fecha.isEmpty()){
            recom_fecha.setError("Seleccionar fecha");
            recom_fecha.requestFocus();
            return;
        }
        else{
            int valorculti = Integer.parseInt(recom_cultivos.getSelectedItem().toString());
            if (valorculti == 0) {
                rec_cultivo = "Arveja";
            } else if (valorculti == 1) {
                rec_cultivo = "Fresa";
            } else if (valorculti == 2) {
                rec_cultivo = "Papa";
            }
            ejecutarRecomendacion("http://192.168.0.10/proyecto_presiembra/realizar_recom.php");
            Intent finalreco = new Intent(activity_realizar_recomendacion.this, carga_porgressbar.class);
            finalreco.putExtra("municipio_recom", rec_municipio);
            finalreco.putExtra("hectareas_recom", rec_hectraras);
            finalreco.putExtra("cultivo_recom", rec_cultivo);
            finalreco.putExtra("fecha_recom", rec_fecha);
            startActivity(finalreco);
            finish();

        }



    }




}

