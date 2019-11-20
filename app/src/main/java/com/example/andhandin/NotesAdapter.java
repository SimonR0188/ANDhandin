package com.example.andhandin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder1> {

   // private ArrayList<Note> mNotes;
    private List<Note> notes = new ArrayList<>();


   // public NotesAdapter(ArrayList<Note> notes) {
   //     mNotes = notes;

   // }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.content_item, parent, false);
        return new ViewHolder1(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int position) {
        Note currentNote = notes.get(position);
        viewHolder1.title.setText(currentNote.getTitle());
        viewHolder1.description.setText(currentNote.getDescription());
        viewHolder1.priority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        TextView priority;


        ViewHolder1(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.note);
            description = itemView.findViewById(R.id.note);
            priority = itemView.findViewById(R.id.note);

        }


    }

}

