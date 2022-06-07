package com.example.proyecto_recomendacion_presiembra.recyclerview.retrofit_data;

import com.example.proyecto_recomendacion_presiembra.recyclerview.model.ItemList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {
    @GET("getItemsDB.php")
    Call<List<ItemList>> getItemsDB();
}
