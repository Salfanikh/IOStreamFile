package bagian3.kontak;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BukuKontak {
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println((i + 1) + ". " + daftar.get(i).info());
        }
    }

    // Latihan No. 1: Mencari kontak
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return;
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }

    // Latihan No. 3: Menghapus kontak
    public void hapusKontak(String nama) {
        Iterator<Kontak> iterator = daftar.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getNama().equalsIgnoreCase(nama)) {
                iterator.remove();
                System.out.println("Kontak " + nama + " berhasil dihapus.");
                simpanKeBerkas(); // Update file setelah hapus
                return;
            }
        }
        System.out.println("Kontak " + nama + " tidak ditemukan untuk dihapus.");
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) { // Sesuaikan untuk 3 bagian
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }
}