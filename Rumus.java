import java.util.Scanner;

public class Rumus {
//    TUGAS 3
//Buatlah aplikasi penghitung luas dan keliling bangun datar persegi,
// persegi panjang, segitiga, lingkaran dengan ketentuan menggunakan input, subclass, dan function.
    public static double luas, keliling;
    Scanner sc = new Scanner(System.in);
    public void output_hasil(double luas, double keliling)
    {
        System.out.println("* Luas = "+luas);
        System.out.println("* Keliling = "+keliling);
        System.out.println("---------------------");
    }

    // hitung rumus persegi
    public void hitung_persegi() {
        double panjang_sisi;

        System.out.println("\n\n---- 1. Persegi ----");
        System.out.print("- Panjang sisi = "); panjang_sisi = sc.nextDouble();

        luas = Math.pow(panjang_sisi, 2);
        keliling = 4 * panjang_sisi;

        output_hasil(luas, keliling);
    }

    // hitung rumus persegi panjang
    public void hitung_persegipjg() {
        double panjang, lebar;

        System.out.println("\n\n---- 2. Persegi Panjang ----");
        System.out.print("- Panjang = "); panjang = sc.nextDouble();
        System.out.print("- Lebar = "); lebar = sc.nextDouble();

        luas = panjang * lebar;
        keliling = (2 * panjang) + (2 * lebar);

        output_hasil(luas, keliling);
    }

    // segitiga siku
    public double hitung_tinggisegitiga(double sisi_miring, double sisi_alas)
    {
        double result = Math.sqrt(Math.pow(sisi_miring, 2) - Math.pow(sisi_alas, 2));
        return result;
    }
    public void hitung_segitigasiku() {
        double sisi_miring, sisi_alas, tinggi;

        System.out.println("\n\n---- 3. Segitiga Siku-siku ----");
        System.out.print("- Panjang Sisi Miring = "); sisi_miring = sc.nextDouble();
        System.out.print("- Panjang Sisi Alas = "); sisi_alas = sc.nextDouble();

        tinggi = hitung_tinggisegitiga(sisi_miring, sisi_alas);
        luas = 0.5 * sisi_alas * tinggi;
        keliling = sisi_miring + sisi_alas + tinggi;

        output_hasil(luas, keliling);
    }

    public void hitung_lingkaran() {
        double jari;
        System.out.println("\n\n---- 4. Segitiga Siku-siku ----");
        System.out.print("- Panjang Jari-jari = "); jari = sc.nextDouble();

        luas = Math.PI * jari * jari;
        keliling = 2 * Math.PI * jari;
        output_hasil(luas, keliling);
    }

}
