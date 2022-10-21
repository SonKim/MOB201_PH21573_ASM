package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.service.DangNhapService;
import com.google.android.material.textfield.TextInputEditText;

public class DangNhapActivity extends AppCompatActivity {
    TextView tvDangKy,tvQuenMatKhau;
    TextInputEditText edTaiKhoan,edMatKhau;
    Button btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        tvDangKy = findViewById(R.id.tvDangKy);
        tvQuenMatKhau = findViewById(R.id.tvQuenMatKhau);
        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edMatKhau = findViewById(R.id.edMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edTaiKhoan.getText().toString();
                String password = edMatKhau.getText().toString();
                Intent intent = new Intent(DangNhapActivity.this, DangNhapService.class);
                Bundle bundle = new Bundle();
                bundle.putString("user",user);
                bundle.putString("password",password);
                intent.putExtra("DANGNHAP",bundle);
                startService(intent);
                SharedPreferences sharedPreferences = getSharedPreferences("TAIKHOAN",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user",user);
                editor.apply();
            }
        });
        tvQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DangNhapActivity.this, "Tính năng quên mật khẩu hiện chưa cập nhật!", Toast.LENGTH_SHORT).show();
            }
        });
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
    }
}