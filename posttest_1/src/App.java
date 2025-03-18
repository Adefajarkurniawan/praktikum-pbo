import java.util.Scanner;
import model.Kendaraan;
import model.Pelanggan;
import model.LayananPenyewaan;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek kendaraan
        Kendaraan mobil = new Kendaraan("Toyota Corolla", "Mobil", 200000);
        Kendaraan motor = new Kendaraan("Yamaha R15", "Motor", 100000);
        
        // Membuat objek pelanggan
        Pelanggan pelanggan1 = new Pelanggan("Ade434", "081234567890");
        
        // Membuat layanan penyewaan
        LayananPenyewaan layananPenyewaan = new LayananPenyewaan(5);
        layananPenyewaan.tambahKendaraan(mobil);
        layananPenyewaan.tambahKendaraan(motor);

        // Menampilkan menu
        boolean running = true;
        while (running) {
            System.out.println("\n==== Menu CRUD Penyewaan Kendaraan ====");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Kendaraan Tersedia");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Update Kendaraan");
            System.out.println("5. Delete Kendaraan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            int pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    // Menambahkan kendaraan
                    scanner.nextLine();  // Membersihkan buffer
                    System.out.print("Masukkan nama kendaraan: ");
                    String namaKendaraan = scanner.nextLine();
                    System.out.print("Masukkan tipe kendaraan: ");
                    String tipeKendaraan = scanner.nextLine();
                    System.out.print("Masukkan tarif sewa per hari: ");
                    double tarifSewa = scanner.nextDouble();
                    Kendaraan kendaraanBaru = new Kendaraan(namaKendaraan, tipeKendaraan, tarifSewa);
                    layananPenyewaan.tambahKendaraan(kendaraanBaru);
                    System.out.println("Kendaraan berhasil ditambahkan.");
                    break;
                
                case 2:
                    // Menampilkan kendaraan yang tersedia
                    layananPenyewaan.tampilkanKendaraanTersedia();
                    break;

                case 3:
                    // Menyewa kendaraan
                    scanner.nextLine();  // Membersihkan buffer
                    System.out.print("Masukkan nama kendaraan yang ingin disewa: ");
                    String namaSewa = scanner.nextLine();
                    Kendaraan kendaraanSewa = null;

                    // Mencari kendaraan berdasarkan nama menggunakan getter
                    for (Kendaraan k : layananPenyewaan.getKendaraan()) {
                        if (k != null && k.getNama().equalsIgnoreCase(namaSewa)) {
                            kendaraanSewa = k;
                            break;
                        }
                    }

                    if (kendaraanSewa != null) {
                        System.out.print("Masukkan jumlah hari penyewaan: ");
                        int hariSewa = scanner.nextInt();
                        layananPenyewaan.sewaKendaraan(pelanggan1, kendaraanSewa, hariSewa);
                    } else {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;

                    case 4:
                    // Update kendaraan
                    scanner.nextLine();  // Membersihkan buffer
                    System.out.print("Masukkan nama kendaraan yang ingin diupdate: ");
                    String namaKendaraanUpdate = scanner.nextLine();
                    Kendaraan kendaraanUpdate = null;
                    int indexKendaraanUpdate = -1;
                
                    // Mencari kendaraan berdasarkan nama
                    for (int i = 0; i < layananPenyewaan.getKendaraan().length; i++) {
                        Kendaraan k = layananPenyewaan.getKendaraan()[i];
                        if (k != null && k.getNama().equalsIgnoreCase(namaKendaraanUpdate)) {
                            kendaraanUpdate = k;
                            indexKendaraanUpdate = i;
                            break;
                        }
                    }
                
                    if (kendaraanUpdate != null) {
                        System.out.println("Kendaraan ditemukan. Silakan update:");
                        System.out.print("Masukkan nama baru kendaraan: ");
                        String namaBaru = scanner.nextLine();
                        System.out.print("Masukkan tipe baru kendaraan: ");
                        String tipeBaru = scanner.nextLine();
                        System.out.print("Masukkan tarif sewa baru per hari: ");
                        double tarifBaru = scanner.nextDouble();
                        
                        // Update kendaraan dalam array
                        kendaraanUpdate.setNama(namaBaru);
                        kendaraanUpdate.setTipe(tipeBaru);
                        kendaraanUpdate.setTarifSewa(tarifBaru);
                        
                        System.out.println("Kendaraan berhasil diupdate.");
                    } else {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;                

                case 5:
                    // Delete kendaraan
                    scanner.nextLine();  // Membersihkan buffer
                    System.out.print("Masukkan nama kendaraan yang ingin dihapus: ");
                    String namaKendaraanHapus = scanner.nextLine();
                    boolean kendaraanDihapus = false;

                    // Mencari dan menghapus kendaraan berdasarkan nama
                    for (int i = 0; i < layananPenyewaan.getKendaraan().length; i++) {
                        if (layananPenyewaan.getKendaraan()[i] != null &&
                            layananPenyewaan.getKendaraan()[i].getNama().equalsIgnoreCase(namaKendaraanHapus)) {
                            layananPenyewaan.getKendaraan()[i] = null;  // Menghapus kendaraan
                            kendaraanDihapus = true;
                            System.out.println("Kendaraan berhasil dihapus.");
                            break;
                        }
                    }

                    if (!kendaraanDihapus) {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;

                case 6:
                    // Keluar dari program
                    System.out.println("Terima kasih telah menggunakan sistem penyewaan kendaraan.");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
