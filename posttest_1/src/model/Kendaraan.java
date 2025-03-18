// src/model/Kendaraan.java
package model;

public class Kendaraan {
    private String nama;
    private String tipe;
    private double tarifSewa;

    public Kendaraan(String nama, String tipe, double tarifSewa) {
        this.nama = nama;
        this.tipe = tipe;
        this.tarifSewa = tarifSewa;
    }

    // Getter and Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public double getTarifSewa() {
        return tarifSewa;
    }

    public void setTarifSewa(double tarifSewa) {
        this.tarifSewa = tarifSewa;
    }

    @Override
    public String toString() {
        return "Nama Kendaraan: " + nama + ", Tipe: " + tipe + ", Tarif Sewa: " + tarifSewa;
    }
}
