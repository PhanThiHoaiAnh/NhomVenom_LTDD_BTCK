package com.example.venom.member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.venom.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MemberAdapter memberAdapter;
    ArrayList<Member> memberArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        getSupportActionBar().hide();

        ImageView addMember = findViewById(R.id.img_addmember);
        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Add_Member.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.rvMember);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Member"),Member.class)
                        .build();
        memberAdapter = new MemberAdapter(options);
        recyclerView.setAdapter(memberAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        memberAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        memberAdapter.stopListening();
    }
}