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
        studyList.add(new StudyObject("토르플스터디","러시아어", "강남", "매주 수요일, 금요일", "사슴같이 예쁜 눈 나의 프린세스 자연미인 특이해 특이해 사슴같이 예쁜 눈 나의 프린세스 자연미인", "가나다"));
        studyList.add(new StudyObject("서현역 HSK","중국어", "분당", "매주 토요일", "봄봄봄 봄이왔어여", "글에 들어갈 긴 내용들"));
        studyList.add(new StudyObject("영어 면접", "영어", "분당","매주 토요일", "이런 비가 ", "안녕하세요.\n\n현재 러문 복수전공하고있는 10학번입니다.\n방학 때 FLEX 준비를 해서 얼마 전에 시험 보았구요,\n이번 주부터는 토르플 2단계를 준비해서 2학기 안에 한 번 보는 게 목표입니다.\n\n원래 세 명이서 진행하다가 현재 2명이구요,\n정막래 교수님 토르플 2단계 문제집으로 진행합니다.\n\n저는 러시아로 한 학기 교환학생을 다녀왔고 나머지 한 분은 어렸을 때 우즈벡에서 살다 오셨어요. 저는 공부 안 한 지가 오래되어서 거의 초보 수준이라 이번 학기 수업 들으면서 다시 쌓아 올릴 생각입니다. 체류 경험 있으신 분도 없으신 분도 모두 환영합니다. 성실하게 임해주실 분들 찾습니다. 안녕하세요. 현재 러문 복수전공하고있는 10학번입니다. 방학 때 FLEX 준비를 해서 얼마 전에 시험 보았구요, 이번 주부터는 토르플 2단계를 준비해서 2학기 안에 한 번 보는 게 목표입니다. 원래 세 명이서 진행하다가 현재 2명이구요, 정막래 교수님 토르플 2단계 문제집으로 진행합니다. \n\n저는 러시아로 한 학기 교환학생을 다녀왔고 나머지 한 분은 어렸을 때 우즈벡에서 살다 오셨어요. "));
        studyList.add(new StudyObject("자바", "프로그래밍", "분당","매주 토요일", "저 별을 가져다 너의 두 손에 선물하고 싶어 내 모든걸 담아 저 벼을 가져다 너의 두 손에 ", "아아아"));
        studyList.add(new StudyObject("가장 쉽게 공부할 수 있는 Spring Framework", "프로그래밍", "분당","매주 토요일", "저 별을 가져다", "ABCDE12#*)&$#*&$)("));

        return studyList;
    }


}