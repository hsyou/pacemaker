package com.example.hs.pacemaker.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-01-09.
 */
public class TimelineSetup extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.timeline_setup_layout, null);

       /* GridView gridview=(GridView)rootView.findViewById(R.id.gridView);
        gridview.setAdapter(new GridAdapter(getActivity()));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),""+position,Toast.LENGTH_SHORT).show();

            }
        });*/
        return rootView;
    }
}