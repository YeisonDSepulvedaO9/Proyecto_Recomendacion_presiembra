package com.example.proyecto_recomendacion_presiembra.consultas;

import com.example.proyecto_recomendacion_presiembra.recyclerview.model.ItemList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {
    @GET("perfil.php")
    Call<List<ItemList>> getuserDB();
}
