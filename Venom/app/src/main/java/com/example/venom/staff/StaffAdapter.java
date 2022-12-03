package com.example.venom.staff;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.venom.R;

import java.util.List;

public class StaffAdapter extends ArrayAdapter<Staff> {
    private Activity activity;
    private int resource;
    private List<Staff> objects;

    public StaffAdapter(@NonNull Activity activity, int resource, @NonNull List<Staff> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) this.activity.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        TextView tv_maNV = view.findViewById(R.id.tv_idNV);
        TextView tv_tenNV = view.findViewById(R.id.tv_nameNV);
        TextView tv_CV = view.findViewById(R.id.tv_chucVu);
        TextView tv_nam = view.findViewById(R.id.tv_namSinh);

        Staff nhanVien = this.objects.get(i);

        tv_maNV.setText(nhanVien.getIdNV());
        tv_tenNV.setText(nhanVien.getTenNV());
        tv_CV.setText(nhanVien.getChucVu());
        tv_nam.setText(nhanVien.getNamSinh());
        return view;
    }
}
