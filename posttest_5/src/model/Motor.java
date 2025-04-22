package model;

public class Motor extends Kendaraan {
    public Motor(String nama, double tarifSewa) {
        super(nama, "Motor", tarifSewa);
    }

    @Override
    public String toString() {
        return "[Motor] Nama: " + getNama() + ", Tarif: " + getTarifSewa() + 
               ", Merek: " + getMerek() + ", Warna: " + getWarna();
    }
}
