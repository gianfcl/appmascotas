package com.example.pentagram.fragment.mimascota;

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
import com.example.pentagram.model.Mascota;
import com.example.pentagram.adapter.MiMascotAdaptor;
import com.example.pentagram.presentador.mimascota.PerfilMiMascotaRVFragmentPresenter;
import com.example.pentagram.presentador.mimascota.iPerfilMiMascotaRVFragmentPresenter;

import java.util.ArrayList;

public class PerfilMiMascotaFragment extends Fragment implements iPerfilMiMascotaFragmentView {


    ArrayList<Mascota> mimascotafotos;
    private RecyclerView listaFotosMiMascota;
    private iPerfilMiMascotaRVFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        listaFotosMiMascota = (RecyclerView) v.findViewById(R.id.rvFotos);
        //listaFotosMiMascota.setHasFixedSize(true);
        presenter = new PerfilMiMascotaRVFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaFotosMiMascota.setLayoutManager(glm);
    }

    @Override
    public MiMascotAdaptor crearAdaptadorMM(ArrayList<Mascota> mimascotafotos) {
        MiMascotAdaptor adapt = new MiMascotAdaptor(mimascotafotos,getActivity());
        return adapt;
    }

    @Override
    public void inicializarAdaptadorMMRV(MiMascotAdaptor adapt) {
        listaFotosMiMascota.setAdapter(adapt);
    }
}
