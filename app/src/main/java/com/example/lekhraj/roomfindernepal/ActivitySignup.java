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
 * Created by Lekhraj on 7/9/2017.
 */

public class ActivitySignup extends AppCompatActivity{
    EditText fname, lname, email, phone, address,password;
    Button btnSignup, btnCancel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fname = (EditText)findViewById(R.id.reg_fname);
        lname = (EditText)findViewById(R.id.reg_lname);
        email = (EditText)findViewById(R.id.reg_email);
        phone = (EditText)findViewById(R.id.reg_phone);
        address = (EditText)findViewById(R.id.reg_address);
        password = (EditText)findViewById(R.id.reg_password);

        btnSignup = (Button)findViewById(R.id.reg_btnSignup);
        btnCancel =(Button)findViewById(R.id.reg_cancel);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDbHelper db = new LoginDbHelper(ActivitySignup.this);
                UserModule m = new UserModule();

                m.setFirstName(fname.getText().toString());
                m.setLastName(lname.getText().toString());
                m.setEmail(email.getText().toString());
                m.setPhone(phone.getText().toString());
                m.setAddress(address.getText().toString());
                m.setPassword(password.getText().toString());

                boolean check = db.signUpUsers(m);
                if(check==true){
                    Toast.makeText(ActivitySignup.this, "Signup successful", Toast.LENGTH_SHORT).show();
                    db.close();
                    Intent intent = new Intent(ActivitySignup.this, ActivityLogin.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(ActivitySignup.this, "Failed to sign up", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySignup.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
