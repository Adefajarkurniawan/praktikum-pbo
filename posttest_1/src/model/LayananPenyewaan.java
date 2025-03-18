// src/model/LayananPenyewaan.java
package model;

public class LayananPenyewaan {
    private Kendaraan[] kendaraan;
    private int indeksSekarang = 0;

    public LayananPenyewaan(int kapasitas) {
        kendaraan = new Kendaraan[kapasitas];
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        if (indeksSekarang < this.kendaraan.length) {
            this.kendaraan[indeksSekarang] = kendaraan;
            indeksSekarang++;
        } else {
            System.out.println("Tidak ada ruang untuk kendaraan baru.");
        }
    }

    public void sewaKendaraan(Pelanggan pelanggan, Kendaraan kendaraan, int hari) {
        double totalSewa = kendaraan.getTarifSewa() * hari;
        System.out.println(pelanggan.getNama() + " telah menyewa " + kendaraan.getNama() + " selama " + hari + " hari.");
        System.out.println("Total biaya sewa: " + totalSewa);
    }

    public void tampilkanKendaraanTersedia() {
        System.out.println("Kendaraan yang tersedia untuk disewa:");
        for (int i = 0; i < indeksSekarang; i++) {
            System.out.println(kendaraan[i]);
        }
    }

    // Getter untuk kendaraan
    public Kendaraan[] getKendaraan() {
        return kendaraan;
    }
}
