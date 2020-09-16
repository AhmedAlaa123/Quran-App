package com.example.mysqlonline;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class azkarHolder extends RecyclerView.ViewHolder
{
    public TextView txtZikrCount,txtZikrContent;
    public azkarHolder(@NonNull View itemView) {
        super(itemView);
        txtZikrContent=itemView.findViewById(R.id.txtZikrContent);
        txtZikrCount=itemView.findViewById(R.id.txtZikrCount);
    }
}
