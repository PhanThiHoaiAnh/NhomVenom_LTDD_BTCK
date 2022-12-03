package com.example.venom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TruyenTranhActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    SachAdapter sachAdapter;
    ArrayList<Sach> sachArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_van_hoc);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.rvSach);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Sach> options =
                new FirebaseRecyclerOptions.Builder<Sach>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("TruyenTranh"),Sach.class)
                        .build();
        sachAdapter = new SachAdapter(options);
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