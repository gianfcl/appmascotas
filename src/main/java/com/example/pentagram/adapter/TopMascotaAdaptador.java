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
import com.example.pentagram.model.Mascota;

import java.util.ArrayList;

public class TopMascotaAdaptador extends RecyclerView.Adapter<TopMascotaAdaptador.TopMascotaViewHolder>{

    ArrayList<Mascota> topmascotas;
    Activity activity;
    public TopMascotaAdaptador(ArrayList<Mascota> topmascotas,Activity activity){
        this.topmascotas=topmascotas;
        this.activity=activity;
    }

    @NonNull
    @Override
    public TopMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_topmascotas,parent,false);
        return new TopMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final  TopMascotaViewHolder holder, final  int position) {
        Mascota topmascota = topmascotas.get(position);
        holder.cantlike.setText(topmascota.getNombre());
        holder.topfoto.setImageResource(topmascota.getFoto());
        holder.cantlike.setText(Integer.toString(topmascota.getLike()));
    }

    @Override
    public int getItemCount() {
        return topmascotas.size();
    }

    public static class TopMascotaViewHolder extends RecyclerView.ViewHolder {
        private TextView topnomb;
        private ImageView topfoto;
        private TextView cantlike;

        public TopMascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            topnomb = (TextView) itemView.findViewById(R.id.tvNomTop);
            topfoto = (ImageView) itemView.findViewById(R.id.imgFotoTop);
            cantlike = (TextView) itemView.findViewById(R.id.tvContTop);
        }
    }
}
