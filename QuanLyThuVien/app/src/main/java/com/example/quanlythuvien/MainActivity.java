package com.example.quanlythuvien;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlythuvien.databinding.ActivityMainBinding;
import com.example.quanlythuvien.member.MemberFragment;
import com.example.quanlythuvien.phieumuon.PhieuMuonFragment;
import com.example.quanlythuvien.view.NhanVienFragment;
import com.example.quanlythuvien.view.Profile;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new NhanVienFragment());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.action_home:
                    replaceFragment(new NhanVienFragment());
                    break;
                case R.id.active_theloai:
                    replaceFragment(new TheLoaiFragment());
                    break;
                case R.id.action_phieumuon:
                    replaceFragment(new PhieuMuonFragment());
                    break;
                case R.id.action_thanhvien:
                    replaceFragment(new MemberFragment());
                    break;
                case R.id.action_profile:
                    replaceFragment(new Profile());
                    break;


            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
    }
