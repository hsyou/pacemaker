package com.example.hs.pacemaker.planner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

/**
 * Created by Kayla on 2016-01-13.
 */
public class DatePagerFragment extends Fragment {

    private int year = 2016, month = 1;
    TextView pagerYear, pagerMonth;

    public DatePagerFragment (){
        int position = 3;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.planner_datepager_layout,null);
        pagerYear = (TextView)x.findViewById(R.id.planner_pager_year);
        pagerMonth = (TextView)x.findViewById(R.id.planner_pager_month);

        pagerYear.setText(Integer.toString(year));
        pagerMonth.setText(Integer.toString(month));

        return x;
    }
}
