package com.example.hs.pacemaker.timeline;

/**
 * Created by hs on 2016-01-20.
 */
public class Recycler_item {
    int img;
    int profileImg;
    String id;
    String category;
    String time;
    int like;
    int reply;
    String text;
    String hashTag;

    public int getImg() {
        return img;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTime() {
        return time;
    }

    public int getLike() {
        return like;
    }

    public int getReply() {
        return reply;
    }

    public String getText() {
        return text;
    }

    public String getHashTag() {
        return hashTag;
    }

    public Recycler_item(int img, int profileImg, String id, String category, String time, int like, int reply, String text, String hashTag) {
        this.img = img;
        this.profileImg = profileImg;
        this.id = id;
        this.category = category;
        this.time = time;
        this.like = like;
        this.reply = reply;
        this.text = text;
        this.hashTag = hashTag;
    }
}