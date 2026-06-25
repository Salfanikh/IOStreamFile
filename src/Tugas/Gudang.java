package tugas;

import java.io.*;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahBarang(Barang b) {
        daftarBarang.add(b);
    }

    public void tampilkanSemua() {
        for (Barang b : daftarBarang) {
            System.out.println(b.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                pw.println(b.keBaris());
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftarBarang.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] p = baris.split(";");
                daftarBarang.add(new Barang(p[0], Double.parseDouble(p[1]), Integer.parseInt(p[2])));
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += (b.getHarga() * b.getStok());
        }
        return total;
    }
}