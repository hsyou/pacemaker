package com.example.hs.pacemaker.timeline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-01-21.
 */
public class GridAdapter extends BaseAdapter{
    private Context mContext;

    @Override
    public int getCount() {
        return imgId.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null){
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView=(ImageView)convertView;
        }
        imageView.setImageResource(imgId[position]);
        return null;
    }

    public GridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    private Integer[] imgId={

         R.drawable.images, R.drawable.images, R.drawable.images
    };

}
