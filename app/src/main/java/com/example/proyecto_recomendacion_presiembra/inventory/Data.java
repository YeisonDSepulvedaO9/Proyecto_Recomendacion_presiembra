package com.example.proyecto_recomendacion_presiembra.inventory;
import com.example.proyecto_recomendacion_presiembra.R;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Cultivos> getFruitList() {
        List<Cultivos> cultivosList = new ArrayList<>();

        Cultivos Arveja = new Cultivos();
        Arveja.setName("Arveja");
        Arveja.setImage(R.drawable.arveja);
        cultivosList.add(Arveja);

        Cultivos Fresa = new Cultivos();
        Fresa.setName("Fresa");
        Fresa.setImage(R.drawable.fresa);
        cultivosList.add(Fresa);

        Cultivos Papa = new Cultivos();
        Papa.setName("Papa");
        Papa.setImage(R.drawable.potato);
        cultivosList.add(Papa);
        return cultivosList;
    }

    public static List<Municipios> getMunicipios() {
        List<Municipios>municipiostList = new ArrayList<>();

        Municipios Soacha = new Municipios();
        Soacha.setMunicipio("Soacha");

        Municipios Sibate = new Municipios();
        Sibate.setMunicipio("Sibate");

        return municipiostList;
    }

}
