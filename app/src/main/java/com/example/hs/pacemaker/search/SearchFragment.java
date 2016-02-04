package com.example.hs.pacemaker.search;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-02-03.
 */
@SuppressLint("ValidFragment")
public class SearchFragment extends Fragment {
    HistoryDBHandler handler=null;

    public SearchFragment(String str) {
        this.str = str;
    }

    TextView tv;
    String str;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_list, null);
        tv=(TextView)rootView.findViewById(R.id.search_text);
        tv.setText("검색어 : "+str);

        handler=HistoryDBHandler.getInstance(getContext());
        //str historyDB에 저장
        handler.addContact(str);

        return rootView;
    }

}
