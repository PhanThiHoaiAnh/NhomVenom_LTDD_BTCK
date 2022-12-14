package com.example.quanlythuvien.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quanlythuvien.R;
import com.example.quanlythuvien.phieumuon.ThemPhieuMuon;
import com.example.quanlythuvien.sach.Sach;
import com.example.quanlythuvien.sach.SachGiaoDucAdapter;
import com.example.quanlythuvien.sach.TruyenTranhAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TruyenTranh extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    TruyenTranhAdapter sachAdapter;
    ArrayList<Sach> sachArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_giao_duc);
        getSupportActionBar().hide();
        ImageView addSach = findViewById(R.id.img_addsach);
        addSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThemPhieuMuon.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rvSach);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Sach> options =
                new FirebaseRecyclerOptions.Builder<Sach>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("TruyenTranh"),Sach.class)
                        .build();
        sachAdapter = new TruyenTranhAdapter(options);
        recyclerView.setAdapter(sachAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        sachAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sachAdapter.stopListening();
    }
}