package com.example.hs.pacemaker.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hs.pacemaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2016-01-09.
 */
public class FriendFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button uploadBtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.timeline_friend_layout, null);

        //버튼

        uploadBtn=(Button)rootView.findViewById(R.id.upload_btn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),TimeLineUpload.class);
                startActivity(i);
            }
        });

        //리사이클러뷰 테스트
        RecyclerView recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        List<Recycler_item> items=new ArrayList<>();
        Recycler_item[] item=new Recycler_item[5];
        item[0]=new Recycler_item(R.drawable.images,R.drawable.images,"id","category","time",1,2,"1234567890asdasdasdasdzxczxczxczxcvbnvbnvbnvbnfghfghfghfghrtyrtyrtyrtyuiouiouiouiojkljkljkljklqweqweqweqwehjweacvbuygrvebgqverwyugbqvrewyugbqecwrybugcqewrybugcqrewygbueqwrygbui","#hash #hash");
        item[1]=new Recycler_item(R.drawable.images,R.drawable.images,"id","category","time",1,2,"text test text test","#hash #hash");
        item[2]=new Recycler_item(R.drawable.images,R.drawable.images,"id","category","time",1,2,"text test text test","#hashascascascascascascascascascascasc #hash");
        item[3]=new Recycler_item(R.drawable.images,R.drawable.images,"id","category","time",1,2,"text test text test",null);
        item[4]=new Recycler_item(R.drawable.images,R.drawable.images,"id","category","time",1,2,"text test text test",null);

        for(int i=0;i<5;i++) items.add(item[i]);

        recyclerView.setAdapter(new RecyclerAdapter(getActivity(),items,R.layout.timeline_friend_layout));
        return rootView;
    }
}