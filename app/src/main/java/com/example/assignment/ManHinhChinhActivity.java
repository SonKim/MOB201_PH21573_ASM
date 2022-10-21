package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.assignment.Fragment.DocBaoFragment;
import com.example.assignment.Fragment.NgheNhacFragment;
import com.example.assignment.Fragment.TaiKhoanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ManHinhChinhActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    DocBaoFragment docBaoFragment = new DocBaoFragment();
    TaiKhoanFragment taiKhoanFragment = new TaiKhoanFragment();
    NgheNhacFragment ngheNhacFragment = new NgheNhacFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,docBaoFragment).commit();
        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itDocbao:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,docBaoFragment).commit();
                        return true;
                    case R.id.itTaikhoan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, taiKhoanFragment).commit();
                        return true;
                    case R.id.itNghenhac:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, ngheNhacFragment).commit();
                        return true;
                }
                return true;
            }
        });
        getSharedPreferences("TAIKHOAN",MODE_PRIVATE).edit().remove("user").clear();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}