package com.example.proyecto_recomendacion_presiembra.Consulta_recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.proyecto_recomendacion_presiembra.R;
import com.example.proyecto_recomendacion_presiembra.Consulta_recyclerview.adaptador.RecyclerAdapter;
import com.example.proyecto_recomendacion_presiembra.Consulta_recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_recycler extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);


        initViews();
        initValues();
        initListener();
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", "5/4/2023"));
        itemLists.add(new ItemList("Super sayayines 4", "La ultima transformacion de la saga no canon.", "5/4/2023"));
        itemLists.add(new ItemList("Super Sayayiness Blues", "Goku y Vegeta, la transformacion de dioses.", "5/4/2023"));
        itemLists.add(new ItemList("Goku ultrainstinto", "Infaltablñe power-up a Goku.", "5/4/2023"));
        itemLists.add(new ItemList("Super Vegeta Blue x2", "Diferentes transformaciones de super Vegeta.", "5/4/2023"));
        itemLists.add(new ItemList("Vegeta sapbe", "Vegeta sapbe o no sapbe xD.", "5/4/2023"));
        itemLists.add(new ItemList("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", "5/4/2023"));
        itemLists.add(new ItemList("Super sayayines 4", "La ultima transformacion de la saga no canon.", "5/4/2023"));
        itemLists.add(new ItemList("Super Sayayiness Blues", "Goku y Vegeta, la transformacion de dioses.", "5/4/2023"));
        itemLists.add(new ItemList("Goku ultrainstinto", "Infaltablñe power-up a Goku.", "5/4/2023"));
        itemLists.add(new ItemList("Super Vegeta Blue x2", "Diferentes transformaciones de super Vegeta.", "5/4/2023"));
        itemLists.add(new ItemList("Vegeta sapbe", "Vegeta sapbe o no sapbe xD.", "5/4/2023"));

        return itemLists;
    }
























    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
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
