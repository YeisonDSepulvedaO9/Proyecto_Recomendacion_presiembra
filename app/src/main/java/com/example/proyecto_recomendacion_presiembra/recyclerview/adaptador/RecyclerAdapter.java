package com.example.proyecto_recomendacion_presiembra.recyclerview.adaptador;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_recomendacion_presiembra.recyclerview.model.ItemList;
import com.example.proyecto_recomendacion_presiembra.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private List<ItemList> items;
    private List<ItemList> originalItems;
    private RecyclerItemClick itemClick;


    public RecyclerAdapter(List<ItemList> items, RecyclerItemClick itemClick) {
        this.items = items;
        this.itemClick = itemClick;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(items);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view_recycler, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, final int position) {
        final ItemList item = items.get(position);

        holder.tvid.setText(item.getId());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvFechaInicio.setText(item.getFechainicio());
        holder.tvFechaFinal.setText(item.getFechafinal());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void filter(final String strSearch) {
        if (strSearch.length() == 0) {
            items.clear();
            items.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items.clear();
                List<ItemList> collect = originalItems.stream()
                        .filter(i -> i.getTitulo().toLowerCase().contains(strSearch.toLowerCase()))
                        .collect(Collectors.toList());

                items.addAll(collect);
            }
            else {
                items.clear();
                for (ItemList i : originalItems) {
                    if (i.getTitulo().toLowerCase().contains(strSearch)) {
                        items.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }




    public class RecyclerHolder extends RecyclerView.ViewHolder {

        private TextView tvTitulo;
        private TextView tvid;
        private TextView tvFechaInicio;
        private TextView tvFechaFinal;

        public RecyclerHolder(@NonNull View itemView_1) {
            super(itemView_1);

            tvid = itemView.findViewById(R.id.tvid);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvFechaInicio = itemView.findViewById(R.id.tvFechaInicio);
            tvFechaFinal = itemView.findViewById(R.id.tvFechaFinal);

        }
    }

    public interface RecyclerItemClick {
        void itemClick(ItemList item);
    }
}
