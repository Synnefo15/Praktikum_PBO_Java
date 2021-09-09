import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("===Tugas PR PBO===");
        System.out.println("Muhammad Rafi Cahyaputra/192410101029");

        Scanner inputSoal = new Scanner(System.in);
        System.out.print("masukkan no soal 1-4 = ");
        int soal = inputSoal.nextInt();

        switch (soal) {
            case 1:
                System.out.println("anda memilih " + soal);
                no1();
                break;
            case 2:
                System.out.println("anda memilih " + soal);
                no2();
                break;
            case 3:
                System.out.println("anda memilih " + soal);
                no3();
                break;
            case 4:
                System.out.println("anda memilih " + soal);
                no4();
                break;
            default:
                System.out.println("soal tidak ada");
                break;
        }

    }

    // #Soal no.1
    private static void no1() {
        System.out.println("---No.1 Cek Prima");

        Scanner inputUser = new Scanner(System.in);

        System.out.print("masukkan angka = ");
        int angkaInput = inputUser.nextInt();

        int checker = 0;

        for (int i = 2; i <= angkaInput; i++) {
            if (angkaInput % i == 0) {
                checker++;
            }
        }

        if (checker == 1) {
            System.out.println(angkaInput + " adalah prima");
        } else {
            System.out.println(angkaInput + " adalah bukan prima");
        }
    }

    // #Soal no2
    private static void no2() {
        System.out.println("\n---No 2 Cek Ganjil Genap");

        long[] bilangan = { 1, 2, 3, 123124235, 43641235436236l, 2634645856295803463l, 138246093486289l,
                32894702358729356l, 192830912748236580l, 109273890156783296l, 1097492836520923l, 5, 1, 7, 4,
                2390975189365823765l, 2839572803652780356l, 9840912375726l, 983407629365028765l, 23870592863508726l,
                382675029836365l, 8974309857239857235l, 2389709280375235l, 28365723562365l, 325896209823l,
                238572069822535l, 2835729835726l, 23587209833985235l };
        System.out.println("Bilangan genap : ");
        for (int i = 0; i < bilangan.length; i++) {
            if (bilangan[i] % 2 == 0) {
                System.out.print(bilangan[i] + ", ");
            }
        }
        System.out.println("\n bilangan ganjil : ");
        for (int i = 0; i < bilangan.length; i++) {
            if (bilangan[i] % 2 != 0) {
                System.out.print(bilangan[i] + ", ");
            }
        }
    }

    // #Soal no3
    private static void no3() {
        System.out.println("\n---No 3 Binary search");

        int[] angka = { 1, 443, 91, 20, 34, 12, 92, 90, 44, 9, 76 };

        for (int i = 0; i < angka.length; i++) {
            System.out.println(angka[i] + " ");
        }
        System.out.println("Sorted :");
        BubbleSort(angka);
        for (int i = 0; i < angka.length; i++) {
            System.out.println(angka[i] + " index ke-" + i + ", ");
        }

        Scanner inputCari = new Scanner(System.in);
        System.out.print("masukkan angka yang anda cari : ");
        int cari = inputCari.nextInt();

        int hasil = binarySearch(angka, cari, 0, angka.length - 1);

        if (hasil >= 0) {
            System.out.println("angka pada index ke- " + hasil);
        } else {
            System.out.println("angka tidak ada");
        }
    }

    // *sorting dengan bubbleSort
    private static void BubbleSort(int[] angka) {
        for (int i = 0; i < angka.length; i++) {
            for (int j = 0; j < angka.length - 1; j++) {
                if (angka[j] > angka[j + 1]) {
                    int temp = angka[j];
                    angka[j] = angka[j + 1];
                    angka[j + 1] = temp;
                }
            }
        }
    }

    // *logic binarysearch
    private static int binarySearch(int[] angka, int cari, int i, int j) {
        int tengah;
        while (i <= j) {
            tengah = (i + j) / 2;
            if (cari == angka[tengah]) {
                return tengah;
            } else if (cari < angka[tengah]) {
                j = tengah - 1;
            } else {
                i = tengah + 1;
            }
        }
        return -1;
    }

    // #No 4
    private static void no4() {

        System.out.println("---No.4 Naga Ksatria");

        Scanner inputObjek = new Scanner(System.in);

        // *Inputan Ksatria
        System.out.print("masukkan jumlah ksatria : ");
        int jumlahKsatria = inputObjek.nextInt();
        int[] ksatriaArr = new int[jumlahKsatria];
        System.out.println("masukkan tinggi tiap ksatria anda :");

        // *cetak array ksatria
        for (int i = 0; i < jumlahKsatria; i++) {
            ksatriaArr[i] = inputObjek.nextInt();
        }
        System.out.println("array ksatria sorted: ");
        for (int i = 0; i < jumlahKsatria; i++) {
            Arrays.sort(ksatriaArr);
            System.out.println(ksatriaArr[i]);
        }

        // *Inputan Naga
        System.out.println("masukkan jumlah naga : ");
        int jumlahNaga = inputObjek.nextInt();
        int[] nagaArr = new int[jumlahNaga];
        System.out.println("Masukkan diameter tiap naga : ");

        // *cetak array naga
        for (int i = 0; i < jumlahNaga; i++) {
            nagaArr[i] = inputObjek.nextInt();
        }
        System.out.println("array naga sorted : ");
        for (int i = 0; i < jumlahNaga; i++) {
            Arrays.sort(nagaArr);
            System.out.println(nagaArr[i]);
        }

        int nilaiKsatria = 0;

        int indeksNaga = 0;

        for (int i = 0; i < ksatriaArr.length; i++) {
            int a = ksatriaArr[i];
            if (indeksNaga < nagaArr.length) {
                if (a >= nagaArr[indeksNaga]) {
                    nilaiKsatria += a;
                    indeksNaga++;
                }
            }
        }

        if (indeksNaga == nagaArr.length) {
            System.out.println("\n ksatria menang dengan nilai  " + nilaiKsatria);
        } else {
            System.out.println("Ksatria anda Kalah");
        }
    }

}
