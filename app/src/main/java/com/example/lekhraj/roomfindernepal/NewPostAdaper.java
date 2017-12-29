package com.example.lekhraj.roomfindernepal;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by Lekhraj on 7/14/2017.
 */

public class NewPostAdaper extends FragmentStatePagerAdapter {
    Context c;
    public NewPostAdaper(FragmentActivity activity, FragmentManager fm) {
        super(fm);
        c = activity;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new AddNewPostFragment();
        }else if(position==1){
            return new ManagePostFragment();
        }else if(position==2){
            return new FeedbackFragment();
        }else{
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "New Post";
            case 1:
                return "Manage";
            case 2:
                return "Feedback";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
