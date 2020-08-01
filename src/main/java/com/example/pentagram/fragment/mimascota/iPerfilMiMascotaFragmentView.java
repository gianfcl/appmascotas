package com.example.pentagram.fragment.mimascota;

import com.example.pentagram.adapter.MiMascotAdaptor;
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public interface iPerfilMiMascotaFragmentView {

    public void generarGridLayout();

    public MiMascotAdaptor crearAdaptadorMM(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorMMRV(MiMascotAdaptor adaptador);
}
