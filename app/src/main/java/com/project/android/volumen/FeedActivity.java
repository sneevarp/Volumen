package com.project.android.volumen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.android.volumen.Feed.FeedData;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private RecyclerView feedRecyclerView;
    private RecyclerView.Adapter feedRecyclerViewAdapter;
    private RecyclerView.LayoutManager feedRecyclerViewLayoutManager;
    private List<FeedData> testFeedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        testFeedData = new ArrayList<>();
        feedRecyclerView = (RecyclerView)findViewById(R.id.FeedRecycler);
        feedRecyclerView.hasFixedSize();

        feedRecyclerViewLayoutManager = new LinearLayoutManager(this);
        feedRecyclerView.setLayoutManager(feedRecyclerViewLayoutManager);

        testFeedData.add(new FeedData());
        testFeedData.add(new FeedData());
        feedRecyclerViewAdapter= new FeedAdapter(testFeedData);
        feedRecyclerView.setAdapter(feedRecyclerViewAdapter);

    }
}
