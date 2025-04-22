import java.util.ArrayList;
import java.util.Scanner;

class Hewan{
    protected String Nama;
    protected String Jenis;
    protected int Harga;
    public Hewan(String Nama,String Jenis,int Harga){
        this.Nama=Nama;
        this.Jenis=Jenis;
        this.Harga=Harga;
    }
    public void SetNama(String Nama){
        this.Nama=Nama;
    }
     public void SetJenis(String Jenis){
        this.Jenis=Jenis;
    }
      public void SetHarga(int Harga){
        this.Harga=Harga;
    }
      public String GetNama(){
          return Nama;
      }
        public String GetJenis(){
          return Jenis;
      }
          public int GetHarga(){
          return Harga;
      }
      public void Display(){
          System.out.println("Nama : "+GetNama());
          System.out.println("Jenis : "+GetJenis());
          System.out.println("Harga : "+GetHarga());
      }
      
}
class Karnivora extends Hewan{
    public Karnivora(String Nama, String Jenis, int Harga) {
        super(Nama, Jenis, Harga);
    }
    @Override
    public void Display(){
        System.out.println("Daftar Hewan Karnivora");
        super.Display();
    }
}
class Herbivora extends Hewan{ 
    
    public Herbivora(String Nama, String Jenis, int Harga) {
        super(Nama, Jenis, Harga);
    }
    @Override
    public void Display(){
        System.out.println("Daftar Hewan Herbivora");
        super.Display();
    }
}

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Karnivora>DaftarKarnivora=new ArrayList<>();
        ArrayList<Herbivora>DaftarHerbivora=new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilihan;
        while(true){
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("3.Edit");
            System.out.println("4.Tampil");
            System.out.print("Masukkan pilihan anda : ");
            pilihan=input.nextInt();
            input.nextLine();
            switch(pilihan){
                case 1 : Tambah(DaftarKarnivora,DaftarHerbivora,input);break;
                case 2 : Hapus(DaftarKarnivora,DaftarHerbivora,input);break;
                case 3 : Edit(DaftarKarnivora,DaftarHerbivora,input);break;
                case 4 : Tampil(DaftarKarnivora,DaftarHerbivora,input);break;
            }
        }
    }

    private static void Tambah(ArrayList<Karnivora> DaftarKarnivora, ArrayList<Herbivora> DaftarHerbivora, Scanner input) {
        System.out.println("Daftar Kategori");
        System.out.println("1.Karnivora");
        System.out.println("2.Herbivora");
        System.out.print("Masukkan Pilihan anda : ");
        int tipe=input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Nama : ");
        String Nama= input.nextLine();
        System.out.print("Masukkan Jenis : ");
        String Jenis = input.nextLine();
        System.out.print("Masukkan Harga : ");
        int Harga=input.nextInt();
        input.nextLine();
        if(tipe==1){
            DaftarKarnivora.add(new Karnivora(Nama,Jenis,Harga));
        }
        else if(tipe==2){
            DaftarHerbivora.add(new Herbivora(Nama,Jenis,Harga));
        }
        else{
            System.out.println("Inputan invalid");
        }
    }
    private static void Edit(ArrayList<Karnivora> DaftarKarnivora, ArrayList<Herbivora> DaftarHerbivora, Scanner input){
        System.out.println("Kategori");
        System.out.println("1.Karnivora");
        System.out.println("2.Herbivora");
        System.out.print("Masukkan kategori yang mau diedit : ");
        int kategori=input.nextInt();
        input.nextLine();
        if(kategori==1){
            if(DaftarKarnivora.isEmpty()){
                System.out.println("Kosong");
                return;
            }
            System.out.println("Masukkan Posisi Yang mau diedit");
            int posisi=input.nextInt();
            input.nextLine();
            if(posisi >=1 &&posisi<=DaftarKarnivora.size()){
                Edit(DaftarKarnivora.get(posisi - 1),input);
            }
            else{
                System.out.println("Posisi Invalid");
            }
            if (kategori==2) {
                if(DaftarHerbivora.isEmpty()){
                    System.out.println("Kosong");
                    return;
                }
                System.out.println("Masukkan Posisi Yang mau diedit");
                posisi=input.nextInt();
                input.nextLine();
                if(posisi >=1 && posisi<=DaftarHerbivora.size()){
                    Edit(DaftarHerbivora.get(posisi - 1),input);
                }
                else{
                    System.out.println("Posisi Invalid");
                }
            }}}
        
        private static void Edit(Karnivora k, Scanner input) {
            System.out.println("Masukkan Nama Baru : ");
            k.SetNama((input.nextLine()));
            System.out.println("Masukkan Jenis Baru : ");
            k.SetJenis(input.nextLine());
            System.out.println("Masukkan Harga Baru : ");
            k.SetHarga(input.nextInt());
            input.nextLine();
        }
    private static void Edit(Herbivora h, Scanner input) {
            System.out.println("Masukkan Nama Baru : ");
            h.SetNama((input.nextLine()));
            System.out.println("Masukkan Jenis Baru : ");
            h.SetJenis(input.nextLine());
            System.out.println("Masukkan Harga Baru : ");
            h.SetHarga(input.nextInt());
            input.nextLine();
    }
    

    private static void Hapus(ArrayList<Karnivora> DaftarKarnivora, ArrayList<Herbivora> DaftarHerbivora, Scanner input) {
        System.out.println("1.Karnivora");
        System.out.println("2.Herbivora");
        System.out.print("Masukkan di kategori yang mau dihapus : ");
        int kategori=input.nextInt();
        input.nextLine();
        ArrayList<? extends Hewan> Daftar = (kategori==1)?DaftarKarnivora:DaftarHerbivora;
        if(Daftar.isEmpty()){
            System.out.println("Kosong");
            return;
        }
        System.out.print("Masukkan Posisi yang mau dihapus : ");
        int posisi=input.nextInt();
        input.nextLine();
        if(posisi >= 1 && posisi <= Daftar.size()){
            Daftar.remove( posisi - 1);
        }
        else{
            System.out.println("posisi invalid");
        }
    }

    private static void Edit(ArrayList<Karnivora> DaftarKarnivora, ArrayList<Herbivora> DaftarHerbivora, Scanner input) {
        System.out.println("Kategori");
        System.out.println("1.Karnivora");
        System.out.println("2.Herbivora");
        System.out.print("Masukkan kategori yang mau diedit : ");
        int kategori=input.nextInt();
        input.nextLine();
        ArrayList<? extends Hewan> Daftar = (kategori==1)?DaftarKarnivora:DaftarHerbivora;
          if(Daftar.isEmpty()){
            System.out.println("Kosong");
            return;
        }
          int posisi;
          System.out.println("Masukkan Posisi Yang mau diedit");
          posisi=input.nextInt();
          input.nextLine();
          if(posisi >= 1 &&  posisi<= Daftar.size()){
              System.out.print("Masukkan Nama Baru : ");
              Daftar.get(posisi - 1).SetNama(input.nextLine());
                System.out.print("Masukkan Jenis Baru : ");
              Daftar.get(posisi - 1).SetJenis(input.nextLine());
                System.out.print("Masukkan Harga Baru : ");
              Daftar.get(posisi - 1).SetHarga(input.nextInt());
              input.nextLine();
          }
          else{
              System.out.println("Posisi Invalid");
          }
    }

    private static void Tampil(ArrayList<Karnivora> DaftarKarnivora, ArrayList<Herbivora> DaftarHerbivora, Scanner input) {
        System.out.println("1.Karnivora");
        System.out.println("2.herbivora");
        System.out.print("Masukkan kategori yang mau ditampilkan : ");
        int kategori=input.nextInt();
        input.nextLine();
         ArrayList<? extends Hewan> Daftar = (kategori==1)?DaftarKarnivora:DaftarHerbivora;
          if(Daftar.isEmpty()){
            System.out.println("Kosong");
            return;
        }
          int index=1;
          for( Hewan hewan : Daftar){
              System.out.println("Data ke - "+index);
              hewan.Display();
              index++;
        }
    }
}
