package com.example.assignment.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.example.assignment.DangNhapActivity;
import com.example.assignment.MainActivity;
import com.example.assignment.ManHinhChinhActivity;
import com.example.assignment.R;
import com.example.assignment.dao.TaiKhoanDAO;
import com.example.assignment.model.TaiKhoan;

public class DangNhapService extends Service {
    public DangNhapService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getBundleExtra("DANGNHAP");
        String user = bundle.getString("user","");
        String password = bundle.getString("password","");
        TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO(this);
        boolean check = taiKhoanDAO.checkDangNhap(user,password);
        if(check){
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(this, ManHinhChinhActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent1);
        }else {
            Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}