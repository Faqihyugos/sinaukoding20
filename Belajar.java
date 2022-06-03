import java.util.Scanner;

public class Belajar {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		int input_menu;

		System.out.println("===== Menghitung Luas dan Keliling ====");
		System.out.println("1. Persegi");
		System.out.println("2. Persegi Panjang");
		System.out.println("3. Segitiga Siku-siku");
		System.out.println("4. lingkaran");

		System.out.print("- Masukkan angka = "); input_menu = input.nextInt();
		Rumus rumus = new Rumus();

		switch (input_menu) {
			case 1 :
				rumus.hitung_persegi();
				break;
			case 2:
				rumus.hitung_persegipjg();
				break;
			case 3:
				rumus.hitung_segitigasiku();
				break;
			case 4:
				rumus.hitung_lingkaran();
				break;
			default:
				System.out.println("Menu tidak ada");
				break;
		}

	}
}