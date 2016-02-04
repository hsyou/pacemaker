package com.example.hs.pacemaker.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.example.hs.pacemaker.R;

/**
 * Created by hs on 2016-02-03.
 */
public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(android.R.drawable.ic_menu_revert));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //fragment
        Fragment SearchFragment = new SearchFragment("");
        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.search_frame,new SearchHistory()).commit();

        //search view
        searchView=(SearchView)findViewById(R.id.searchView);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.search_frame,new SearchFragment(query)).commit();


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.search_frame,new SearchHistory()).commit();
                }
                return false;
            }
        });



    }
}
