package com.example.hs.pacemaker.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hs on 2016-01-24.
 */
public class TimelineContent  extends AppCompatActivity {
    TextView text;
    TextView id;
    TextView hashTag;
    TextView time1;
    TextView time2;
    EditText comment_et;
    private List<CommentObject> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_content_layout);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        );
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.content_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(android.R.drawable.ic_menu_revert));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        //content
        id = (TextView) findViewById(R.id.content_id);
        id.setText("id");
        time1 = (TextView) findViewById(R.id.content_time1);
        time1.setText("time1");
        time2 = (TextView) findViewById(R.id.content_time2);
        time2.setText("time2");
        hashTag = (TextView) findViewById(R.id.content_hashTag);
        hashTag.setText("#콘푸로스트 #토익");

        Intent i = getIntent();
        int a = i.getIntExtra("num", 100);
        text = (TextView) findViewById(R.id.content_text);
        text.setText(a + " 번째 게시물 \n" +
                "넌 나고 난 너야\n" +
                "난 너고 넌 나야\n" +
                "마음이 같다면\n" +
                "둘은 서로가 될 거야\n" +
                "넌 나고 난 너야\n" +
                "그림 너무 좋아\n" +
                "오그라든다는 말은 누가 만든 걸까 \n" +
                "\n" +
                "girl 뺨 한 대만 때려줘 며칠 사이 내게\n" +
                "무슨 일이 벌어진 건지\n" +
                "전 여친 번호 지우고\n" +
                "힙합만 듣던\n" +
                "난 어쿠스틱해졌어\n" +
                "\n" +
                "tell me what you want from me \n" +
                "가장 예쁠 나이엔\n" +
                "실컷 사랑해봐야 돼 eh \n" +
                "네 사연 속에 나오는 쓰레기\n" +
                "걔랑은 비교도 안되게\n" +
                "내가 잘할게 왜냐면 \n" +
                "\n" +
                "넌 나고 난 너야\n" +
                "난 너고 넌 나야\n" +
                "마음이 같다면\n" +
                "둘은 서로가 될 거야\n" +
                "넌 나고 난 너야\n" +
                "그림 너무 좋아\n" +
                "오그라든다는 말은\n" +
                "누가 만든 걸까 ");

        comment_et=(EditText)findViewById(R.id.comment_et);
        //comment
        list=new ArrayList<>();
        list.add(new CommentObject(R.mipmap.ic_launcher, "pycckuuypa","친구들이 말해 좋을 때야\n" +
                "난 딱히 걱정 없고"));
        list.add(new CommentObject(R.mipmap.ic_launcher, "pycckuuypa","하도 좋아서 문제야"));
        list.add(new CommentObject(R.mipmap.ic_launcher, "pycckuuypa","이거 봐 욕도 줄이고 있고"));

        ListView listView=(ListView)findViewById(R.id.content_comment_list);
        CommentListAdapter commentAdapter=new CommentListAdapter(this,list);

        listView.setAdapter(commentAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        //listview size
        int height=0;
        for(int size=0;size<commentAdapter.getCount();size++){
            View listItem=commentAdapter.getView(size,null,listView);
            listItem.measure(0,0);
            height+=listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params=listView.getLayoutParams();
        params.height=height+(listView.getDividerHeight()*(commentAdapter.getCount()-1));
        listView.setLayoutParams(params);

    }

    public class CommentListAdapter extends BaseAdapter {

        private LayoutInflater layoutinflater;
        private List<CommentObject> list;
        private Context context;

        public CommentListAdapter(Context context, List<CommentObject> list) {
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
                convertView = layoutinflater.inflate(R.layout.comment_list_item, parent, false);

                listViewHolder.comment_profile_img = (ImageView)convertView.findViewById(R.id.comment_profile_img);
                listViewHolder.comment_id=(TextView)convertView.findViewById(R.id.comment_id);
                listViewHolder.comment=(TextView)convertView.findViewById(R.id.comment);
                convertView.setTag(listViewHolder);
            }else{
                listViewHolder = (ViewHolder)convertView.getTag();
            }
            listViewHolder.comment_profile_img.setImageResource(list.get(position).getImg());
            listViewHolder.comment_id.setText(list.get(position).getName());
            listViewHolder.comment.setText(list.get(position).getComment());
            return convertView;
        }

        class ViewHolder{
            ImageView comment_profile_img;
            TextView comment_id;
            TextView comment;
        }
    }
}

