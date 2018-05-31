package mx.edu.ittepic.sqlyrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class CardDato extends RecyclerView.Adapter<CardDato.EmpleadosViewHolder>{
    private Context mCtx;
    private List<Datos> empleadoList;

    public CardDato(Context mCtx, List<Datos> empleadoList) {
        this.mCtx = mCtx;
        this.empleadoList = empleadoList;
    }

    @Override
    public EmpleadosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_card_dato,null);
        EmpleadosViewHolder holder = new EmpleadosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EmpleadosViewHolder holder, int position) {
        Datos empleados = empleadoList.get(position);
        holder.clave.setText(empleados.getClave());
        holder.nombre.setText(empleados.getNombre());
        holder.salario.setText(String.valueOf(empleados.getSalario()));
    }

    @Override
    public int getItemCount() {
        return empleadoList.size();
    }

    class EmpleadosViewHolder extends RecyclerView.ViewHolder{

        TextView clave,nombre,salario;

        public EmpleadosViewHolder(View itemView) {
            super(itemView);
            clave= itemView.findViewById(R.id.Clave);

            nombre= itemView.findViewById(R.id.Nombre);
            salario= itemView.findViewById(R.id.Salario);
        }
    }
}
