package bagian2.bacatulis;

import java.io.*;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        String fileNama = "hari.txt";

        // 1. Tulis 5 nama hari ke dalam berkas hari.txt
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        try (PrintWriter penulis = new PrintWriter(new FileWriter(fileNama))) {
            for (String h : hari) {
                penulis.println(h);
            }
            System.out.println("--- 5 Nama hari berhasil ditulis ---");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        // 2. Tambahkan (append) 2 nama hari lagi lalu tampilkan seluruh isinya
        try (PrintWriter penulis = new PrintWriter(new FileWriter(fileNama, true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("--- 2 Nama hari berhasil ditambahkan ---");
        } catch (IOException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }

        System.out.println("Isi file saat ini:");
        try (BufferedReader pembaca = new BufferedReader(new FileReader(fileNama))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }

        // 3. Baca berkas hari.txt lalu hitung dan tampilkan jumlah barisnya
        int jumlah = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader(fileNama))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
            System.out.println("--------------------------");
            System.out.println("Total jumlah baris: " + jumlah);
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }
}