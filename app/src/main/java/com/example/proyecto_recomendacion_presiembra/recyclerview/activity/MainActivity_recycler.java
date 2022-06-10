package com.example.proyecto_recomendacion_presiembra.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyecto_recomendacion_presiembra.Perfil;
import com.example.proyecto_recomendacion_presiembra.R;
import com.example.proyecto_recomendacion_presiembra.activity_menu_principal;
import com.example.proyecto_recomendacion_presiembra.recyclerview.adaptador.RecyclerAdapter;
import com.example.proyecto_recomendacion_presiembra.recyclerview.model.ItemList;
import com.example.proyecto_recomendacion_presiembra.recyclerview.retrofit_data.RetrofitApiService;
import com.example.proyecto_recomendacion_presiembra.recyclerview.retrofit_data.RetrofitClient;

import java.util.List;

public class MainActivity_recycler extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;
    private RetrofitApiService retrofitApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        initViews();
        initValues();
        initListener();

        Button regresar= (Button) findViewById(R.id.regresar_historial);
        regresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view_boton_perfil) {
                Intent B_perf= new Intent(MainActivity_recycler.this, activity_menu_principal.class);
                startActivity(B_perf);
                finish();
            }
        });
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        retrofitApiService = RetrofitClient.getApiService();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        getItemsSQL();
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }
        private void getItemsSQL() {
        retrofitApiService.getItemsDB().enqueue(new Callback<List<ItemList>>() {
            @Override
            public void onResponse(Call<List<ItemList>> call, Response<List<ItemList>> response) {
                items = response.body();
                adapter = new RecyclerAdapter(items, MainActivity_recycler.this);
                rvLista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ItemList>> call, Throwable t) {
                Toast.makeText(MainActivity_recycler.this, "Error: "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, com.example.proyecto_recomendacion_presiembra.consu_detalle.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
