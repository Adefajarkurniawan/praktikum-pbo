import java.util.Scanner;
import model.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kendaraan mobil = new Mobil("Toyota Corolla", 200000);
        Kendaraan motor = new Motor("Yamaha R15", 100000);

        mobil.setWarna("Hitam");
        mobil.setMerek("Toyota");
        motor.setWarna("Merah");
        motor.setMerek("Yamaha");

        Pelanggan pelanggan1 = new Pelanggan("Ade434", "081234567890");

        LayananPenyewaan layananPenyewaan = new LayananPenyewaan(10);
        layananPenyewaan.tambahKendaraan(mobil);
        layananPenyewaan.tambahKendaraan(motor);

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
                    scanner.nextLine();
                    System.out.print("Masukkan nama kendaraan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan tipe kendaraan (Mobil/Motor): ");
                    String tipe = scanner.nextLine();
                    System.out.print("Masukkan tarif sewa: ");
                    double tarif = scanner.nextDouble();

                    Kendaraan kendaraanBaru;
                    if (tipe.equalsIgnoreCase("Mobil")) {
                        kendaraanBaru = new Mobil(nama, tarif);
                    } else {
                        kendaraanBaru = new Motor(nama, tarif);
                    }

                    scanner.nextLine();
                    System.out.print("Masukkan warna: ");
                    String warna = scanner.nextLine();
                    System.out.print("Masukkan merek: ");
                    String merek = scanner.nextLine();

                    kendaraanBaru.setWarna(warna);
                    kendaraanBaru.setMerek(merek);

                    layananPenyewaan.tambahKendaraan(kendaraanBaru);
                    System.out.println("Kendaraan berhasil ditambahkan.");
                    break;

                case 2:
                    layananPenyewaan.tampilkanKendaraanTersedia();
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Nama pelanggan: ");
                    String namaP = scanner.nextLine();
                    System.out.print("No Telp: ");
                    String telp = scanner.nextLine();
                    Pelanggan pelanggan = new Pelanggan(namaP, telp);

                    System.out.print("Nama kendaraan: ");
                    String namaKendaraan = scanner.nextLine();
                    System.out.print("Hari sewa: ");
                    int hari = scanner.nextInt();

                    Kendaraan kendaraanSewa = null;
                    for (Kendaraan k : layananPenyewaan.getKendaraan()) {
                        if (k != null && k.getNama().equalsIgnoreCase(namaKendaraan)) {
                            kendaraanSewa = k;
                            break;
                        }
                    }

                    if (kendaraanSewa != null) {
                        layananPenyewaan.sewaKendaraan(pelanggan, kendaraanSewa, hari);
                    } else {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("Nama kendaraan yang ingin diupdate: ");
                    String namaOld = scanner.nextLine();

                    Kendaraan updateTarget = null;
                    for (Kendaraan k : layananPenyewaan.getKendaraan()) {
                        if (k != null && k.getNama().equalsIgnoreCase(namaOld)) {
                            updateTarget = k;
                            break;
                        }
                    }

                    if (updateTarget != null) {
                        System.out.print("Nama baru: ");
                        String namaBaru = scanner.nextLine();
                        System.out.print("Tipe baru (Mobil/Motor): ");
                        String tipeBaru = scanner.nextLine();
                        System.out.print("Tarif baru: ");
                        double tarifBaru = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Warna baru: ");
                        String warnaBaru = scanner.nextLine();
                        System.out.print("Merek baru: ");
                        String merekBaru = scanner.nextLine();

                        updateTarget.setNama(namaBaru);
                        updateTarget.setTipe(tipeBaru);
                        updateTarget.setTarifSewa(tarifBaru);
                        updateTarget.setWarna(warnaBaru);
                        updateTarget.setMerek(merekBaru);

                        System.out.println("Kendaraan berhasil diupdate.");
                    } else {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.print("Nama kendaraan yang ingin dihapus: ");
                    String delNama = scanner.nextLine();

                    boolean ditemukan = false;
                    for (int i = 0; i < layananPenyewaan.getKendaraan().length; i++) {
                        Kendaraan k = layananPenyewaan.getKendaraan()[i];
                        if (k != null && k.getNama().equalsIgnoreCase(delNama)) {
                            layananPenyewaan.getKendaraan()[i] = null;
                            System.out.println("Kendaraan berhasil dihapus.");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Kendaraan tidak ditemukan.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Keluar dari aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }
}
