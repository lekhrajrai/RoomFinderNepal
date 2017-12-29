package com.example.lekhraj.roomfindernepal;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lekhraj on 7/10/2017.
 */

public class DefaultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.activity_default_frag, container,false);
        convertView.setBackgroundColor(Color.WHITE);
        return convertView;
    }
}
