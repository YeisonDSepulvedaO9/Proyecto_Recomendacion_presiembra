package com.example.proyecto_recomendacion_presiembra.Spiner;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_recomendacion_presiembra.R;
import com.example.proyecto_recomendacion_presiembra.inventory.Cultivos;

import java.util.List;

public class CultivoAdapter extends BaseAdapter {
    private Context context;
    private List<Cultivos> cultivosList;

    public CultivoAdapter(Context context, List<Cultivos> cultivosList) {
        this.context = context;
        this.cultivosList = cultivosList;
    }

    @Override
    public int getCount() {
        return cultivosList != null ? cultivosList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_cultivos, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);
        ImageView image = rootView.findViewById(R.id.image);

        txtName.setText(cultivosList.get(i).getName());
        image.setImageResource(cultivosList.get(i).getImage());

        return rootView;
    }
}
