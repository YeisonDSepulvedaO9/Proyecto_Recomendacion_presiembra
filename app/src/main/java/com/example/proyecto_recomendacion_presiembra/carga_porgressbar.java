package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;


import com.google.android.gms.common.util.ArrayUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class carga_porgressbar extends AppCompatActivity {

    int tiempo_carga;
    Date suma_fecha;
    String fecha_final;
    int dia, mes,años;


    String cultivo;
    String cutltiresu;
    String cultivofin;

    int cultivalor;
    String day,month,year;
    int papa,fresa,arveja;
    String culti_final;
    int dias;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_porgressbar);


        TextView titulo1= findViewById(R.id.titulo1);
        TextView titulo2= findViewById(R.id.titulo2);
        TextView fondo= findViewById(R.id.fondotext);


        int tiempo_carga=0;
        tiempo_carga = (int)(Math.random()*4000+7000);
        System.out.println("tiwmpo carga" +
                " "+tiempo_carga);


        String municipo= getIntent().getStringExtra("municipio_recom");
        String hectarea= getIntent().getStringExtra("hectareas_recom");
        String cultivo= getIntent().getStringExtra("cultivo_recom");
        String fecha= getIntent().getStringExtra("fecha_recom");

/*
        Proceso_recomendacion arveja_proceso= new Proceso_recomendacion(municipo,hectarea,cultivo,fecha,dias);
        arveja_proceso.setCultivo(cultivo);
        arveja_proceso.setMunicipio(municipo);
        arveja_proceso.setHectareas(hectarea);
        arveja_proceso.setFecha(fecha);
        arveja_proceso.setDias(135);
        try {
            arveja_proceso.sumarDiasAFecha(fecha,135);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Proceso_recomendacion fresa_proceso= new Proceso_recomendacion(municipo,hectarea,cultivo,fecha,dias);
        fresa_proceso.setCultivo(cultivo);
        fresa_proceso.setMunicipio(municipo);
        fresa_proceso.setHectareas(hectarea);
        fresa_proceso.setFecha(fecha);
        fresa_proceso.setDias(135);

        Proceso_recomendacion papa_proceso= new Proceso_recomendacion(municipo,hectarea,cultivo,fecha,dias);
        papa_proceso.setCultivo(cultivo);
        papa_proceso.setMunicipio(municipo);
        papa_proceso.setHectareas(hectarea);
        papa_proceso.setFecha(fecha);
        papa_proceso.setDias(100);

*/

        System.out.println("municipio "+municipo);
        System.out.println("hectares "+hectarea);
        System.out.println("cultivo "+cultivo);
        System.out.println("fecha "+fecha);
        System.out.println(suma_fecha);
        String day="";


        int cultiselect = (int) (Math.random() * (3 - 1)) + 1;
        String date = fecha;

        try {
            sumarDiasAFecha(date, 130);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        findDate(date);




        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_carga_porgressbar);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent carga_porgressbar = new Intent(carga_porgressbar.this, Reporte_Recomendacion.class);
                startActivity(carga_porgressbar);
                finish();
            }
        },tiempo_carga);
    }



    public String sumarDiasAFecha(String fecha, int dias) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaActual = new Date();
        Date fecha_fin = formato.parse(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha_fin);
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        suma_fecha= calendar.getTime();
        System.out.println("Suma es" + (suma_fecha));


        int año = calendar.get(Calendar.YEAR);
        mes= calendar.get(Calendar.MONTH)+1;
        int dia= calendar.get(Calendar.DAY_OF_MONTH);
        String fecha_final=(dia+"/"+(mes+1)+"/"+año);
        System.out.println(fecha_final);
        return fecha_final;



    }


    // Funcion obtener fecha

    public static void findDate(String date)
    {
        // Splitting the given date by '-'
        String dateParts[] = date.split("/");
        String daya = dateParts[0];
        String montha = dateParts[1];
        String yeara = dateParts[2];



        // Printing the day, month, and year
        System.out.println("Day: " + daya);
        System.out.println("Month: " + montha);
        System.out.println("Year: " + yeara);

    }


    int cuenta=0;
        public void calculo(String date, String cultivo ,String hectarea){

        String dateParts[] = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];
            System.out.println(" prueba de veracidada"+day);
            System.out.println(" prueba de veracidada"+month);
        System.out.println(" prueba de veracidada"+year);



        String culti_final;
        if(cultivalor==0){
            culti_final="Arveja";
            System.out.print(culti_final);
        } else if (cultivalor==1){
            culti_final="Fresa";
            System.out.print(culti_final);
        }else {
            culti_final="Papa";
            System.out.print(culti_final);
        }

        //String datos

        String [] Altaarveja={"1", "2", "3","6","7", "8", "9", "10"};
        String [] Mediaarveja={"4", "11", "12"};

        String [] Altafresa ={"1","2","6","7", "8","9","11", "12"};
        String [] Mediafresa={"3","4","5","10"};

        String [] Altapapa={"7", "8", "9", "10", "11", "12"};
        String [] Mediapapa={"1", "2", "3", "6"};
        String [] Bajapapa={"4", "5"};


        boolean general=false;

        //Boleanos nomenclatura  1valor= oferta ;2valor= tipo oferta(alta,media,baja); 3valor= cultivo(a=arveja,f=fresa,p=papa)

        boolean oaa = ofertaalta_arveja(Altapapa, month);
        boolean oma = ofertamedia_arveja(Mediapapa, month);

        boolean oaf = ofertaalta_fresa(Altapapa, month);
        boolean omf = ofertamedia_fresa(Mediapapa, month);

        boolean oap = ofertaalta_papa(Altapapa, month);
        boolean omp = ofertamedia_papa(Mediapapa, month);
        boolean obp = ofertabaja_papa(Bajapapa, month);

        String valor;
        int cuenta_a=0,cuenta_f=0,cuenta_p=0;
        ////Arveja
        if(oaa==true ){
            System.out.println("alta "+month+"? \n"+oaa);
            cuenta_a=+1;
        }else if(oma== true){
            System.out.println("Media "+month+"? \n"+oma);
            cuenta_a=+2;
        }

        System.out.println(suma_fecha);

        //Fresa
        if(oaf==true ){
            System.out.println("alta "+month+"? \n"+oaf);
            cuenta_f=+1;
        }else if(omf== true){
            cuenta_f=+2;
            System.out.println("Media "+month+"? \n"+omf);
        }

        ///Papa
        if(oap==true ){
            System.out.println("alta "+month+"? \n"+obp);
            cuenta_p=+1;
        }else if(omp== true){
            System.out.println("Media "+month+"? \n"+omp);
            cuenta_p=+2;
        }else if(oap==true){
            System.out.println("baja "+month+"? \n"+oap);
            cuenta_p=+3;
        }


        String recomendacion;

        if(cuenta_a>cuenta_f&&cuenta_f>cuenta_p){
            recomendacion="Arveja";

        }else if(cuenta_f>cuenta_p && cuenta_p>cuenta_a){
            System.out.print("Recomencionda fresa");
            recomendacion="Arveja";
        }else{
            System.out.println("papa");
        }



    }


    public static boolean ofertaalta_arveja(final String[] Altaarveja, final String month) {
        return ArrayUtils.contains(Altaarveja, month);
    }
    public static boolean ofertamedia_arveja(final String[] Mediafresa, final String month) {
        return ArrayUtils.contains(Mediafresa, month);
    }
    public static boolean ofertaalta_fresa(final String[] Altafresa, final String month) {
        return ArrayUtils.contains(Altafresa, month);
    }
    public static boolean ofertamedia_fresa(final String[] Mediafresa, final String month) {
        return ArrayUtils.contains(Mediafresa, month);
    }
    public static boolean ofertaalta_papa(final String[] Altapapa, final String month) {
        return ArrayUtils.contains(Altapapa, month);
    }
    public static boolean ofertamedia_papa(final String[] Mediapapa, final String month) {
        return ArrayUtils.contains(Mediapapa, month);
    }
    public static boolean ofertabaja_papa(final String[] Bajapapa, final String month) {
        return ArrayUtils.contains(Bajapapa, month);
    }








}