package com.example.hs.pacemaker.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-01-20.
 */
public class TimeLineUpload extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_upload_layout);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(android.R.drawable.ic_menu_revert));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
     /*   Toolbar toolbarBottom = (Toolbar)findViewById(R.id.toolbar_bottom);
        toolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.addImg_btn:
                        Toast.makeText(TimeLineUpload.this, "addImg", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.addTag_btn:
                        Toast.makeText(TimeLineUpload.this, "addTag", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.upload_btn:
                        Toast.makeText(TimeLineUpload.this, "upload", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });*/
    }
}
