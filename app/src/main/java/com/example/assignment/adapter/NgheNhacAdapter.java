package com.example.assignment.adapter;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.Music;

import java.util.ArrayList;

public class NgheNhacAdapter extends BaseAdapter {
    Context context;
    ArrayList<Music> music;
    MediaPlayer mediaPlayer;
    boolean flag = true;
    public NgheNhacAdapter(Context context, ArrayList<Music> music) {
        this.context = context;
        this.music = music;
    }

    @Override
    public int getCount() {
        return music.size();
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
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item_nghenhac,null);
        }
        ImageView ivPlay = view.findViewById(R.id.ivPlay);
        ImageView ivStop = view.findViewById(R.id.ivStop);
        TextView tvTenBaiHat = view.findViewById(R.id.tvTenBaiHat);
        tvTenBaiHat.setText(music.get(i).getTenBaiHat());
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag){
                    mediaPlayer = MediaPlayer.create(context,music.get(i).getSong());
                    flag = false;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    ivPlay.setImageResource(R.drawable.ic_play);
                }else {
                    ivPlay.setImageResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                }
            }
        });
        ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                ivPlay.setImageResource(R.drawable.ic_play);
            }
        });
        return view;
    }
}
