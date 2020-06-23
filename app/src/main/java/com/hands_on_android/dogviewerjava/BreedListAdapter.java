package com.hands_on_android.dogviewerjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hands_on_android.dogviewerjava.network.model.Breed;

import java.util.ArrayList;
import java.util.List;

public class BreedListAdapter extends RecyclerView.Adapter<BreedListAdapter.BreedListViewHolder> {
    private List<Breed> breedNames = new ArrayList<>();
    private OnBreedItemClickListener listener;

    public BreedListAdapter(OnBreedItemClickListener listener) {
        this.listener = listener;
    }

    public void setBreedNames(List<Breed> breedNames) {
        this.breedNames = breedNames;
    }

    @NonNull
    @Override
    public BreedListAdapter.BreedListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BreedListViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BreedListAdapter.BreedListViewHolder holder, int position) {
        holder.bind(breedNames.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return breedNames.size();
    }

    public static class BreedListViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        private BreedListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.breedNameTextView);
        }

        //Add bind method
        public void bind(Breed breed, OnBreedItemClickListener listener){
            textView.setText(breed.getTitle());
            textView.setOnClickListener(v -> {
                listener.onBreedItemClick(breed);
            });
        }

        //Add from method
        public static  BreedListViewHolder from(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_breed_list_item, parent, false);
            return new BreedListViewHolder(view);
        }
    }

    public interface OnBreedItemClickListener {
        void onBreedItemClick(Breed breed);
    }
}
