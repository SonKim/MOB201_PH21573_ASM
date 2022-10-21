package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment.Fragment.Tin1Fragment;
import com.example.assignment.Fragment.Tin2Fragment;
import com.example.assignment.Fragment.Tin3Fragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    Tin1Fragment tin1Fragment = new Tin1Fragment();
    Tin2Fragment tin2Fragment = new Tin2Fragment();
    Tin3Fragment tin3Fragment = new Tin3Fragment();
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return tin1Fragment;
            case 1:
                return tin2Fragment;
            case 2:
                return tin3Fragment;
            default:
                return tin1Fragment;

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
