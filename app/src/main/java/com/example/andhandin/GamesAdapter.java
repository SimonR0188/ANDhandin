package com.example.andhandin;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    private ArrayList<Game> mGames;


    public GamesAdapter(ArrayList<Game> games) {
        mGames = games;

    }

    @NonNull
    @Override
    public GamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }


/*
    public void onBindViewHolder(@NonNull GamesAdapter.ViewHolder holder, int position) {
        Game name = mGames.get(position);
        holder.name.setText((CharSequence) name);
    }
    */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder.name.setText(mGames.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return mGames.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

         TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.computerGames);

        }


    }

}

