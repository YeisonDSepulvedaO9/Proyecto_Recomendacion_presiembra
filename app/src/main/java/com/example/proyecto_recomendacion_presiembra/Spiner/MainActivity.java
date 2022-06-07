package com.example.proyecto_recomendacion_presiembra.Spiner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.example.proyecto_recomendacion_presiembra.R;
import com.example.proyecto_recomendacion_presiembra.inventory.Datos_custom_spinner;


public class MainActivity extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {

    private CustomSpinner spinner_fruits;
    private CultivoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_fruits = findViewById(R.id.spinner_fruits);
        spinner_fruits.setSpinnerEventsListener(this);

        adapter = new CultivoAdapter(MainActivity.this, Datos_custom_spinner.getFruitList());
        spinner_fruits.setAdapter(adapter);
    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        spinner_fruits.setBackground(getResources().getDrawable(R.drawable.bg_spinner_fruit_up));
    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        spinner_fruits.setBackground(getResources().getDrawable(R.drawable.bg_spinner_fruit));
    }

}