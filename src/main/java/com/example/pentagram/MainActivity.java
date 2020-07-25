package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //SwipeRefreshLayout sfiMiIndicadorRefresh;
    //ListView lstMiLista;
    //Adapter adaptador;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.paw_dog);
            getSupportActionBar().setTitle(R.string.app_name);
        }

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        LlenarMascotas();
        iniAdaptador();
    }

    private void iniAdaptador() {
        MascotaAdaptador adapt = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adapt);
    }

    public void LlenarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Filurais",R.drawable.loro,4));
        mascotas.add(new Mascota("Filurais",R.drawable.hamster,1));
        mascotas.add(new Mascota("Filurais",R.drawable.canario,2));
        mascotas.add(new Mascota("Bunny",R.drawable.mascota3,5));
        mascotas.add(new Mascota("Filurais",R.drawable.mascota1,2));
        mascotas.add(new Mascota("Tom",R.drawable.mascota2,3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate ( R.menu.barra, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId ()){
            case R.id.estrella:
                //Toast.makeText ( this,"ranquet",Toast.LENGTH_SHORT ).show ();
                Intent intent = new Intent(this, Mascotasfavoritos.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected ( item );
        }
        return true;
    }
}