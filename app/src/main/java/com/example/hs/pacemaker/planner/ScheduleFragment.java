package com.example.hs.pacemaker.planner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-01-09.
 */
public class ScheduleFragment extends Fragment {

    public ViewPager datePager;
    public int int_items = 14;

//    List<Fragment> fragments = buildFragments();
//    ArrayList<Integer> calendar;// = {"1", "2", "3"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.planner_plan,null);
        datePager = (ViewPager) x.findViewById(R.id.date_pager);

//        calendar.add(201601);
//        calendar.add(201602);
//        calendar.add(201603);
//        calendar.add(201604);
//        calendar.add(201605);
//        calendar.add(201606);
//        calendar.add(201607);
//        calendar.add(201608);
//        calendar.add(201609);
//        calendar.add(201610);
//        calendar.add(201611);
//        calendar.add(201612);
//        calendar.add(201701);

        MyDateAdapter myDateAdapter = new MyDateAdapter(getChildFragmentManager());
        datePager.setAdapter(new MyDateAdapter(getChildFragmentManager()));

        return x;


//        return inflater.inflate(R.layout.planner_plan,null);
    }

    class MyDateAdapter extends FragmentPagerAdapter {

        LayoutInflater mLayoutInflater;

        public MyDateAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new DatePagerFragment();
                case 1 : return new DatePagerFragment();
                case 2 : return new DatePagerFragment();
                case 3 : return new DatePagerFragment();
                case 4 : return new DatePagerFragment();
                case 5 : return new DatePagerFragment();
                case 6 : return new DatePagerFragment();
                case 7 : return new DatePagerFragment();
                case 8 : return new DatePagerFragment();
                case 9 : return new DatePagerFragment();
                case 10 : return new DatePagerFragment();
                case 11 : return new DatePagerFragment();
                case 12 : return new DatePagerFragment();
                case 13 : return new DatePagerFragment();
                case 14 : return new DatePagerFragment();
            }
            return null;





//            Bundle args  = new Bundle();
//            args.putInt("position", position);
//            DatePagerFragment datePagerFragment = new DatePagerFragment();
//            datePagerFragment.setArguments(args);
//            return datePagerFragment;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

//        @Override
//        public CharSequence getPageTitle(int position) {
//
//            switch (position){
//                case 0 :
//                    return "일정";
//                case 1 :
//                    return "설정";
//            }
//            return null;
//        }
    }

//    private List<Fragment> buildFragments() {
//        List<android.support.v4.app.Fragment> fragments = new ArrayList<Fragment>();
//        for(int i = 0; i < calendar.size(); i++) {
//            Bundle b = new Bundle();
//            b.putInt("position", i);
//            fragments.add(Fragment.instantiate(getContext(), DatePagerFragment.class.getName(), b));
//        }
//
//        return fragments;
//    }
}
