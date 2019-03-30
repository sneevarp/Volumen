package com.project.android.volumen;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class FeedActivity extends FragmentActivity {

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

    //Favourite click should not update date(update the value in the arraylist), Comment addition will update the post date(get value and remove from arraylist and the update and the add to the list).

    //Add the feed to the Volumen/user/Feed and also to the Volumen/Feed in the Database
    public void addNewFeed(View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FeedFragment feedFragment = new FeedFragment();
        fragmentTransaction.add(R.id.feedFrameLayout,feedFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //feedActivityViewModel.setNewdata(new FeedData());
        Toast.makeText(this, "Total data available:  "+feedRecyclerViewAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
    }
}
