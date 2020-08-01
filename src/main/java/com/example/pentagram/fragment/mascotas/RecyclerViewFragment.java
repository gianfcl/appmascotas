package com.example.pentagram.fragment.mascotas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.model.Mascota;
import com.example.pentagram.R;
import com.example.pentagram.adapter.MascotaAdaptador;
import com.example.pentagram.presentador.mascotas.RecyclerViewFragmentPresenter;
import com.example.pentagram.presentador.mascotas.iRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements iRecyclerViewFragmentView {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private iRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reycleview,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        //listaMascotas.setHasFixedSize(true);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adapt = new MascotaAdaptador(mascotas,getActivity());
        return adapt;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adapt) {
        listaMascotas.setAdapter(adapt);
    }
}
