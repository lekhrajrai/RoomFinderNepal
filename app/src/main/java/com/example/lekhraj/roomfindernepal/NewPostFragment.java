package com.example.lekhraj.roomfindernepal;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by Lekhraj on 7/14/2017.
 */

public class NewPostFragment extends Fragment{
    PagerSlidingTabStrip pageTitle;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.activity_newpost, container,false);
        convertView.setBackgroundColor(Color.WHITE);
        return convertView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pageTitle = (PagerSlidingTabStrip)view.findViewById(R.id.pagerTitle);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);

        FragmentManager fm = getChildFragmentManager();
        viewPager.setAdapter(new NewPostAdaper(getActivity(),fm));
        pageTitle.setViewPager(viewPager);

    }
}
