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
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notes_Fragment extends Fragment {
    private NoteViewModel noteViewModel;
    NotesAdapter notesAdapter;
    private EditText editText;

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
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {

            @Override
            public void onChanged(@Nullable List<Note> notes) {
                notesAdapter.setNotes(notes);

            }
        });

        return view;

    }

    public void saveNote(View v) {
        noteViewModel.insert(new Note(editText.getText().toString(),"description",1));
    }

    public void deleteAllNotes(View v) {
        noteViewModel.deleteAllNotes();
    }
}



