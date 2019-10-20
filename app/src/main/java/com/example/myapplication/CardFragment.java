package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardFragment extends Fragment {

    public CardFragment () {

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView cardRecycler = (RecyclerView) inflater.inflate(R.layout.post_card, container, false);

        ArrayList<Post> postList = new ArrayList<Post>();
        String[] titleList = {"no 1", "no 2"};
        String[] bodyList = {"title body 1", "title body 2"};


        CardAdapter adapter = new CardAdapter(titleList, bodyList);
        cardRecycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        cardRecycler.setLayoutManager(layoutManager);

        return cardRecycler;
    }
}
