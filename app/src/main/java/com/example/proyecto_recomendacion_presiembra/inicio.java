package com.example.proyecto_recomendacion_presiembra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class inicio extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout= findViewById(R.id.frmlinicio);
        navigationView= findViewById(R.id.nvView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,(R.string.open),R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager= getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frgprincipal,new menu_cultivos());
        fragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.info_arve:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frgprincipal, new arveja_menu_fragmento());
                fragmentTransaction.commit();
                break;

            case R.id.info_fresa:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frgprincipal, new fresa_menu_fragment());
                fragmentTransaction.commit();
                break;

            case R.id.info_papa:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frgprincipal, new papa_menu_fragment());
                fragmentTransaction.commit();
                break;

            case R.id.info_menu:
                Intent info_menu= new Intent(this, activity_menu_principal.class);
                startActivity(info_menu);
                finish();
                break;

            case R.id.info_recomendacion:
                Intent info_recomendacion= new Intent(this, activity_realizar_recomendacion.class);
                startActivity(info_recomendacion);
                finish();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}