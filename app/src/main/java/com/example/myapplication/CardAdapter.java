package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private ArrayList<String> titles;
    private ArrayList<String> bodies;

    public CardAdapter (ArrayList<String> titles, ArrayList<String>  bodies) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        TextView title = cardView.findViewById(R.id.titletext);
        TextView body = cardView.findViewById(R.id.bodytext);
        title.setText(titles.get(position));

        String bodyText = bodies.get(position);
        if (bodyText.length() > 150)
            bodyText = bodyText.substring(0, 150);
        body.setText(bodyText + " ...");
    }


    @Override
    public int getItemCount () {
        return titles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView cView) {
            super(cView);
            cardView = cView;
        }
    }

}
