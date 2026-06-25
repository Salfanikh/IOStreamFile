package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        BukuKontak buku = new BukuKontak("kontak.txt");

        // Pastikan setiap 'new Kontak' punya 3 argumen
        buku.tambahKontak(new Kontak("Andi", "08111", "andi@mail.com"));
        buku.tambahKontak(new Kontak("Budi", "08222", "budi@mail.com"));

        buku.cariKontak("Budi");
        buku.hapusKontak("Andi");
        buku.tampilkanSemua();
    }
}