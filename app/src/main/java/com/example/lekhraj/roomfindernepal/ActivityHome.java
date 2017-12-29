package com.example.lekhraj.roomfindernepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Lekhraj on 7/9/2017.
 */

public class ActivityHome extends AppCompatActivity{
    String title;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentTransaction fragmentTransaction;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       if(getIntent().getExtras()!=null ) {
           fragmentTransaction = getSupportFragmentManager().beginTransaction();
           fragmentTransaction.add(R.id.container, new NewPostFragment());
           fragmentTransaction.commit();

       }
       else{
           fragmentTransaction = getSupportFragmentManager().beginTransaction();
           fragmentTransaction.add(R.id.container, new DefaultFragment());
           fragmentTransaction.commit();
       }
    }

    @Override
    protected void onStart() {
        super.onStart();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        toolbar = (Toolbar)findViewById(R.id.toolbarId);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Room Finder Napal");
        actionBarDrawerToggle = new ActionBarDrawerToggle(ActivityHome.this,drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        getSupportActionBar().setTitle(item.getTitle());
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, new DefaultFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.menu_newPost:
                        SharedPreferences s = getSharedPreferences("loginState",MODE_PRIVATE);
                        Boolean stateData = s.getBoolean("state",false);
                        if(stateData){
                           /* Intent i = new Intent(ActivityHome.this, ActivityHome.class);
                            startActivity(i);
                            finish();*/
                            getSupportActionBar().setTitle(item.getTitle());
                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container, new NewPostFragment());
                            fragmentTransaction.commit();
                            drawerLayout.closeDrawers();
                            break;
                        }
                        else{
                            Intent i = new Intent(ActivityHome.this, ActivityLogin.class);
                            startActivity(i);
                            finish();
                        }

                    case R.id.menu_search:
                        getSupportActionBar().setTitle(item.getTitle());
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, new SearchFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.menu_movers:
                        getSupportActionBar().setTitle(item.getTitle());
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, new MoversFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_contact:
                        getSupportActionBar().setTitle(item.getTitle());
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, new ContactFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.menu_feedback:
                        getSupportActionBar().setTitle(item.getTitle());
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, new FeedbackFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_signOut:
                        SharedPreferences sharedPreferences=getSharedPreferences("loginState",MODE_PRIVATE);
                        SharedPreferences.Editor et = sharedPreferences.edit();
                        et.remove("state");
                        et.commit();

                        Intent intent = new Intent(ActivityHome.this, ActivityHome.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_admin_login:
                Intent intent = new Intent(ActivityHome.this, AdminLogin.class);
                startActivity(intent);
                finish();
        }
        return true;
    }
}
