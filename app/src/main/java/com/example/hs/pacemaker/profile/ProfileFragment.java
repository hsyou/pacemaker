package com.example.hs.pacemaker.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-01-09.
 */
public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_main_self, container, false);

        ImageView profile_back = (ImageView)rootView.findViewById(R.id.profile_profile_img_back);

        return rootView;
    }
}