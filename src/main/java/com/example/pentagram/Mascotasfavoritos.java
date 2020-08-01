package com.example.pentagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.pentagram.adapter.TopMascotaAdaptador;
import com.example.pentagram.db.BaseDatos;
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public class Mascotasfavoritos extends AppCompatActivity {

    ArrayList<Mascota> topmascotas;
    private RecyclerView listaTopMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotasfavoritos);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        if (miActionBar!=null){
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listaTopMascotas = (RecyclerView) findViewById(R.id.rvTopMascotas);
        listaTopMascotas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaTopMascotas.setLayoutManager(llm);
        LlenarMascotas();
        iniAdaptador();
    }

    private void iniAdaptador() {
        TopMascotaAdaptador adapt = new TopMascotaAdaptador(topmascotas,this);
        listaTopMascotas.setAdapter(adapt);
    }

    public void LlenarMascotas(){
        BaseDatos db = new BaseDatos(this);
        topmascotas = db.obtenerDatosTopMascotas();
    }
}