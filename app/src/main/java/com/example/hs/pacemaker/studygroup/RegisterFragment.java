package com.example.hs.pacemaker.studygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hs.pacemaker.R;

import java.util.ArrayList;

/**
 * Created by hs on 2016-01-09.
 */
public class RegisterFragment extends Fragment {

    Spinner spinSub1, spinSub2;
    ArrayList<String> sub1List, sub2List;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.register_study, container, false);

        sub1List = new ArrayList<String>(); sub2List = new ArrayList<String>();
        sub1List.add("1차 과목");
        sub1List.add("영어");
        sub1List.add("중국어");
        sub1List.add("프로그래밍");
        sub1List.add("기타");

        sub2List.add("2차 과목");
        sub2List.add("TOEIC");

//        Button btnSub1 = (Button)rootView.findViewById(R.id.r_study_sub1);
//        Button btnSub2 = (Button)rootView.findViewById(R.id.r_study_sub2);

        Spinner spinSub1 = (Spinner)rootView.findViewById(R.id.r_study_sub1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, sub1List);
        spinSub1.setAdapter(adapter);

        Spinner spinSub2 = (Spinner)rootView.findViewById(R.id.r_study_sub2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, sub2List);
        spinSub2.setAdapter(adapter2);

        return rootView;
    }
}