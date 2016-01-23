package com.example.hs.pacemaker.studygroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hs.pacemaker.R;

import java.util.List;

/**
 * Created by Kayla on 2016-01-22.
 */
@SuppressLint("ValidFragment")
public class ShowStudies extends Fragment {

    List<StudyObject> list;

    public ShowStudies(List<StudyObject> studyList){
        this.list = studyList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.find_study_grid, null);

        GridView gridView = (GridView)rootView.findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(getContext(), list);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"hi", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    public class CustomAdapter extends BaseAdapter {

        private LayoutInflater layoutinflater;
        private List<StudyObject> listStorage;
        private Context context;

        public CustomAdapter(Context context, List<StudyObject> customizedListView) {
            this.context = context;
            layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listStorage = customizedListView;
        }

        @Override
        public int getCount() {
            return listStorage.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder listViewHolder;
            if(convertView == null){
                listViewHolder = new ViewHolder();
                convertView = layoutinflater.inflate(R.layout.find_study_item, parent, false);

                listViewHolder.card_icon = (ImageView)convertView.findViewById(R.id.card_icon);
                listViewHolder.card_name = (TextView)convertView.findViewById(R.id.card_name);
                listViewHolder.card_region = (TextView)convertView.findViewById(R.id.card_region);
                listViewHolder.card_day = (TextView)convertView.findViewById(R.id.card_day);
                listViewHolder.card_abstract = (TextView)convertView.findViewById(R.id.card_abstract);

                convertView.setTag(listViewHolder);
            }else{
                listViewHolder = (ViewHolder)convertView.getTag();
            }

            listViewHolder.card_name.setText(listStorage.get(position).getName());
            listViewHolder.card_region.setText(listStorage.get(position).getRegion());
            listViewHolder.card_day.setText(listStorage.get(position).getDay());
            listViewHolder.card_abstract.setText(listStorage.get(position).getAbs());

            return convertView;
        }

        class ViewHolder{
            ImageView card_icon;
            TextView card_name;
            TextView card_region;
            TextView card_day;
            TextView card_abstract;
        }
    }






}
