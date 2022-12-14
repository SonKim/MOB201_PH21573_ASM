package com.example.assignment.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.DangNhapActivity;
import com.example.assignment.ManHinhChinhActivity;
import com.example.assignment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaiKhoanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaiKhoanFragment extends Fragment {
    ImageView ivAvatar,ivChinhSua;
    TextView tvTenTaiKhoan, tvBaiNhacYeuThich;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TaiKhoanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaiKhoanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaiKhoanFragment newInstance(String param1, String param2) {
        TaiKhoanFragment fragment = new TaiKhoanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        ivAvatar = view.findViewById(R.id.ivAvatar);
        ivChinhSua = view.findViewById(R.id.ivChinhSua);
        tvTenTaiKhoan = view.findViewById(R.id.tvTenTaiKhoan);
        tvBaiNhacYeuThich = view.findViewById(R.id.tvBaiNhacYeuThich);
        ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Ch???nh s???a Avatar hi???n ch??a c???p nh???t!", Toast.LENGTH_SHORT).show();
            }
        });
        ivChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvTenTaiKhoan.getText()=="T??i kho???n: Kh??ch h??ng"){
                    Intent intent = new Intent(getContext(), DangNhapActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getContext(), DangNhapActivity.class);
                    startActivity(intent);
                    Toast.makeText(getContext(), "????ng xu???t th??nh c??ng", Toast.LENGTH_SHORT).show();
                    getContext().getSharedPreferences("TAIKHOAN", Context.MODE_PRIVATE).edit().remove("user");
                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("TAIKHOAN", Context.MODE_PRIVATE);
        String tenTaiKhoan = sharedPreferences.getString("user","Kh??ch h??ng");
        tvTenTaiKhoan.setText("T??i kho???n: "+tenTaiKhoan);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}