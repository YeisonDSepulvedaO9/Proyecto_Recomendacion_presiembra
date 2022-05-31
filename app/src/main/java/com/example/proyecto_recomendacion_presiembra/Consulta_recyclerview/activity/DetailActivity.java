package com.example.proyecto_recomendacion_presiembra.Consulta_recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_recomendacion_presiembra.R;
import com.example.proyecto_recomendacion_presiembra.Consulta_recyclerview.model.ItemList;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgItemDetail;
    private TextView tvTituloDetail;
    private TextView tvDescripcionDetail;
    private TextView tvidtDetail;
    private ItemList itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews() {
        imgItemDetail = findViewById(R.id.imgItemDetail);
        tvTituloDetail = findViewById(R.id.tvTituloDetail);
        tvDescripcionDetail = findViewById(R.id.tvDescripcionDetail);
        tvidtDetail= findViewById(R.id.tvidtDetail);
    }

    private void initValues(){
        itemDetail = (ItemList) getIntent().getExtras().getSerializable("itemDetail");


        tvTituloDetail.setText(itemDetail.getCultivo_name());
        tvDescripcionDetail.setText(itemDetail.getFecha_inicio());
        tvidtDetail.setText(itemDetail.getFecha_final());
    }
}
