package com.example.proyecto_recomendacion_presiembra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_recomendacion_presiembra.entidades.User;

import java.util.List;

public class recomendacion_adapter extends RecyclerView.Adapter<recomendacion_adapter.ViewHolder> {

    public recomendacion_adapter(List<User> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    private List<User>usersList;
    private Context context;




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id_book.setText(usersList.get(position).getIdusuer());
        holder.cultivo_book.setText(usersList.get(position).getCultivoreco());
        holder.fecha_book.setText(usersList.get(position).getRentabilida());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id_book;
        private TextView cultivo_book;
        private TextView fecha_book;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_book= itemView.findViewById(R.id.book_id_txt);
            cultivo_book= itemView.findViewById(R.id.cultivo_text_book);
            fecha_book= itemView.findViewById(R.id.fecha_text_book);

        }
    }
}
