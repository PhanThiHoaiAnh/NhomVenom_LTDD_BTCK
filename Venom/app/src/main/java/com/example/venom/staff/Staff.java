package com.example.venom.staff;

public class Staff {
    private String idNV, tenNV, chucVu;
    private int namSinh;

    public Staff(String idNV, String tenNV, String chucVu, int namSinh) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.chucVu = chucVu;
        this.namSinh = namSinh;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
}
