package model;

public class Mobil extends Kendaraan {
    public Mobil(String nama, double tarifSewa) {
        super(nama, "Mobil", tarifSewa);
    }

    @Override
    public String toString() {
        return "[Mobil] Nama: " + getNama() + ", Tarif: " + getTarifSewa() + 
               ", Merek: " + getMerek() + ", Warna: " + getWarna();
    }
}
