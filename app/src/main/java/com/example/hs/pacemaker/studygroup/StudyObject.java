package com.example.hs.pacemaker.studygroup;

/**
 * Created by Kayla on 2016-01-21.
 */
public class StudyObject{

    private String imgSrc;
    private String name;
    private String region;
    private String day;
    private String abs;

    public StudyObject(String name, String region, String day, String abs) {
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
