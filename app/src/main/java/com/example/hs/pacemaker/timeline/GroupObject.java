package com.example.hs.pacemaker.timeline;


public class GroupObject {

    private int img;
    private String name;


    public GroupObject(int img,String name) {
        this.img=img;
        this.name = name;

    }

    public String getName(){
        return name;
    }

    public int getImg() {
        return img;
    }
}
