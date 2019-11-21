package com.example.andhandin;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notes_Fragment extends Fragment implements View.OnClickListener {
    private NoteViewModel noteViewModel;
    private EditText editText;
    NotesAdapter notesAdapter;
    Button ButtonAdd;
    Button ButtonDelete;

    public Notes_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_, container, false);


        RecyclerView recyclerView1 = view.findViewById(R.id.rv_note);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));

        notesAdapter = new NotesAdapter();
        recyclerView1.setAdapter(notesAdapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        ButtonAdd = view.findViewById(R.id.button);
        ButtonAdd.setOnClickListener(this);

        ButtonDelete = view.findViewById(R.id.deleteAll);
        ButtonDelete.setOnClickListener(this);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {

            @Override
            public void onChanged(@Nullable List<Note> notes) {
                notesAdapter.setNotes(notes);

            }
        });

        return view;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button:
                noteViewModel.insert(new Note(editText.getText().toString(),"description",1));
                break;

            case R.id.deleteAll:
                noteViewModel.deleteAllNotes();
        }

    }

}



