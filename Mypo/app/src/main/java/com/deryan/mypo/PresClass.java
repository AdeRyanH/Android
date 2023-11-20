package com.deryan.mypo;

public class PresClass {
    private String name;
    String tahun;
    String deskripsi;
    int gambar;

    public PresClass(String name, String tahun, String deskripsi, int gambar) {
    this.name = name;
    this.tahun = tahun;
    this.deskripsi = deskripsi;
    this.gambar = gambar;
}
    public String getName() {
        return name;
    }
    public String getTahun() {
        return tahun;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public int getGambar() {
        return gambar;
    }
}
