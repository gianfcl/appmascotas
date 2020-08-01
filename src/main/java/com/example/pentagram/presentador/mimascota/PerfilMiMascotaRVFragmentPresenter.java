package com.example.pentagram.presentador.mimascota;

import android.content.Context;

import com.example.pentagram.fragment.mimascota.iPerfilMiMascotaFragmentView;
import com.example.pentagram.model.ConstructorMisFotosMascota;
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public class PerfilMiMascotaRVFragmentPresenter implements iPerfilMiMascotaRVFragmentPresenter {

    private com.example.pentagram.fragment.mimascota.iPerfilMiMascotaFragmentView iPerfilMiMascotaFragmentView;
    private Context context;
    private ConstructorMisFotosMascota constructorMisFotosMascota;
    private ArrayList<Mascota> fotosmimascotas;

    public PerfilMiMascotaRVFragmentPresenter(iPerfilMiMascotaFragmentView iPerfilMiMascotaFragmentView, Context context) {
        this.iPerfilMiMascotaFragmentView = iPerfilMiMascotaFragmentView;
        this.context = context;
        obtenerFotosMiMascotaBaseDatos();
    }

    @Override
    public void obtenerFotosMiMascotaBaseDatos() {
        constructorMisFotosMascota = new ConstructorMisFotosMascota(context);
        fotosmimascotas = constructorMisFotosMascota.ObtenerDatosMiMascota();
        mostrarFotosMiMascotasRV();
    }

    @Override
    public void mostrarFotosMiMascotasRV() {
        iPerfilMiMascotaFragmentView.inicializarAdaptadorMMRV(iPerfilMiMascotaFragmentView.crearAdaptadorMM(fotosmimascotas));
        iPerfilMiMascotaFragmentView.generarGridLayout();
    }
}
