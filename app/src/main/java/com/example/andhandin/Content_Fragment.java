package com.example.andhandin;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Content_Fragment extends Fragment {

    RecyclerView mGamesList;
    RecyclerView.Adapter mGamesAdapter;

    public Content_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mGamesList.hasFixedSize();
        mGamesList.setAdapter(mGamesAdapter);

        ArrayList<Game> games = new ArrayList<>();
        games.add(new Game("Path of Exile"));
        games.add(new Game("League of Legends"));
        games.add(new Game("World of Warcraft"));
        games.add(new Game("Path of Diablo"));
        games.add(new Game("Counter Strike"));
        games.add(new Game("Pokemon"));

        mGamesAdapter = new GamesAdapter(games);
        mGamesList.setAdapter(mGamesAdapter);

        return view;

    }
}