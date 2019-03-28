package com.project.android.volumen;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.android.volumen.Feed.FeedData;

import org.w3c.dom.Text;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder>
{
    List<FeedData> mDataset;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public CardView cardView;
        public TextView feedTitle;
        public TextView feedContent;
        public ImageButton favoriteFeedButton;
        public ImageButton disLikeButton;
        public TextView feedDate;

        public MyViewHolder(View v) {
            super(v);
            cardView = (CardView)v.findViewById(R.id.feedCard);
            feedContent = (TextView)v.findViewById(R.id.contentspaceText);
            feedTitle = (TextView)v.findViewById(R.id.bookTitle_Item);
            favoriteFeedButton = (ImageButton)v.findViewById(R.id.likeButton);
            disLikeButton = (ImageButton)v.findViewById(R.id.disLikeButton);
            feedDate = (TextView)v.findViewById(R.id.datePostedText);
        }
    }

    public FeedAdapter(List<FeedData> myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public FeedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.feed_item, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.feedTitle.setText(mDataset.get(i).getContentTitle());
        myViewHolder.feedContent.setText(mDataset.get(i).getContentMessage());
        myViewHolder.feedDate.setText(mDataset.get(i).datePosted.toString());
        myViewHolder.disLikeButton.setVisibility(mDataset.get(i).isFavourite?View.GONE:View.VISIBLE);
        myViewHolder.favoriteFeedButton.setVisibility(!mDataset.get(i).isFavourite?View.GONE:View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
