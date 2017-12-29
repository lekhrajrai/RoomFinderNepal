package com.example.lekhraj.roomfindernepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Lekhraj on 7/15/2017.
 */

public class AdminLogin extends AppCompatActivity {
    private EditText username, password;
    private Button admin_btnSignin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        username = (EditText)findViewById(R.id.admin_username);
        password = (EditText)findViewById(R.id.admin_password);

        admin_btnSignin = (Button)findViewById(R.id.admin_login);

       /* admin_btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDbHelper db = new LoginDbHelper(AdminLogin.this);
                AdminModule m = new AdminModule();

                m.setAdminUsername(username.getText().toString());
                m.setAdminPassword(password.getText().toString());

                boolean check = db.signUpAdmin(m);
                if(check==true){
                    Toast.makeText(AdminLogin.this, "Signup successful", Toast.LENGTH_SHORT).show();
                    db.close();
                    Intent intent = new Intent(AdminLogin.this, AdminActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(AdminLogin.this, "Failed to sign up", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });*/
        admin_btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminModule m = new AdminModule();
                m.setAdminUsername(username.getText().toString());
                m.setAdminPassword(password.getText().toString());

                LoginDbHelper db = new LoginDbHelper(AdminLogin.this);

                int loginCheck = db.adminAuth(m);

                if(loginCheck>0){
                    Toast.makeText(AdminLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    /*//saving state of login in local file
                    SharedPreferences sp = getSharedPreferences("loginState",MODE_PRIVATE);
                    SharedPreferences.Editor et = sp.edit();
                    et.putBoolean("state",true);
                    et.commit();*/

                    Intent in = new Intent(AdminLogin.this, AdminActivity.class);
                    startActivity(in);
                    finish();
                    db.close();
                }
                else{
                    Toast.makeText(AdminLogin.this, "Faile to login", Toast.LENGTH_SHORT).show();
                    db.close();
                }
            }
        });
    }
}
