package com.example.assignment.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.assignment.DownloadTinTuc2;
import com.example.assignment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tin2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tin2Fragment extends Fragment {
    ListView lvKinhDoanh;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tin2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tin2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tin2Fragment newInstance(String param1, String param2) {
        Tin2Fragment fragment = new Tin2Fragment();
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
        View view = inflater.inflate(R.layout.fragment_tin2, container, false);
        lvKinhDoanh = view.findViewById(R.id.lvKinhDoanh);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlRss = "https://vnexpress.net/rss/thoi-su.rss";
        DownloadTinTuc2 downloadTinTuc = new DownloadTinTuc2(this);
        downloadTinTuc.execute(urlRss);
    }
}