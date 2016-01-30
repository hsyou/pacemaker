package com.example.hs.pacemaker.studygroup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

/**
 * Created by Kayla on 2016-01-28.
 */

@SuppressLint("ValidFragment")
public class FoundStudy extends Fragment{

    StudyObject selStudy;

    public FoundStudy(StudyObject selStudy){
        this.selStudy = selStudy;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.find_study_detail, null);

        ImageView img;
        TextView tvName, tvRegion, tvDay, tvContent;
        tvName = (TextView)rootView.findViewById(R.id.card_name);
        tvDay = (TextView)rootView.findViewById(R.id.card_region);
        tvRegion = (TextView)rootView.findViewById(R.id.card_region);
        tvContent = (TextView)rootView.findViewById(R.id.card_content);

        tvName.setText(selStudy.getName());
        tvDay.setText(selStudy.getDay());
        tvRegion.setText(selStudy.getRegion());
        tvContent.setText(selStudy.getContent());

        Button btnContact = (Button)rootView.findViewById(R.id.show_contacts);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return rootView;
    }
}
