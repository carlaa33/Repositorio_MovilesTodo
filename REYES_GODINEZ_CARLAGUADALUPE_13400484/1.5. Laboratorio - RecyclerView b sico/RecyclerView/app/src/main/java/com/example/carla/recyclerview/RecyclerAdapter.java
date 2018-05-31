package com.example.carla.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by carla on 27/02/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderAlumnos> {

    ArrayList<Alumnos> alumnos;

    public  RecyclerAdapter(ArrayList<Alumnos> alumnos){
        this.alumnos=alumnos;
    }

    @Override
    public ViewHolderAlumnos onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);

        return new ViewHolderAlumnos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderAlumnos holder, int position) {

        holder.enombre.setText(alumnos.get(position).getNombre());
        holder.econtrol.setText(alumnos.get(position).getNumControl());
        holder.ecarrera.setText(alumnos.get(position).getCarrera());
        holder.foto.setImageResource(alumnos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    class ViewHolderAlumnos extends RecyclerView.ViewHolder{
        TextView  enombre,econtrol,ecarrera;
        ImageView foto;

        public ViewHolderAlumnos(View itemView) {
            super(itemView);
            enombre=(TextView)itemView.findViewById(R.id.idNombre);
            econtrol=(TextView)itemView.findViewById(R.id.idNumControl);
            ecarrera=(TextView)itemView.findViewById(R.id.idCarrera);
            foto=(ImageView)itemView.findViewById(R.id.idImgen);

        }
    }
}
