package com.example.assignment;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.assignment.Fragment.Tin1Fragment;
import com.example.assignment.adapter.Tin1Adapter;
import com.example.assignment.model.Tin1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadTinTuc extends AsyncTask<String,Void,List<Tin1>> {
    Tin1Fragment fragment;
    public  DownloadTinTuc(Tin1Fragment fragment){
        this.fragment = fragment;
    }

    @Override
    protected List<Tin1> doInBackground(String... strings) {

        TinTucLoader loader = new TinTucLoader();
        List<Tin1> list = new ArrayList<>();

        // tạo url Connection để tải RSS
        String urlRss = strings[0];

        try {
            URL url = new URL(urlRss);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if(urlConnection.getResponseCode() ==200){
                // kết nối thành công thì mới lấy luồng dữ liệu
                InputStream inputStream = urlConnection.getInputStream();
                list = loader.getTinTucList( inputStream );
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    protected void onPostExecute(List<Tin1> tinTucs) {
        super.onPostExecute(tinTucs);

        Log.d("zzzzz", "onPostExecute: số lượng bài viết = " + tinTucs.size());
        for(int i = 0; i< tinTucs.size(); i++){
            Log.d("zzzzz", "Tiêu đề bài viết:  " + tinTucs.get(i).getTitle());
        }
        // đổ lên listView thì viết code ở đây
        // ListView lv = activity.findViewById(R.id.lv01);
        // làm tiếp với adapter....
        ListView lvTheGioi = fragment.getActivity().findViewById(R.id.lvTheGioi);
        Tin1Adapter tin1Adapter = new Tin1Adapter(fragment.getContext(), tinTucs);
        lvTheGioi.setAdapter(tin1Adapter);
        /*
        quay sang activity viết code thực thi như sau:
         String urlRss = "https://vnexpress.net/rss/cuoi.rss";

        DownloadTinTuc downloadTinTuc = new DownloadTinTuc(MainActivity.this);
        downloadTinTuc.execute(urlRss );
         */


    }
}
