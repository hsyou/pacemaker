package com.example.hs.pacemaker.timeline;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hs.pacemaker.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hs on 2016-01-20.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<Recycler_item> items;
    int item_layout;

    public RecyclerAdapter(Context context, List<Recycler_item> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item,null);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Recycler_item item=items.get(position);
        Drawable drawable=context.getResources().getDrawable(item.getImg());
        holder.img.setBackground(drawable);
        holder.profileImg.setBackground(drawable);
        holder.id.setText(item.getId());
        holder.category.setText(item.getCategory());
        holder.time.setText(item.getTime());
        holder.like.setText(item.getLike()+"");
        holder.reply.setText(item.getReply()+"");
        holder.text.setText(item.getText());
        holder.hashTag.setText(item.getHashTag());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,TimelineContent.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("num",position);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        CircleImageView profileImg;
        TextView id;
        TextView category;
        TextView time;
        TextView like;
        TextView reply;
        TextView text;
        TextView hashTag;
        CardView cardview;


        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.timeline_img);
            profileImg=(CircleImageView)itemView.findViewById(R.id.timeline_profile_img);
            id=(TextView)itemView.findViewById(R.id.timeline_id);
            category=(TextView)itemView.findViewById(R.id.timeline_category);
            time=(TextView)itemView.findViewById(R.id.timeline_time);
            like=(TextView)itemView.findViewById(R.id.timeline_like);
            reply=(TextView)itemView.findViewById(R.id.timeline_reply);
            text=(TextView)itemView.findViewById(R.id.timeline_text);
            hashTag=(TextView)itemView.findViewById(R.id.timeline_hashTag);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
        }
    }
}