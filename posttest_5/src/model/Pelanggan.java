package model;

public final class Pelanggan {
    private String nama;
    private final String kontak; // final attribute

    public Pelanggan(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }

    public final String getKontak() { // final method
        return kontak;
    }

    public String toString() {
        return "Nama Pelanggan: " + nama + ", Kontak: " + kontak;
    }
}
