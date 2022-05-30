package com.example.proyecto_recomendacion_presiembra.inventory;
import com.example.proyecto_recomendacion_presiembra.R;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Fruit> getFruitList() {
        List<Fruit> fruitList = new ArrayList<>();

        Fruit Avocado = new Fruit();
        Avocado.setName("Arveja");
        Avocado.setImage(R.drawable.arveja);
        fruitList.add(Avocado);

        Fruit Banana = new Fruit();
        Banana.setName("Fresa");
        Banana.setImage(R.drawable.fresa);
        fruitList.add(Banana);

        Fruit Coconut = new Fruit();
        Coconut.setName("Papa");
        Coconut.setImage(R.drawable.potato);
        fruitList.add(Coconut);

        return fruitList;
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
