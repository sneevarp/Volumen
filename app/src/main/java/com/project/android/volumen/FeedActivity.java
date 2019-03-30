package com.project.android.volumen;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.project.android.volumen.Feed.FeedActivityViewModel;
import com.project.android.volumen.Feed.FeedData;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private RecyclerView feedRecyclerView;
    private RecyclerView.Adapter feedRecyclerViewAdapter;
    private RecyclerView.LayoutManager feedRecyclerViewLayoutManager;
    private FeedActivityViewModel feedActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        


        //viewmodelDef
        feedActivityViewModel = ViewModelProviders.of(this).get(FeedActivityViewModel.class);

        //recyclerDef
        feedRecyclerView = (RecyclerView)findViewById(R.id.FeedRecycler);
        feedRecyclerView.hasFixedSize();
        feedRecyclerViewLayoutManager = new LinearLayoutManager(this);
        feedRecyclerView.setLayoutManager(feedRecyclerViewLayoutManager);

        feedActivityViewModel.getFeedData().observe(this, new Observer<ArrayList<FeedData>>() {
            @Override
            public void onChanged(@Nullable ArrayList<FeedData> feedData) {
                feedRecyclerViewAdapter = new FeedAdapter(feedData);
                feedRecyclerView.setAdapter(feedRecyclerViewAdapter);
            }
        });
    }

    public void addNewFeed(View view){
        feedActivityViewModel.setNewdata(new FeedData());
        Toast.makeText(this, "Total data available:  "+feedRecyclerViewAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
    }
}
