package com.example.pentagram.fragment.mascotas;

import com.example.pentagram.adapter.MascotaAdaptador;
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public interface iRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
