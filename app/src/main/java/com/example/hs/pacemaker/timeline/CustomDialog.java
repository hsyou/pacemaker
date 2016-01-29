package com.example.hs.pacemaker.timeline;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

import java.util.List;

/**
 * Created by hs on 2016-01-28.
 */
public class CustomDialog extends Dialog{

    Button add;
    Button cancle;
    GridView gridView;
    TextView category;
    List<DialogObject> list;
    public CustomDialog(Context context,List<DialogObject> list) {
        super(context);

        setContentView(R.layout.add_group_dialog);

        add=(Button)findViewById(R.id.dialog_add_btn);
        cancle=(Button)findViewById(R.id.dialog_cancel_btn);
        gridView=(GridView)findViewById(R.id.dialog_gridView);
        category=(TextView)findViewById(R.id.dialog_category);
        this.list=list;

        DialogAdapter adapter=new DialogAdapter(getContext(),list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

        });
    }

    public void setAddClickListener(View.OnClickListener l){
        add.setOnClickListener(l);
    }

    public void setCancleClickListener(View.OnClickListener l){
        cancle.setOnClickListener(l);
    }
    public class DialogAdapter extends BaseAdapter {

        private LayoutInflater layoutinflater;
        private List<DialogObject> list;
        private Context context;

        public DialogAdapter(Context context, List<DialogObject> list) {
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

                listViewHolder.dialog_img = (ImageView)convertView.findViewById(R.id.group_img);
                convertView.setTag(listViewHolder);
            }else{
                listViewHolder = (ViewHolder)convertView.getTag();
            }
            listViewHolder.dialog_img.setImageResource(list.get(position).getImg());


            return convertView;
        }

        class ViewHolder{
            ImageView dialog_img;

        }
    }
}
