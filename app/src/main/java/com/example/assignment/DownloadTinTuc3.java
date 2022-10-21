package com.example.assignment;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.example.assignment.Fragment.Tin3Fragment;
import com.example.assignment.adapter.Tin2Adapter;
import com.example.assignment.adapter.Tin3Adapter;
import com.example.assignment.model.Tin2;
import com.example.assignment.model.Tin3;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadTinTuc3 extends AsyncTask<String,Void,List<Tin3>> {
    Tin3Fragment fragment = null;
    public DownloadTinTuc3(Tin3Fragment fragment){
        this.fragment = fragment;
    }

    @Override
    protected List<Tin3> doInBackground(String... strings) {

        TinTucLoader3 loader = new TinTucLoader3();
        List<Tin3> list = new ArrayList<>();

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
    protected void onPostExecute(List<Tin3> tinTucs) {
        super.onPostExecute(tinTucs);

        Log.d("zzzzz", "onPostExecute: số lượng bài viết = " + tinTucs.size());
        for(int i = 0; i< tinTucs.size(); i++){
            Log.d("zzzzz", "Tiêu đề bài viết:  " + tinTucs.get(i).getTitle());
        }
        // đổ lên listView thì viết code ở đây
        // ListView lv = activity.findViewById(R.id.lv01);
        // làm tiếp với adapter....
        ListView lvKinhDoanh = fragment.getActivity().findViewById(R.id.lvKinhDoanh);
        Tin3Adapter tin3Adapter = new Tin3Adapter(fragment.getContext(), tinTucs);
        lvKinhDoanh.setAdapter(tin3Adapter);
        /*
        quay sang activity viết code thực thi như sau:
         String urlRss = "https://vnexpress.net/rss/cuoi.rss";

        DownloadTinTuc downloadTinTuc = new DownloadTinTuc(MainActivity.this);
        downloadTinTuc.execute(urlRss );
         */


    }
}
