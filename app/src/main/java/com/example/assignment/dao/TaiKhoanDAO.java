package com.example.assignment.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.database.DBHelper;
import com.example.assignment.model.TaiKhoan;

public class TaiKhoanDAO {
    DBHelper dbHelper;
    public TaiKhoanDAO(Context context){
        dbHelper = new DBHelper(context);
    }
    public boolean checkDangNhap(String user, String password){
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM TAIKHOAN WHERE USER = ? AND PASSWORD = ?",new String[]{user,password});
        if(cursor.getCount()>0){
            return true;
        }
        return false;
    }
    public boolean dangKy(TaiKhoan taiKhoan){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("USER",taiKhoan.getUser());
        values.put("PASSWORD",taiKhoan.getPassword());
        values.put("AVATAR",taiKhoan.getAvatar());
        long check = database.insert("TAIKHOAN",null,values);
        if(check>0){
            return true;
        }
        return false;
    }
}
