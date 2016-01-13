package com.example.hs.pacemaker.main;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.hs.pacemaker.R;
import com.example.hs.pacemaker.planer.PlannerTab;
import com.example.hs.pacemaker.profile.ProfileFragment;
import com.example.hs.pacemaker.studygroup.StudygroupTab;
import com.example.hs.pacemaker.timeline.TabFragment;
import com.example.hs.pacemaker.timer.TimerTab;


public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navi_view) ;

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_profile) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new ProfileFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_timeline) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_timer) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TimerTab()).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_planer) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new PlannerTab()).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_studygroup) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new StudygroupTab()).commit();
                }

                return false;
            }

        });

//툴바
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.toolbar_search) {
            Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.toolbar_mail){

            Toast.makeText(MainActivity.this, "mail", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}

