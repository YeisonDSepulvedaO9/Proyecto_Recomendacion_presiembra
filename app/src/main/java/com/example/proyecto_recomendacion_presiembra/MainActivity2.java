package com.example.proyecto_recomendacion_presiembra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proyecto_recomendacion_presiembra.entidades.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerViewReco;
    recomendacion_adapter recomendacion_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inicializarElemento();
    }
    private void inicializarElemento(){
        recyclerViewReco= findViewById(R.id.recyclerUser);
        recyclerViewReco.setLayoutManager(new LinearLayoutManager(this));


        List<User> userList=new ArrayList<>();
        for(int i=0;i<20;i++){
            userList.add(new User(i,"Kalie","Fresa","Alta"));
        }

        recomendacion_adapter = new recomendacion_adapter(userList,this);

    }
}