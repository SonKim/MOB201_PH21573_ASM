package com.example.assignment.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.assignment.DangNhapActivity;
import com.example.assignment.R;
import com.example.assignment.dao.TaiKhoanDAO;
import com.example.assignment.model.TaiKhoan;

public class DangKyService extends Service {
    public DangKyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String user,password,rePassword;
        Bundle bundle = intent.getBundleExtra("TAIKHOAN");
        user = bundle.getString("user","");
        password = bundle.getString("password","");
        rePassword = bundle.getString("rePassword","");
        if(password.equals(rePassword)){
            TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO(getApplicationContext());
            TaiKhoan taiKhoan = new TaiKhoan(user, password, R.drawable.logo_garena);
            boolean check = taiKhoanDAO.dangKy(taiKhoan);
            if(check){
                Toast.makeText(this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Đăng ký tài khoản không thành công", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Mật khẩu và nhập lại mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}