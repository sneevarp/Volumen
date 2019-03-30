package com.project.android.volumen.Feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedData {
    public boolean isFavourite;
    public String contentTitle;
    public String contentMessage;
    public Date datePosted;
    public List<CommentData> comments;

    public FeedData(boolean isFavourite, String contentTitle, String contentMessage, Date datePosted, List<CommentData> comments){
        this.isFavourite = isFavourite;
        this.contentTitle = contentTitle;
        this.contentMessage = contentMessage;
        this.datePosted = datePosted;
        this.comments = comments;
    }

    public FeedData(){
        this.isFavourite = false;
        this.contentTitle= "HarryPotter";
        this.contentMessage = "This is a goodbook for less price";
        this.datePosted = new Date();
        this.comments = new ArrayList<>();
    }


    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentMessage() {
        return contentMessage;
    }

    public void setContentMessage(String contentMessage) {
        this.contentMessage = contentMessage;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public List<CommentData> getComments() {
        return comments;
    }

    public void setComments(List<CommentData> comments) {
        this.comments = comments;
    }
}
