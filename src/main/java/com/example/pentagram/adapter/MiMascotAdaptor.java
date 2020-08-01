package com.example.pentagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.R;
import com.example.pentagram.model.ConstructorMascotas;
import com.example.pentagram.model.ConstructorMisFotosMascota;
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public class MiMascotAdaptor extends RecyclerView.Adapter<MiMascotAdaptor.MiMascotViewHolder>{
    ArrayList<Mascota> fotosmascota;
    Activity activity;

    public MiMascotAdaptor(ArrayList<Mascota> fotosmascota, Activity activity){
        this.fotosmascota = fotosmascota;
        this.activity=activity;
    }
    @NonNull
    @Override
    public MiMascotAdaptor.MiMascotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mimascota,parent,false);
        return new MiMascotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiMascotViewHolder holder, int position) {
        final Mascota miscast = this.fotosmascota.get(position);
        holder.foto.setImageResource(miscast.getFoto());
        holder.cantlikes.setText(Integer.toString(miscast.getLike()));
    }

    @Override
    public int getItemCount() {
        return fotosmascota.size();
    }

    public static class MiMascotViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto;
        private TextView cantlikes;

        public MiMascotViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.imgFotoMiMascota);
            cantlikes = (TextView) itemView.findViewById(R.id.tvCant);
        }
    }
}
