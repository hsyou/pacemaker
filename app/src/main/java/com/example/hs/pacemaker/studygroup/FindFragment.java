package com.example.hs.pacemaker.studygroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hs.pacemaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2016-01-09.
 */
public class FindFragment extends Fragment {

//    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.find_study, null);

        List<StudyObject> studyList = getStudies();

        Fragment showStudies = new ShowStudies(studyList);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction  = fm.beginTransaction();
        transaction.replace(R.id.find_study_frame, showStudies);
        transaction.commit();




        return rootView;
    }

    private List<StudyObject> getStudies(){
        List<StudyObject> studyList = new ArrayList<>();
        studyList.add(new StudyObject("토르플스터디", "강남", "매주 수요일, 금요일", "사슴같이 예쁜 눈 나의 프린세스 자연미인 특이해 특이해 사슴같이 예쁜 눈 나의 프린세스 자연미인"));
        studyList.add(new StudyObject("서현역 HSK", "분당", "매주 토요일", "봄봄봄 봄이왔어여"));
        studyList.add(new StudyObject("영어 면접","분당","매주 토요일", "이런 비가 "));
        studyList.add(new StudyObject("자바","분당","매주 토요일", "저 별을 가져다 너의 두 손에 선물하고 싶어 내 모든걸 담아 저 벼을 가져다 너의 두 손에 "));
        studyList.add(new StudyObject("가장 쉽게 공부할 수 있는 Spring Framework","분당","매주 토요일", "저 별을 가져다"));

        return studyList;
    }


}