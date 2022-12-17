package com.example.quanlythuvien.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.example.quanlythuvien.R;
import com.example.quanlythuvien.member.Member;
import com.example.quanlythuvien.member.MemberAdapter;
import com.example.quanlythuvien.photo.Photo;
import com.example.quanlythuvien.photo.PhotoAdapter;
import com.example.quanlythuvien.sach.Sach;
import com.example.quanlythuvien.sach.TruyenTranhAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mListPhoto;
    private Timer mTimer;

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    TruyenTranhAdapter truyenTranhAdapter;
    ArrayList<Sach> sachArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewPager_photo);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        mListPhoto = getListPhoto();

        photoAdapter = new PhotoAdapter(HomeFragment.this, mListPhoto);
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        autoSlideImages();



        //Tạo adapter để gán cho List
        recyclerView = view.findViewById(R.id.rchome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Convert data
        FirebaseRecyclerOptions<Sach> options =
                new FirebaseRecyclerOptions.Builder<Sach>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("TruyenTranh"),Sach.class)
                        .build();
        truyenTranhAdapter = new TruyenTranhAdapter(options);
        recyclerView.setAdapter(truyenTranhAdapter);

        return view;
    }

    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.img));
        list.add(new Photo(R.drawable.home2));
        list.add(new Photo(R.drawable.home3));
        list.add(new Photo(R.drawable.home4));

        return list;
    }

    private void autoSlideImages(){
        if(mListPhoto == null || mListPhoto.isEmpty() || viewPager == null){
            return;
        }
        // Init

        if (mTimer == null){
            mTimer = new Timer();
        }

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size() - 1;
                        if(currentItem < totalItem ){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500,3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }
    public void onStart() {
        super.onStart();
        truyenTranhAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        truyenTranhAdapter.stopListening();

    }
}
