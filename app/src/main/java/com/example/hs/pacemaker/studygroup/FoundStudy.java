package com.example.hs.pacemaker.studygroup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hs.pacemaker.R;

/**
 * Created by Kayla on 2016-01-28.
 */

@SuppressLint("ValidFragment")
public class FoundStudy extends Fragment{

    private String strName;
    private String region;
    private String day;
    private String abst;
    private String content;
    private String sub_1;

    public FoundStudy(StudyObject selStudy){
        this.strName = selStudy.getName();
        this.region = selStudy.getRegion();
        this.day = selStudy.getDay();
        this.abst = selStudy.getAbs();
        this.content = selStudy.getContent();
        this.sub_1 = selStudy.getSub_1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.find_study_detail, null);




        return rootView;
    }
}
