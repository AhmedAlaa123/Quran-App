package com.example.mysqlonline;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class holder extends RecyclerView.ViewHolder {
    public TextView txtSuraName,txtSuraCity,txtAyatNumber;
    public View view;
    public holder(@NonNull View itemView) {
        super(itemView);
        txtSuraName=itemView.findViewById(R.id.txtSuraName);
        txtSuraCity=itemView.findViewById(R.id.txtSuraCity);
        txtAyatNumber=itemView.findViewById(R.id.txtAyatNumber);
        view=itemView.findViewById(R.id.line);
    }
}
