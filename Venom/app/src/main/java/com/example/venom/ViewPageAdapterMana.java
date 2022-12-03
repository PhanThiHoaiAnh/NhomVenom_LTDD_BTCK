package com.example.venom;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapterMana extends FragmentStatePagerAdapter {
    public ViewPageAdapterMana(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BookManaFragment();
            case 1:
                return new CategoryManaFragment();
            case 2:
                return new StaffManaFragment();
            default:
                return new BookManaFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
