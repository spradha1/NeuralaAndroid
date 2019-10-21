package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardFragment extends Fragment {

    private ArrayList<String> titleList;
    private ArrayList<String> bodyList;

    public CardFragment () {
        this.titleList = new ArrayList<>();
        this.bodyList = new ArrayList<>();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);
        Call<List<Post>> call = jsonApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> list = response.body();
                for (Post p: list) {
                    titleList.add(p.getTitle());
                    bodyList.add(p.getText());
                }

                RecyclerView cardRecycler = getActivity().findViewById(R.id.cardFrag);

                CardAdapter adapter = new CardAdapter(titleList, bodyList);
                cardRecycler.setAdapter(adapter);

                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                cardRecycler.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
