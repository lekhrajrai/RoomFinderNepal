package com.example.lekhraj.roomfindernepal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Lekhraj on 7/10/2017.
 */

public class ActivityLuncher extends AppCompatActivity{
    Thread myLuncherThread;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myLuncherThread = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                Intent intent = new Intent(ActivityLuncher.this, ActivityHome.class);
                startActivity(intent);
                finish();
            }
        };
        myLuncherThread.start();
    }
}
