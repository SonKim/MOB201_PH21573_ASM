package com.example.assignment.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.assignment.DownloadTinTuc;
import com.example.assignment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tin1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tin1Fragment extends Fragment {
    ListView lvTheGioi;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Tin1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tin1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tin1Fragment newInstance(String param1, String param2) {
        Tin1Fragment fragment = new Tin1Fragment();
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
        View view = inflater.inflate(R.layout.fragment_tin1, container, false);
        lvTheGioi = view.findViewById(R.id.lvTheGioi);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlRss = "https://vnexpress.net/rss/the-gioi.rss";
        DownloadTinTuc downloadTinTuc = new DownloadTinTuc(this);
        downloadTinTuc.execute(urlRss);
    }
}