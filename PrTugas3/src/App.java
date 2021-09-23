import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("M.Rafi Cahyaputra/192410101029");
        System.out.println("=====Start=====");

        // * membuat objek peternak
        Peternak peternak1 = new Peternak("rafi", 19, "pria", 10);
        Peternak peternak2 = new Peternak("gilang", 21, "pria", 5);

        // * membuat objek hewan
        Hewan hewan1 = new Hewan("onta", "mamalia", 12, 40, 230000);
        Hewan hewan2 = new Hewan("kuda", "mamalia", 4, 70, 1000000);

        // * memasangkan peternak dan hewan
        peternak1.setHewan(hewan1);
        peternak2.setHewan(hewan2);
        

        // * menampilkan data
        peternak1.display();
        hewan1.display();
        peternak2.display();
        hewan2.display();

        // *aktivitas
        peternak1.menjualHewan(hewan1);
        peternak2.menjualHewan(hewan2);

    }
}

class Peternak {
    private String name;
    private int usia;
    private String kelamin;
    private int lamaTernak;

    // *Objek member
    private Hewan hewan;

    public Peternak(String name, int usia, String kelamin, int lamaTernak) {
        this.name = name;
        this.usia = usia;
        this.kelamin = kelamin;
        this.lamaTernak = lamaTernak;
    }

    // *data peternak
    public String getName() {
        return this.name;
    }

    public int getUsia() {
        return this.usia;
    }

    public String getKelamin() {
        return this.kelamin;
    }

    public int getLamaTernak() {
        return this.lamaTernak;
    }
    // &===end data peternak

    // *Display
    public void display() {
        System.out.println("===Peternak===");
        System.out.println("Peternak\t : " + this.name);
        System.out.println("Usia\t\t : " + this.usia);
        System.out.println("Jenis Kelamin\t : " + this.kelamin);
        System.out.println("Lama ternak\t : " + this.lamaTernak);
        System.out.println("Beternak\t : " + this.hewan.getName());
    }
    // &===end display

    // *setHewan
    public void setHewan(Hewan hewan) {
        this.hewan = hewan;
    }

    // &memilih hewan dijual
    // *Hewan dapat dijual ketika sudah mau makan
    public void menjualHewan(Hewan hewan) {
        System.out.println("\n Halo peternak " + this.name + " ,ingin menjual "+ hewan.getName() + " dgn berat\t : " + hewan.getBerat() + " ?");
        hewan.makan();

        if (this.hewan.getTerjual() == false) {
            System.out.println("Harus makan lagi");
        } else {
            System.out.println("Hewan : " + hewan.getName() + ", Status layak dijual : " + hewan.getTerjual());
            Scanner inputUser = new Scanner(System.in);
            System.out.println("Apa anda ingin menjual hewan itu ? true/false ");
            boolean inginJual = inputUser.nextBoolean();

            if (inginJual == true && hewan.getTerjual() == true) {
                System.out.println("Hewan " + hewan.getName() + " telah dijual");
                System.out.println("Penghasilan : " + keuntungan() + "\nlaba " + (keuntungan()-hewan.getHarga()));
            } else if (inginJual == false && hewan.getTerjual() == true) {
                System.out.println("wah anda tidak ingin uang");
            } else {
                System.out.println("tidak memenuhi syarat");
            }

        }

    }

    //  &hitung keuntungan.
    // * keuntunaan didapat berdasarkan lama pengalaman peternak. Setiap 5 thn, harga jual ditambah 10.000 .jika peternak sdh 10 thn beternak, maka 10/5 = 2. jadi menambah 20.000 harga jual
    // *setiap berat hewan naik 5 kg, maka harga jual naik 10.000
    public int keuntungan(){
        return hewan.getHarga() + ((int)this.lamaTernak/5*10000) + ((int)hewan.getBerat()/5*10000) ;
    }

}

class Hewan {
    private String name;
    private String jenis;
    private double panjang;
    private double berat;
    private int harga;
    private boolean terjual;

    public Hewan(String name, String jenis, double panjang, double berat, int harga) {
        this.name = name;
        this.jenis = jenis;
        this.panjang = panjang;
        this.berat = berat;
        this.harga = harga;
        this.terjual = false;
    }

    // *data hewan
    public String getName() {
        return this.name;
    }

    public String getJenis() {
        return this.jenis;
    }

    public double getPanjang() {
        return this.panjang;
    }

    public double getBerat() {
        return this.berat;
    }

    public int getHarga() {
        return this.harga;
    }

    public boolean getTerjual() {
        return this.terjual;
    }
    // &===end data hewan

    // *Display
    public void display() {
        System.out.println("===Hewan===");
        System.out.println("Hewan\t\t : " + this.name);
        System.out.println("Jenis\t\t : " + this.jenis);
        System.out.println("Berat\t\t : " + this.berat);
        System.out.println("Harga\t\t : " + this.harga);
        System.out.println("Status terjual\t : " + this.terjual);
    }

    // &Makan
    //*  Ketika sesudah makan, maka akan dicek apa berat bedannya sdh mencukupi atau blm
    //*  dihitung cukup saat berat setelah makan naik 20% dari berat awal
    public void makan() {
        Scanner inputUser = new Scanner(System.in);
        System.out.print("Apa hewan sudah makan ? (true/false) ");
        boolean apaMakan = inputUser.nextBoolean();

        if (apaMakan == true) {
            System.out.print("Berapa kg makannya ? ");
            int nominalMakan = inputUser.nextInt();
            Double beratAwal = berat;
            berat += nominalMakan;
            System.out.println("berat awal : " + beratAwal + ",berat akhir : " + berat);
            if (berat >= beratAwal * 6 / 5) {
                terjual = true;
                System.out.println("berat > " + beratAwal * 6 / 5 + " = lolos jual");
            } else {
                System.out.println("berat < " + beratAwal * 6 / 5 + " = tidak lolos jual");
            }
        } else {
            this.terjual = false;
            System.out.println("kalo hewan tidak makan, maka tidak bisa dijual");
        }

    }

}
