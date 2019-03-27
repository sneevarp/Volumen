package com.project.android.volumen;

import com.project.android.volumen.Feed.FeedData;

import java.util.List;

public class UserData {
    List<FeedData> feed;
    List<FeedData> favourite;

    public UserData(List<FeedData> feed, List<FeedData> favourite)
    {
    this.feed = feed;
    this.favourite = favourite;
    }


}
