public class Belajar {
	public static void main(String args[]) {
		// Buatlah aplikasi untuk menampilkan angka 1-50,
		//ketika angka n habis dibagi 3 maka keluar tulisan "n habis dibagi 3",
		//dan jika n habis dibagi 5 maka keluar tulisan "n habis dibagi 5"
		for (int nilaiAwal = 1; nilaiAwal <= 50; nilaiAwal++) {
			if (nilaiAwal % 3 == 0) {
				System.out.println(nilaiAwal + " habis dibagi 3");
			}
			if (nilaiAwal % 5 == 0) {
				System.out.println(nilaiAwal + " habis dibagi 5");
			}
			System.out.println(nilaiAwal);
		}
	}
}