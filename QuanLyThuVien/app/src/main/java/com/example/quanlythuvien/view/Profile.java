package com.example.quanlythuvien.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlythuvien.R;
import com.example.quanlythuvien.staff.Staff;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends Fragment {
    private FirebaseUser user;
    private DatabaseReference reference;
    private  String userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_profile, container, false);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Staff");
        userID = user.getUid();

        final TextView tvname = v.findViewById(R.id.tvName);
        final TextView tvemail = v.findViewById(R.id.tvEmail);
        final TextView tvage =v.findViewById(R.id.tvAge);
        final TextView tvchucvu = v.findViewById(R.id.tvChucvu);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Staff staff = snapshot.getValue(Staff.class);
                if(staff != null ){
                    String  name = staff.tenNV;
                    String email = staff.email;
                    String age = staff.age;
                    String chucvu = staff.chucVu;

                    tvname.setText(name);
                    tvemail.setText(email);
                    tvage.setText(age);
                    tvchucvu.setText(chucvu);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });

       return v;
    }
}