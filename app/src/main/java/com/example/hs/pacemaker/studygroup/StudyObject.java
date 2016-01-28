package com.example.hs.pacemaker.studygroup;

/**
 * Created by Kayla on 2016-01-21.
 */
public class StudyObject{

    private String imgSrc;
    private String name;
    private String sub_1;
    private String region;
    private String day;
    private String abs;
    private String content;

    public StudyObject(String name, String sub_1, String region, String day, String abs, String content) {
//        this.imgSrc = imgSrc; //일단 주석
        this.name = name;
        this.sub_1 = sub_1;
        this.region = region;
        this.day = day;
        this.abs = abs;
        this.content = content;
    }

    public String getName(){
        return name;
    }

    public String getSub_1(){
        return sub_1;
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

    public String getContent() { return content; }

}
