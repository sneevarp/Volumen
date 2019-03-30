package com.project.android.volumen.Feed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.project.android.volumen.FeedActivity;
import com.project.android.volumen.FeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class FeedActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<FeedData>> feedDataList;
    ArrayList<FeedData> testFeedData = new ArrayList<>();
    FeedData feedData;

    public LiveData<ArrayList<FeedData>> getFeedData(){
        if(feedDataList == null)
        {
            feedDataList = new MutableLiveData<ArrayList<FeedData>>();
            getInitialData();
        }
        return feedDataList;
    }

    //This is to get the initial set of feed from Firebase. Now adding temp data in a arraylist
    public void getInitialData() {

        testFeedData.add(new FeedData());
        testFeedData.add(new FeedData());

        feedDataList.setValue(testFeedData);//sends notice to observer
    }

    public void setNewdata(FeedData newFeed) {
        testFeedData.add(newFeed);
        feedDataList.setValue(testFeedData);
    }
}
