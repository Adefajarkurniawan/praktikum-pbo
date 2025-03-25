package model;

public class Pelanggan {
    private String nama;
    private String kontak;

    public Pelanggan(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }

    public String toString() {
        return "Nama Pelanggan: " + nama + ", Kontak: " + kontak;
    }
}
