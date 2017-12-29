package com.example.lekhraj.roomfindernepal;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.GridLayout;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by Lekhraj on 7/15/2017.
 */

public class AdminActivity extends AppCompatActivity {
    PagerSlidingTabStrip titlePage;
    ViewPager viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();

        titlePage = (PagerSlidingTabStrip)findViewById(R.id.adminPageTitle);
        viewPager = (ViewPager)findViewById(R.id.pageViewer);
        toolbar = (Toolbar)findViewById(R.id.toolbarId);

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Admin Panel");
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new AdminAdaper(AdminActivity.this,fm));
        titlePage.setViewPager(viewPager);
    }
}
