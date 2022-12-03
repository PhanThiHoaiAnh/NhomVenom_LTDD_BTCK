package com.example.venom;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


public class TheLoaiFragment extends Fragment {
    ImageView vanhoc, giaoduc, truyen,tieuthuyet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_theloai, container, false);

        vanhoc = v.findViewById(R.id.img_vanhoc);
        giaoduc = v.findViewById(R.id.img_giaoduc);
        truyen = v.findViewById(R.id.img_truyentranh);
        tieuthuyet = v.findViewById(R.id.img_tieuthuyet);




        giaoduc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SachGiaoDuc.class);
                startActivity(i);
            }
        });
        vanhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), SachVanHoc.class);
                startActivity(i);
            }
        });
        truyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), TruyenTranhActivity.class);
                startActivity(i);
            }
        });
        tieuthuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), TieuThuyet.class);
                startActivity(i);
            }
        });
        return v;

    }

    }
