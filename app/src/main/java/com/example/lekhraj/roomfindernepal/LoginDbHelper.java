package com.example.lekhraj.roomfindernepal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Lekhraj on 7/12/2017.
 */

public class LoginDbHelper extends SQLiteOpenHelper{
    final static String DBNAME= "rfn";

    public LoginDbHelper(Context context) {
        super(context,DBNAME,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists users(userId integer primary key autoincrement, firstName varchar(60),lastName varchar(60), userAddress varchar(60), userPhone double, userEmail varchar(60), userPassword varchar(60))");
        db.execSQL("create table if not exists admin(adminId integer primary key autoincrement, adminUsername varchar(60), adminPassword varchar(60))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if users exists");
        db.execSQL("drop table if admin exists");
    }

    public boolean signUpUsers(UserModule m) {
        if(m.getEmail().isEmpty()||m.getFirstName().isEmpty()||m.getLastName().isEmpty()||m.getAddress().isEmpty()||m.getPhone().isEmpty()||m.getPassword().isEmpty()){
            return false;
        }else{
            SQLiteDatabase sq = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("firstName",m.getFirstName());
            cv.put("lastName",m.getLastName());
            cv.put("userAddress",m.getAddress());
            cv.put("userPhone",m.getPhone());
            cv.put("userEmail",m.getEmail());
            cv.put("userPassword",m.getPassword());
            sq.insert("users",null,cv);
        }
        return true;
    }
    public int signinAuthentication(UserModule m) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where userEmail =? and userPassword=?", new String[]{m.getEmail(),m.getPassword()});
        return c.getCount();
    }
    public boolean signUpAdmin(AdminModule m) {
        if(m.getAdminPassword().isEmpty()||m.getAdminUsername().isEmpty()){
            return false;
        }else{
            SQLiteDatabase sd = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("adminUsername",m.getAdminUsername());
            cv.put("adminPassword",m.getAdminPassword());
            sd.insert("admin",null,cv);
        }
        return true;
    }

    public int adminAuth(AdminModule m) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from admin where adminUsername=? and adminPassword=?", new String[]{m.getAdminUsername(),m.getAdminPassword()});
        return c.getCount();
    }


}
