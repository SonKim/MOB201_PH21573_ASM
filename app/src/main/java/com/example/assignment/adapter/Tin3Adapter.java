package com.example.assignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.WebViewActivity;
import com.example.assignment.model.Tin1;
import com.example.assignment.model.Tin3;

import java.util.List;

public class Tin3Adapter extends BaseAdapter {
    Context context;
    List<Tin3> tin3s;

    public Tin3Adapter(Context context, List<Tin3> tin3s) {
        this.context = context;
        this.tin3s = tin3s;
    }

    @Override
    public int getCount() {
        return tin3s.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_tin1,null);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(tin3s.get(i).getTitle());
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        tvDescription.setText(tin3s.get(i).getDescription());
        Button btnChiTiet = view.findViewById(R.id.btnChiTiet);
        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("link",tin3s.get(i).getLink());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
