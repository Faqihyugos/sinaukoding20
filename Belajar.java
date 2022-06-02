public class Belajar {
	public static void main(String args[]) {

		for (int nilaiAwal = 1; nilaiAwal <= 20; nilaiAwal++) {
			int prima = 0; // variable untuk menampung jumlah hasil bagi
			for (int i = 1; i <= 20; i++) {
				if (nilaiAwal%i == 0) { // cek hasil bagi setiap perulangan lalu di simpan ke prima
					prima++;
				}
			}
			if (prima == 2 && nilaiAwal != 1) {
				System.out.println(nilaiAwal + " bilangan prima");
			} else {
				System.out.println(nilaiAwal + " bukan bilangan prima");
			}
		}

	}
}