package com.example.hs.pacemaker.timeline;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2016-01-09.
 */
public class TimelineSetup extends Fragment {

    private List<GroupObject> list;
    private List<DialogObject> dlist;
    CustomDialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.timeline_setup_layout, null);

        dlist=new ArrayList<>();

        for(int i=0;i<8;i++) {
            dlist.add(new DialogObject(R.mipmap.ic_launcher));
        }

        //dialog
        dialog=new CustomDialog(getContext(),dlist);
        dialog.setTitle("그룹 추가");
        dialog.setAddClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "추가하기", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.setCancleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "취소", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });




        //grid view
        list=new ArrayList<>();
        list.add(new GroupObject(R.mipmap.ic_launcher,"TOEIC"));
        list.add(new GroupObject(R.mipmap.ic_launcher,"러시아어"));
        list.add(new GroupObject(R.mipmap.ic_launcher,"추가"));

        GridView gridView=(GridView)rootView.findViewById(R.id.group_grid_view);
        GroupAdapter groupAdapter=new GroupAdapter(getContext(),list);
        gridView.setAdapter(groupAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==list.size()-1){
                    dialog.show();

                }else{
                    Toast.makeText(getContext(),position+"",Toast.LENGTH_SHORT).show();
                }
            }

        });
        return rootView;
    }

    public class GroupAdapter extends BaseAdapter {

        private LayoutInflater layoutinflater;
        private List<GroupObject> list;
        private Context context;

        public GroupAdapter(Context context, List<GroupObject> list) {
            this.context = context;
            layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size();
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
                convertView = layoutinflater.inflate(R.layout.timeline_grid_item, parent, false);

                listViewHolder.group_profile_img = (ImageView)convertView.findViewById(R.id.group_img);
                listViewHolder.group_name=(TextView)convertView.findViewById(R.id.group_name);
                convertView.setTag(listViewHolder);
            }else{
                listViewHolder = (ViewHolder)convertView.getTag();
            }
            listViewHolder.group_profile_img.setImageResource(list.get(position).getImg());
            listViewHolder.group_name.setText(list.get(position).getName());

            return convertView;
        }

        class ViewHolder{
            ImageView group_profile_img;
            TextView group_name;
        }
    }
}