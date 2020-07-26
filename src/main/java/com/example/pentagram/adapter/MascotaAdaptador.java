package com.example.pentagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pentagram.pojo.Mascota;
import com.example.pentagram.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.foto.setImageResource(mascota.getFoto());
        mascotaViewHolder.like.setText(Integer.toString(mascota.getLike()));

        mascotaViewHolder.hwhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mascotaViewHolder.like.setText(Integer.toString(mascota.getLike()+1));
                //Toast.makeText(activity,Integer.toString(mascota.getLike()+1), Toast.LENGTH_LONG).show();
                mascotas.get(position).setLike(mascotas.get(position).getLike()+1);
                mascotaViewHolder.like.setText(Integer.toString(mascota.getLike()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre;
        private ImageView foto;
        private TextView like;
        private ImageView hwhite;
        private ImageView hyellow;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNom);
            foto = (ImageView) itemView.findViewById(R.id.imgFot);
            like = (TextView) itemView.findViewById(R.id.tvCont);
            hwhite = (ImageView) itemView.findViewById(R.id.imgBone1);
            hyellow = (ImageView) itemView.findViewById(R.id.imgBone2);
        }
    }
}
