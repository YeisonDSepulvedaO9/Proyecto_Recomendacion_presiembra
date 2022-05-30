package com.example.proyecto_recomendacion_presiembra;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.google.android.gms.common.util.ArrayUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class carga_porgressbar extends AppCompatActivity {
    int tiempo_carga;
    Date suma_fecha;
    String cultivo;
    String cutltiresu;
    String cultivofin;
    int cultivalor;
    String day,month,year;
    int papa,fresa,arveja;
    String culti_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_porgressbar);

        TextView titulo1= findViewById(R.id.titulo1);
        TextView titulo2= findViewById(R.id.titulo2);
        TextView fondo= findViewById(R.id.fondotext);
        int tiempo_carga=0;
        tiempo_carga = (int)(Math.random()*4000+7000);
        System.out.println("tiwmpo "+tiempo_carga);


        String municipo= getIntent().getStringExtra("municipio_recom");
        String hectarea= getIntent().getStringExtra("useraRego");
        String cultivo= getIntent().getStringExtra("cultivo_recom");
        String fecha= getIntent().getStringExtra("fecha_recom");

        int cultivalor=  Integer.parseInt(cultivo);
        int hectareavalor=  Integer.parseInt(cultivo);


        System.out.println("municipio "+municipo);
        System.out.println("hectares "+hectarea);
        System.out.println("cultivo "+cultivo);
        System.out.println("fecha "+fecha);
        String day="";


        int cultiselect = (int) (Math.random() * (3 - 1)) + 1;
        String date = fecha;
        System.out.println(cultiselect);


        try {
            sumarDiasAFecha(date, 120);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        findDate(date);
        calculo(date,cultivalor,hectareavalor);


         String cultiresu="";
        if(cultiselect==1){
            cutltiresu="Arveja";
        }else if(cultiselect==2){
            cutltiresu="Fresa";
        }else{
            cutltiresu="papa";
            return;
        }


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
    public static Date sumarDiasAFecha(String fecha, int dias) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaActual = new Date();
        Date fecha_fin = formato.parse(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha_fin);
        calendar.add(Calendar.DAY_OF_MONTH, dias);
        Date suma_fecha= calendar.getTime();
        System.out.println("Suma es" + (suma_fecha));
        return suma_fecha;
    }
    

    // Funcion obtener fecha

    public static void findDate(String date)
    {
        // Splitting the given date by '-'
        String dateParts[] = date.split("-");
        String daya = dateParts[0];
        String montha = dateParts[1];
        String yeara = dateParts[2];


        // Printing the day, month, and year
        System.out.println("Day: " + daya);
        System.out.println("Month: " + montha);
        System.out.println("Year: " + yeara);



    }
int cuenta=0;
    public void calculo(String date, int cultivalor,int hectareavalor){

        String dateParts[] = date.split("-");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];



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