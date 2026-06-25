/*
Nama: [Nama Anda]
NPM: [NPM Anda]
*/
package tugas;

public class MainTugas {
    public static void main(String[] args) {
        // 1. Array Kategori
        String[] kategori = {"Elektronik", "Alat Tulis", "Perabotan"};
        System.out.println("Kategori Toko:");
        for (String k : kategori) System.out.println("- " + k);

        // 2. Operasi Gudang
        Gudang gudang = new Gudang("barang.txt");
        gudang.tambahBarang(new Barang("Laptop", 7000000, 5));
        gudang.tambahBarang(new Barang("Buku", 5000, 100));
        gudang.tambahBarang(new Barang("Meja", 500000, 10));
        gudang.tambahBarang(new Barang("Mouse", 150000, 20));
        gudang.tambahBarang(new Barang("Lampu", 45000, 15));

        gudang.simpanKeBerkas();

        // 3. Uji Muat Data
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        System.out.println("\nData dari Berkas:");
        gudangBaru.tampilkanSemua();
        System.out.println("Total Nilai Persediaan: Rp" + gudangBaru.totalNilai());
    }
}