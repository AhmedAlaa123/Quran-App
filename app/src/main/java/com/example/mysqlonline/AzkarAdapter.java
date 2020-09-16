package com.example.mysqlonline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AzkarAdapter extends RecyclerView.Adapter<azkarHolder> {
    ArrayList<AzkarContent> azkars;
    public AzkarAdapter(ArrayList<AzkarContent> azkars)
    {
        this.azkars=azkars;
    }
    @NonNull
    @Override
    public azkarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.azkaritemdesgine,parent,false);
        return new azkarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull azkarHolder holder, int position) {
        TextView txtzikrContent=holder.txtZikrContent,txtzikrcount=holder.txtZikrCount;
        txtzikrContent.setText(azkars.get(position).getZikrContent());
        if(azkars.get(position).getCount().equals("")) {
            txtzikrcount.setVisibility(View.GONE);
        }
        else {
            txtzikrcount.setText(azkars.get(position).getCount());

        }


    }

    @Override
    public int getItemCount() {
        return azkars.size();
    }
}
