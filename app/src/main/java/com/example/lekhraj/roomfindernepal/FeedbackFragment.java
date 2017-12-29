package com.example.lekhraj.roomfindernepal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Lekhraj on 7/10/2017.
 */

public class FeedbackFragment extends Fragment {
    EditText my_feedback;
    Button sendFeedback;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.activity_feedback_frag,container,false);
        convertView.setBackgroundColor(Color.WHITE);
        return convertView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        my_feedback = (EditText)view.findViewById(R.id.et_feedback);
        sendFeedback = (Button)view.findViewById(R.id.btn_feedback);
        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
