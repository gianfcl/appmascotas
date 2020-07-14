package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        View rlstar = miActionBar.findViewById(R.id.rlestrella);
        rlstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, Mascotasfavoritos.class);
                startActivity(intento);
            }
        });
        //setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        LlenarMascotas();
        iniAdaptador();

        /*agregarFAB();

        sfiMiIndicadorRefresh =  (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
        */

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

    public void refrescandoContenido(){
        /*
        sfiMiIndicadorRefresh =  (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiLista);
        sfiMiIndicadorRefresh.setRefreshing(false);
         */
    }

    public void agregarFAB(){
        /*
        FloatingActionButton miFAB=(FloatingActionButton) findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,getResources().getString(R.string.mensaje),Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR","Click aquí");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
        */
    }
}