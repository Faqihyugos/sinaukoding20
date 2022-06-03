import java.util.Scanner;

public class Belajar {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		int input_menu;
        boolean lanjut = true;
        while(lanjut) {
            System.out.println("===== Menghitung Luas dan Keliling ====");
            System.out.println("1. Persegi");
            System.out.println("2. Persegi Panjang");
            System.out.println("3. Segitiga Siku-siku");
            System.out.println("4. lingkaran");
            System.out.print("- Masukkan angka = "); input_menu = input.nextInt();

            switch (input_menu) {
                case 1 :
                    double panjang_sisi;
                    System.out.println("\n\n---- 1. Persegi ----");
                    System.out.print("- Panjang sisi = "); panjang_sisi = input.nextDouble();
                    Persegi persegi = new Persegi(panjang_sisi);
                    System.out.println("* Luas = "+ persegi.luas());
                    System.out.println("* Keliling = "+persegi.keliling());
                    System.out.println("---------------------");
                    break;
                case 2:
                    double panjang, lebar;
                    System.out.println("\n\n---- 2. Persegi Panjang ----");
                    System.out.print("- Panjang = "); panjang = input.nextDouble();
                    System.out.print("- Lebar = "); lebar = input.nextDouble();
                    PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
                    System.out.println("* Luas = "+ persegiPanjang.luas());
                    System.out.println("* Keliling = "+persegiPanjang.keliling());
                    System.out.println("---------------------");
                    break;
                case 3:
                    double sisi_miring, sisi_alas;
                    System.out.println("\n\n---- 3. Segitiga Siku-siku ----");
                    System.out.print("- Panjang Sisi Miring = "); sisi_miring = input.nextDouble();
                    System.out.print("- Panjang Sisi Alas = "); sisi_alas = input.nextDouble();
                    Segitiga segitiga = new Segitiga(sisi_miring, sisi_alas);
                    System.out.println("* Luas = "+ segitiga.luas());
                    System.out.println("* Keliling = "+segitiga.keliling());
                    System.out.println("---------------------");
                    break;
                case 4:
                    double jari;
                    System.out.println("\n\n---- 4. Segitiga Siku-siku ----");
                    System.out.print("- Panjang Jari-jari = "); jari = input.nextDouble();
                    Lingkaran lingkaran = new Lingkaran(jari);
                    System.out.println("* Luas = "+ lingkaran.luas());
                    System.out.println("* Keliling = "+lingkaran.keliling());
                    System.out.println("---------------------");
                    break;
                default:
                    System.out.println("Menu tidak ada");
                    break;
            }
            System.out.println("Apakah anda ingin menghitung lagi? (y/n)");
            String lanjut2 = input.next();
            lanjut = lanjut2.equals("y");
        }


	}
}

class Persegi implements RumusBangun {
    double panjang_sisi;
    public Persegi(double panjang_sisi) {
        this.panjang_sisi = panjang_sisi;
    }
    @Override
    public double luas() {
        return panjang_sisi * panjang_sisi;
    }

    @Override
    public double keliling() {
        return 4 * panjang_sisi;
    }
}
class PersegiPanjang implements RumusBangun {
    double panjang, lebar;
    PersegiPanjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    @Override
    public double luas() {
        return panjang * lebar;
    }

    @Override
    public double keliling() {
        return (2 * panjang) + (2 * lebar);
    }
}
class Segitiga implements RumusBangun{

    double sisi_miring, sisi_alas;

    Segitiga(double sisi_miring, double sisi_alas) {
        this.sisi_alas = sisi_alas;
        this.sisi_miring = sisi_miring;
    }
    public double hitung_tinggisegitiga(double sisi_miring, double sisi_alas)
    {
        return Math.sqrt(Math.pow(sisi_miring, 2) - Math.pow(sisi_alas, 2));
    }

    double tinggi = hitung_tinggisegitiga(sisi_miring, sisi_alas);
    @Override
    public double luas() {
        return 0.5 * sisi_alas * tinggi;
    }

    @Override
    public double keliling() {
        return sisi_miring + sisi_alas + tinggi;
    }
}
class Lingkaran implements RumusBangun {
    double jari;

    Lingkaran(double jari) {
        this.jari = jari;
    }

    @Override
    public double luas() {
        return Math.PI * jari * jari;
    }

    @Override
    public double keliling() {
        return 2 * Math.PI * jari;
    }
}
