package com.example.assignment.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbTaiKhoan = "CREATE TABLE TAIKHOAN(USER NARCHAR PRIMARY KEY, PASSWORD NARCHAR, AVATAR INTEGER)";
        sqLiteDatabase.execSQL(dbTaiKhoan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
