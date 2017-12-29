package com.example.lekhraj.roomfindernepal;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by Lekhraj on 7/14/2017.
 */

class AdminAdaper extends FragmentStatePagerAdapter{
    Context c;
    public AdminAdaper(FragmentActivity activity, FragmentManager fm) {
        super(fm);
        c = activity;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new AddShiftingService();
        }else if(position==1){
            return new ReviewFeedback();
        }else
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Shifting Service";
            case 1:
                return "Review Feedback";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
