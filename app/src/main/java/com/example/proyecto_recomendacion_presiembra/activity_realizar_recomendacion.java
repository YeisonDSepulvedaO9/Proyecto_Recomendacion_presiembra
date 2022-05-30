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

import com.example.proyecto_recomendacion_presiembra.inventory.Data;


import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class activity_realizar_recomendacion extends AppCompatActivity implements View.OnClickListener,CustomSpinner.OnSpinnerEventsListener {

    ImageButton boton_fecha;
    EditText txt_fecha, id;
    TextView TextView_lat, TextView_long;
    Switch switch_gps;

    Button recom_proceso;
    Spinner recom_municipios, recom_cultivos;
    EditText recom_fecha, recom_hectareas;
    TextView recom_cordenadas, recom_ubicacion;


    private int dia, mes, año;
    private View swit_GPS;
    private View view_switch;
    private LocationManager ubicacion;
    double lati = 0, longi = 0;
    LocationManager locationManager;
    String ubicacion_recom;

        private CustomSpinner spinner_cultivos;
        private FruitAdapter adapter;


        String munici,hecta,culti,fech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_recomendacion);

        recom_municipios= (Spinner) findViewById(R.id.recom_spinner_municipio);
        recom_hectareas = (EditText) findViewById(R.id.recom_txt_hectareas);
        recom_cultivos = (Spinner) findViewById(R.id.recom_spinner_cultivos);
        recom_fecha = (EditText) findViewById(R.id.recom_txt_fecha);
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

// Spinner cultivos
        spinner_cultivos = findViewById(R.id.recom_spinner_cultivos);
        spinner_cultivos.setSpinnerEventsListener(this);

        adapter = new FruitAdapter(activity_realizar_recomendacion.this, Data.getFruitList());
        spinner_cultivos.setAdapter(adapter);



        //Boton calendario
        boton_fecha = (ImageButton) findViewById(R.id.calndar_button);
        txt_fecha = (EditText) findViewById(R.id.recom_txt_fecha);
        boton_fecha.setOnClickListener(this);

        //Switch
        switch_gps = (Switch) findViewById(R.id.switch_GPS);
        TextView_lat = (TextView) findViewById(R.id.coord);
        TextView_long = (TextView) findViewById(R.id.ubica);

        recom_proceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_registrarse) {
                ejecutarRecomendacion("http://192.168.0.10/proyecto_presiembra/realizar_recom.php");
                Intent finalreco= new Intent(activity_realizar_recomendacion.this,carga_porgressbar.class);

                String munici,hecta,culti,fech;
                finalreco.putExtra("municipio_recom",recom_municipios.getSelectedItem().toString());
                finalreco.putExtra("hectareas_recom",recom_hectareas.getText().toString());
                finalreco.putExtra("cultivo_recom",recom_cultivos.getSelectedItem().toString());
                finalreco.putExtra("fecha_recom",recom_fecha.getText().toString());
                startActivity(finalreco);
                finish();
            }
        });
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

    // GPS PERMISOS
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
                List<Address> direcion = geocoder.getFromLocation(lati, longi, 1);
                ubicacion_recom= (direcion.get(0).getAddressLine(0));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        recom_cordenadas.setText("Latitud: "+lati+ " Longitud: "+longi);
        recom_ubicacion.setText(ubicacion_recom);
    }

    public static Date sumarDiasAFecha(Date fecha, int dias){
        if (dias==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();

    }

    private void ejecutarRecomendacion(String URL) {
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Recomendacion exitosa",Toast.LENGTH_LONG).show();
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
                String culti_final;
                int caultia= Integer.parseInt(recom_cultivos.getSelectedItem().toString());


                if(caultia==0){
                    culti_final="Arveja";
                } else if (caultia==1){
                    culti_final="Fresa";
                }else {
                    culti_final="Papa";
                }
                Map<String,String> parametros_recomendacion=new HashMap<String,String>();
                String munici,hecta,culti,fech;
                parametros_recomendacion.put("hectareas_recom",hecta=recom_hectareas.getText().toString());
                parametros_recomendacion.put("cultivo_recom",culti=culti_final);
                parametros_recomendacion.put("fecha_recom",fech=recom_fecha.getText().toString());
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
}

