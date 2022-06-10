package com.example.proyecto_recomendacion_presiembra;

import static java.lang.Short.valueOf;

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
    int dias_general,dia, mes,años;


    String cultivo;
    String cutltiresu;
    String cultivofin;

    int cultivalor;
    String day,month,year;
    int papa,fresa,arveja;
    String culti_final;
    int dias;
    int cuenta_a,cuenta_f,cuenta_p;

    boolean oaa,oma,oaf,omf,oap,omp,obp;

    String recomendacion;
    double THa,promedio_produccion;


    Intent carga_porgressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_porgressbar);


        TextView titulo1= findViewById(R.id.titulo1);
        TextView titulo2= findViewById(R.id.titulo2);
        TextView fondo= findViewById(R.id.fondotext);


        int tiempo_carga=0;
        tiempo_carga = (int)(Math.random()*2000+4000);
        System.out.println("tiwmpo carga" +
                " "+tiempo_carga);


        String municipo= getIntent().getStringExtra("municipio_recom");
        String hectarea= getIntent().getStringExtra("hectareas_recom");
        String cultivo= getIntent().getStringExtra("cultivo_recom");
        String fecha= getIntent().getStringExtra("fecha_recom");



        System.out.println("municipio "+municipo);
        System.out.println("hectares "+hectarea);
        System.out.println("cultivo "+cultivo);
        System.out.println("fecha "+fecha);
        System.out.println(suma_fecha);
        String day="";

        //findDate(fecha);

        String date=fecha;
        int hecta= Integer.parseInt(hectarea.valueOf(hectarea));
        System.out.println("posibles hectareas"+hecta);



        try {
            int dias= cultivoDias(cultivo);
            String fecha_fin= sumarDiasAFecha(fecha,dias);
            int mes_fin= findDate(sumarDiasAFecha(fecha_fin, dias));
            String oferta= oferta(cultivo,mes_fin);
            double cultiproducc= cultiproduccion(cultivo);
            double valor= produccion(hecta,cultiproducc);

            if(oferta=="Alta"){
                String fecha_finn= sumarDiasAFecha(fecha,120);
                int mes_finn= findDate(sumarDiasAFecha(fecha_fin, 120));
                String recoemndacion= recoemndacionAlea(mes_finn);
                String ofertaa= oferta(cultivo,mes_fin);
                double cultiproduccc= cultiproduccion(cultivo);
                double valorr= produccion(hecta,cultiproduccc);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_carga_porgressbar);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent carga_porgressbar = new Intent(carga_porgressbar.this, Reporte_Recomendacion.class);
                startActivity(carga_porgressbar);
                carga_porgressbar.putExtra("cultivo", getIntent().getStringExtra("cultivo_recom"));
                carga_porgressbar.putExtra("fecha_ini", getIntent().getStringExtra("fecha_recom"));
                carga_porgressbar.putExtra("fecha_final", fecha_final);
                carga_porgressbar.putExtra("productividad", cultivalor);

                finish();


            }
        },tiempo_carga);
    }

    public int cultivoDias(String cultivo) throws ParseException {
        int dias=0;
        if (cultivo.equals("Arveja")) {
             dias = 130;
        } else if (cultivo.equals("Fresa")) {
            dias = 135;
        } else if (cultivo.equals("Papa")) {
            dias = 100;
        } return dias;
    }

    public double cultiproduccion(String cultivo) throws ParseException {
        double HTa=0;
        if (cultivo.equals("Arveja")) {
            HTa = 2;
        } else if (cultivo.equals("Fresa")) {
            HTa = 66.50;
        } else if (cultivo.equals("Papa")) {
            HTa = 20.24;
        } return HTa;
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
        fecha_final=(dia+"/"+(mes)+"/"+año);
        System.out.println("fecha pronostico "+fecha_final);
        return fecha_final;
    }

    public static int findDate(String date)
    {
        // Splitting the given date by '/'
        String dateParts[] = date.split("/");
        String days = dateParts[0];
        String months = dateParts[1];
        String years = dateParts[2];

        int dia= Integer.parseInt(days.valueOf(days));
        int mes= Integer.parseInt(months.valueOf(months));
        int año= Integer.parseInt(years.valueOf(years));



        // Printing the day, month, and year
        System.out.println("Day:--------- " + dia);
        System.out.println("Month: " + mes);
        System.out.println("Year------: " + año);

        return mes;
    }






    public String oferta(String cultivo, int mes) throws ParseException {

        int dias=0;
        String tipoofera = null;
        if (cultivo.equals("Arveja")) {

            int [] Altaarveja={1, 2, 4,6,7, 8, 9, 10};
            int [] Mediaarveja={4, 11, 12};

            boolean oaa = ofertaalta_arveja(Altaarveja, mes);
            boolean oma = ofertamedia_arveja(Mediaarveja, mes);

            if(oma==true ){
                tipoofera="Alta";
            }else if(omf== true){
                tipoofera="Media";
            }
        } else if (cultivo.equals("Fresa")) {

            int [] Altafresa ={1,2,6,7,8,9,11,12};
            int [] Mediafresa={3,4,5,10};

            boolean oaf = ofertaalta_fresa(Altafresa, mes);
            boolean omf = ofertamedia_fresa(Mediafresa, mes);

            String valor;
            ///Papa
            if(oaf==true ){
                tipoofera="Alta";
            }else if(omf== true){
                tipoofera="Media";
            }

        } else if (cultivo.equals("Papa")) {
            int [] Altapapa={7,8,9,10,11,12};
            int [] Mediapapa={1,2,3,6};
            int [] Bajapapa={4,5};

            boolean oap = ofertaalta_papa(Altapapa, mes);
            boolean omp = ofertamedia_papa(Mediapapa, mes);
            boolean obp = ofertabaja_papa(Bajapapa, mes);

            String valor;
            ///Papa
            if(oap==true ){
                tipoofera="Alta";
            }else if(omp== true){
                tipoofera="Media";
            }else if(obp==true){
                tipoofera="Baja";
            }
        }
        return tipoofera;
    }


    public double produccion(int hectareas,double THa){
        System.out.println("prueba hectareas final "+hectareas);
        System.out.println("prueba hectareas final "+THa);
        double promedio_produccion;

        promedio_produccion= hectareas*THa;
        System.out.println("Posible producción"+promedio_produccion+ recomendacion);;
        return promedio_produccion;

    }

    public String recoemndacionAlea(int mes) throws ParseException {


        int [] Altapapa={7,8,9,10,11,12};
        int [] Mediapapa={1,2,3,6};
        int [] Bajapapa={4,5};

        int [] Altaarveja={1, 2, 4,6,7, 8, 9, 10};
        int [] Mediaarveja={4, 11, 12};

        int [] Altafresa ={1,2,6,7,8,9,11,12};
        int [] Mediafresa={3,4,5,10};


        boolean oaa = ofertaalta_arveja(Altaarveja, mes);
        boolean oma = ofertamedia_arveja(Mediaarveja, mes);

        boolean oaf = ofertaalta_fresa(Altafresa, mes);
        boolean omf = ofertamedia_fresa(Mediafresa, mes);

        boolean oap = ofertaalta_papa(Altapapa, mes);
        boolean omp = ofertamedia_papa(Mediapapa, mes);
        boolean obp = ofertabaja_papa(Bajapapa, mes);

        String cultivalor = null;
        ///Papa
        if(oma==true ){
            cultivalor= "Arveja";
        }else if(omf== true){
            cultivalor= "Fresa";
        }else if(obp==true){
            cultivalor="Papa";
        }else if(omp){
            cultivalor="Papa";
        }
        return cultivalor;
    }


    public static boolean ofertaalta_arveja(final int[] Altaarveja, final int month) {
        return ArrayUtils.contains(Altaarveja, month);
    }
    public static boolean ofertamedia_arveja(final int[] Mediaarveja, final int month) {
        return ArrayUtils.contains(Mediaarveja, month);
    }
    public static boolean ofertaalta_fresa(final int[] Altafresa, final int month) {
        return ArrayUtils.contains(Altafresa, month);
    }
    public static boolean ofertamedia_fresa(final int[] Mediafresa, final int month) {
        return ArrayUtils.contains(Mediafresa, month);
    }
    public static boolean ofertaalta_papa(final int[] Altapapa, final int month) {
        return ArrayUtils.contains(Altapapa, month);
    }
    public static boolean ofertamedia_papa(final int[] Mediapapa, int month) {
        return ArrayUtils.contains(Mediapapa, month);
    }
    public static boolean ofertabaja_papa(final int[] Bajapapa, int month) {
        return ArrayUtils.contains(Bajapapa, month);
    }









}