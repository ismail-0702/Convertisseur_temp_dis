package com.example.convertisseurtempraturedistance;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Viewpageradapter extends FragmentStateAdapter {

    public Viewpageradapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) return new TempFragment();
        return new DistanceFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}