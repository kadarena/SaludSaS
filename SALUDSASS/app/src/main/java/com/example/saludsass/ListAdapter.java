package com.example.saludsass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListElement> nData;
    private LayoutInflater nInflater;

    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.nInflater = LayoutInflater.from(context);
        this.context = context;
        this.nData = itemList;
    }

    @Override

    public int getItemCount() {
        return nData.size();
    }

    @Override

    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = nInflater.inflate(R.layout.activity_list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(nData.get(position));
    }

    public void setItems(List<ListElement> items){nData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipoCita,medicoCita,fechaCita;

        ViewHolder(View itemView){
            super(itemView);
            tipoCita = itemView.findViewById(R.id.txt_tipo_cita);
            medicoCita = itemView.findViewById(R.id.txt_profesional_cita);
            fechaCita = itemView.findViewById(R.id.txt_fecha_cita);

        }

        void bindData(final ListElement item){
            tipoCita.setText(item.getTipoCita());
            medicoCita.setText(item.getMedicoCita());
            fechaCita.setText(item.getFechaCita());
        }

    }

}
