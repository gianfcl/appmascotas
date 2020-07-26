package com.example.pentagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.pojo.Mascota;
import com.example.pentagram.R;
import com.example.pentagram.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reycleview,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        LlenarMascotas();
        iniAdaptador();
        return v;
    }

    private void iniAdaptador() {
        MascotaAdaptador adapt = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adapt);
    }

    public void LlenarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Skully",R.drawable.loro,4));
        mascotas.add(new Mascota("Rhino",R.drawable.hamster,1));
        mascotas.add(new Mascota("Piolin",R.drawable.canario,2));
        mascotas.add(new Mascota("Bunny",R.drawable.mascota3,5));
        mascotas.add(new Mascota("Filurais",R.drawable.mascota1,2));
        mascotas.add(new Mascota("Tom",R.drawable.mascota2,3));
    }
}
