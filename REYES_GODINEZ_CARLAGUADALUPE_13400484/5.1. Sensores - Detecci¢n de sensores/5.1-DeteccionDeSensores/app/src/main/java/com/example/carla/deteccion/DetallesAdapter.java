package com.example.carla.deteccion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carla on 12/05/18.
 */

class DetallesAdapter extends RecyclerView.Adapter<DetallesAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<DataProvider> sensorList;

    public DetallesAdapter(Context mCtx, List<DataProvider> sensorList){
        this.mCtx=mCtx;
        this.sensorList=sensorList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_detalles,null);

        ProductViewHolder holder = new ProductViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        DataProvider sensor = sensorList.get(position);

        holder.txtFabricante.setText(sensor.getFabricante());
        holder.txtDelay.setText(sensor.getDelay()+"");
        holder.txtNombre.setText(sensor.getNombre());
        holder.txtPower.setText(sensor.getPower()+"");
        holder.txtRango.setText(sensor.getRango()+"");
        holder.txtVersion.setText(sensor.getVersion()+"");
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView txtFabricante,txtNombre,txtRango,txtDelay,txtPower,txtVersion;

        public ProductViewHolder(View itemView) {
            super(itemView);

            txtFabricante=itemView.findViewById(R.id.txtFabricante);
            txtNombre=itemView.findViewById(R.id.txtNombre);
            txtRango=itemView.findViewById(R.id.txtRango);
            txtDelay=itemView.findViewById(R.id.txtDelay);
            txtPower=itemView.findViewById(R.id.txtPower);
            txtVersion=itemView.findViewById(R.id.txtVersion);
        }
    }
}
