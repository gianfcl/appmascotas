package com.example.pentagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.R;
import com.example.pentagram.pojo.Mascota;
import com.example.pentagram.adapter.MiMascotAdaptor;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {

    ArrayList<Mascota> mimascotafotos;
    private RecyclerView listaFotosMiMascota;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        listaFotosMiMascota = (RecyclerView) v.findViewById(R.id.rvFotos);
        listaFotosMiMascota.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        listaFotosMiMascota.setLayoutManager(glm);
        LlenarMascotas2();
        iniAdaptador2();
        return v;
    }

    private void iniAdaptador2() {
        MiMascotAdaptor adapt = new MiMascotAdaptor(mimascotafotos,getActivity());
        listaFotosMiMascota.setAdapter(adapt);
    }

    public void LlenarMascotas2(){
        mimascotafotos = new ArrayList<Mascota>();

        mimascotafotos.add(new Mascota("Filurais",R.drawable.mascota1,4));
        mimascotafotos.add(new Mascota("Filurais",R.drawable.mascota1,1));
        mimascotafotos.add(new Mascota("Filurais",R.drawable.mascota1,2));
        mimascotafotos.add(new Mascota("Filurais",R.drawable.mascota1,5));
        mimascotafotos.add(new Mascota("Filurais",R.drawable.mascota1,2));
        mimascotafotos.add(new Mascota("Filurais",R.drawable.mascota1,3));
    }
}
