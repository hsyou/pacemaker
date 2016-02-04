package com.example.hs.pacemaker.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

import java.util.List;

/**
 * Created by hs on 2016-02-03.
 */
public class HistoryListAdapter extends BaseAdapter {
    private List<String> list;
    LayoutInflater layoutInflater;
    HistoryDBHandler handler=null;

    public HistoryListAdapter(Context context) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        handler=HistoryDBHandler.getInstance(context);
        this.list=handler.getAllContacts();
    }

    public void updateList(){
        this.list=handler.getAllContacts();

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(getCount()-position-1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder=new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.history_list_item, parent, false);

            listViewHolder.tv = (TextView)convertView.findViewById(R.id.history_list_text);
            listViewHolder.iv=(ImageView)convertView.findViewById(R.id.history_list_button);

            convertView.setTag(listViewHolder);
        }else{
            listViewHolder=(ViewHolder)convertView.getTag();
        }
        listViewHolder.tv.setText(getItem(position).toString());
        listViewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.deleteContact(getItem(position).toString());
                updateList();
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView iv;
    }
}
