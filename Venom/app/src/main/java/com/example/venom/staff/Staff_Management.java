package com.example.venom.staff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venom.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Staff_Management extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    StaffAdapter staffAdapter;
    ArrayList<Staff> staffArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_staff_management);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.rvStaff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Staff> options =
                new FirebaseRecyclerOptions.Builder<Staff>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Member"), Staff.class)
                        .build();
        staffAdapter = new StaffAdapter(options);
        recyclerView.setAdapter(staffAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        staffAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        staffAdapter.stopListening();
    }
}

