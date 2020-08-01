package com.example.pentagram.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.pentagram.R;
import com.example.pentagram.db.BaseDatos;
import com.example.pentagram.db.ConstantesBaseDatos;

import java.util.ArrayList;

public class ConstructorMisFotosMascota {
    private Context context;
    public ConstructorMisFotosMascota(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> ObtenerDatosMiMascota(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerDatosFotosMiMascotas();
    }
}
