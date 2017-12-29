package com.example.lekhraj.roomfindernepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    EditText etEmail, etPassword;
    TextView forgetPassword;
    Button signin, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //share preference checking condition whether user is already login or not
        SharedPreferences sp = getSharedPreferences("loginState",MODE_PRIVATE);
        boolean state = sp.getBoolean("state",false);
        if(state){
            Intent i = new Intent(this,ActivityHome.class);
            startActivity(i);
            finish();
        }


        etEmail = (EditText)findViewById(R.id.login_email);
        etPassword = (EditText)findViewById(R.id.login_password);
        forgetPassword = (TextView)findViewById(R.id.login_forgetPassword);

        signin = (Button)findViewById(R.id.login_btnSignin);
        signup = (Button)findViewById(R.id.login_btnSignp);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModule m = new UserModule();
                m.setEmail(etEmail.getText().toString());
                m.setPassword(etPassword.getText().toString());

                LoginDbHelper db = new LoginDbHelper(ActivityLogin.this);
                int loginCheck = db.signinAuthentication(m);

                if(loginCheck>0){
                    Toast.makeText(ActivityLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    //saving state of login in local file
                    SharedPreferences sp = getSharedPreferences("loginState",MODE_PRIVATE);
                    SharedPreferences.Editor et = sp.edit();
                    et.putBoolean("state",true);
                    et.commit();

                    Intent in = new Intent(ActivityLogin.this, ActivityHome.class);
                   String value = "a";

                    Bundle bundle = new Bundle();
                    bundle.putString("key",value);
                    in.putExtras(bundle);
                    startActivity(in);
                    finish();
                    db.close();
                }
                else{
                    Toast.makeText(ActivityLogin.this, "Faile to login", Toast.LENGTH_SHORT).show();
                    db.close();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityLogin.this, ActivitySignup.class);
                startActivity(i);
                finish();
            }
        });
    }
}
