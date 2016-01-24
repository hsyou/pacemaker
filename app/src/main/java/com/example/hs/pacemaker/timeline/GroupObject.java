package com.example.hs.pacemaker.timeline;

/**
 * Created by Kayla on 2016-01-21.
 */
public class GroupObject {

    private String imgSrc;
    private String name;
    private String region;
    private String day;
    private String abs;

    public GroupObject(String name, String region, String day, String abs) {
//        this.imgSrc = imgSrc; //일단 주석
        this.name = name;
        this.region = region;
        this.day = day;
        this.abs = abs;
    }

    public String getName(){
        return name;
    }

    public String getRegion(){
        return region;
    }

    public String getDay(){
        return day;
    }

    public String getAbs(){
        return abs;
    }

}
