package model;

public abstract class Kendaraan {
    private String nama;
    private String tipe;
    private double tarifSewa;
    protected String merek;
    String warna;

    public Kendaraan(String nama, String tipe, double tarifSewa) {
        this.nama = nama;
        this.tipe = tipe;
        this.tarifSewa = tarifSewa;
    }

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

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public abstract String toString();
}
