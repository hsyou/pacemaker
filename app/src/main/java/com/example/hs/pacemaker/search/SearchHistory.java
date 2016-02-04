package com.example.hs.pacemaker.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hs.pacemaker.R;

import java.util.List;

/**
 * Created by hs on 2016-02-03.
 */
public class SearchHistory extends Fragment {
    ListView listview;
    HistoryListAdapter adapter;
    HistoryDBHandler handler=null;
    FragmentManager mFragmentManager;
    List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFragmentManager=getActivity().getSupportFragmentManager();
        View rootView = inflater.inflate(R.layout.search_history, null);
        //db에서 가져온 history listview로 출력
        handler=HistoryDBHandler.getInstance(getContext());

        list=handler.getAllContacts();

        listview=(ListView)rootView.findViewById(R.id.search_listview);
        adapter=new HistoryListAdapter(getContext());
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                xfragmentTransaction.replace(R.id.search_frame,new SearchFragment(list.get(list.size()-position-1))).commit();

            }
        });
        return rootView;
    }
}
