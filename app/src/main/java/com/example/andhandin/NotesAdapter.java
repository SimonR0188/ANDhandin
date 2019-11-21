package com.example.andhandin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

   // private ArrayList<Note> mNotes;
    private List<Note> notes = new ArrayList<>();


   // public NotesAdapter(ArrayList<Note> notes) {
   //     mNotes = notes;

   // }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Note currentNote = notes.get(position);
        viewHolder.title.setText(currentNote.getTitle());
        viewHolder.description.setText(currentNote.getDescription());
        viewHolder.priority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        TextView priority;


        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.editText);
            description = itemView.findViewById(R.id.text_description);
            priority = itemView.findViewById(R.id.text_description);

        }



    }

}

