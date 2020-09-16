package com.example.mysqlonline;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<holder> {

    ArrayList<surahData> sounds;
    Context context;
    public static MediaPlayer mediaPlayer = new MediaPlayer();

    public Adapter(ArrayList<surahData> sounds, Context context) {
        this.sounds = sounds;
        this.context = context;
        // mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemdesign, parent, false);

        return new holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull holder h, final int position) {

        holder holder1 = h;
        TextView txtsurNAme, txtSouraCity, txtayats;
        txtsurNAme = holder1.txtSuraName;
        txtSouraCity = holder1.txtSuraCity;
        txtayats = holder1.txtAyatNumber;
        txtsurNAme.setText((1 + position) + " - " + sounds.get(position).getName());
        txtSouraCity.setText(sounds.get(position).getCity() + "");
        txtayats.setText("الايات " + sounds.get(position).getAyatNumber());

        txtsurNAme.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              //MediaPlayer mediaPlayer = new MediaPlayer();

                                              if (!testIntentConnection()) {
                                                  Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();
                                                  return;
                                              }
                                              try {

                                                  mediaPlayer.release();
                                                  mediaPlayer = new MediaPlayer();
                                                  mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                      @Override
                                                      public void onCompletion(MediaPlayer mp) {
                                                          mediaPlayer.release();
                                                      }
                                                  });
                                                  mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                                  mediaPlayer.setDataSource(sounds.get(position).getUrl());
                                                  mediaPlayer.prepare();
                                                  mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                                      @Override
                                                      public void onPrepared(MediaPlayer mp) {
                                                          mediaPlayer.start();
                                                      }
                                                  });

                                              } catch (IOException e) {
                                                  e.printStackTrace();
                                              }


                                          }
                                      }
        );
    }


    @Override
    public int getItemCount() {
        return sounds.size();
    }

    private boolean testIntentConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                return true;
            }
        }
        return false;
    }
}