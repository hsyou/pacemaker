package com.example.hs.pacemaker.timeline;

/**
 * Created by hs on 2016-01-25.
 */
public class CommentObject {
    private int img;
    private String name;
    private String comment;

    public CommentObject(int img, String name,String comment) {
        this.img=img;
        this.name = name;
        this.comment=comment;

    }

    public String getName(){
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getComment() {
        return comment;
    }
}

