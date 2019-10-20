package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private String[] titles;
    private String[] bodies;

    public CardAdapter (String[] titles, String[] bodies) {
        this.titles = titles;
        this.bodies = bodies;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate((R.layout.post_card), parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView title = (TextView) cardView.findViewById(R.id.titletext);
        TextView body = (TextView) cardView.findViewById(R.id.bodytext);
        title.setText(titles[position]);
        body.setText(bodies[position]);
    }


    @Override
    public int getItemCount () {
        return titles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView cView) {
            super(cView);
            cardView = cView;
        }
    }

}
