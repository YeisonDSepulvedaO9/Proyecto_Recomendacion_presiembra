package com.example.proyecto_recomendacion_presiembra.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_recomendacion_presiembra.R;
import com.example.proyecto_recomendacion_presiembra.recyclerview.model.ItemList;

public class DetailActivity extends AppCompatActivity {
    private ItemList itemDetail;
    private TextView tvIdDetail;
    private TextView tvTituloDetail;
    private TextView tvFechaInicioDetail;
    private TextView tvFechaFinalDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recycler);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews() {
        tvIdDetail = findViewById(R.id.tvid);
        tvTituloDetail = findViewById(R.id.tvTituloDetail);
        tvFechaInicioDetail = findViewById(R.id.tvFechaInicioDetail);
        tvFechaFinalDetail = findViewById(R.id.tvFechaFinalDetail);
    }

    private void initValues(){
        itemDetail = (ItemList) getIntent().getExtras().getSerializable("itemDetail");

        tvTituloDetail.setText(itemDetail.getTitulo());
        tvFechaInicioDetail.setText(itemDetail.getFechainicio());
        tvFechaFinalDetail.setText(itemDetail.getFechafinal());
    }
}
