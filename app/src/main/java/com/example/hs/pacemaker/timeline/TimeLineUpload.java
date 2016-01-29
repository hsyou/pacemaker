package com.example.hs.pacemaker.timeline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-01-20.
 */
public class TimeLineUpload extends AppCompatActivity{

    EditText et_hashTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_upload_layout);

        Toolbar toolbar=(Toolbar)findViewById(R.id.upload_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(android.R.drawable.ic_menu_revert));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        et_hashTag=(EditText)findViewById(R.id.upload_hashTag);
        et_hashTag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String[] txt=s.toString().split(" ");
               for(int i=0;i<txt.length;i++){
                   if(txt[i].startsWith("#")){
                       et_hashTag.setTextColor(Color.parseColor("#65C6BB"));
                   }else{

                       et_hashTag.setTextColor(Color.BLACK);
                   }
               }

            }
        });


    }

}
