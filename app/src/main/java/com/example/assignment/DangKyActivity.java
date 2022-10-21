package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.assignment.service.DangKyService;
import com.google.android.material.textfield.TextInputEditText;

public class DangKyActivity extends AppCompatActivity {
    TextInputEditText edTaiKhoan,edMatKhau,edNhapLaiMatKhau;
    Button btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        edTaiKhoan = findViewById(R.id.edTaiKhoan);
        edMatKhau = findViewById(R.id.edMatKhau);
        edNhapLaiMatKhau = findViewById(R.id.edNhapLaiMatKhau);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edTaiKhoan.getText().toString();
                String password = edMatKhau.getText().toString();
                String rePassword = edNhapLaiMatKhau.getText().toString();
                Intent intent = new Intent(DangKyActivity.this, DangKyService.class);
                Bundle bundle = new Bundle();
                bundle.putString("user",user);
                bundle.putString("password",password);
                bundle.putString("rePassword",rePassword);
                intent.putExtra("TAIKHOAN",bundle);
                startService(intent);
            }
        });
    }
}