package bagian2.bacatulis;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Latihan4 {
    public static void main(String[] args) {
        // Menggunakan try-with-resources untuk membaca file secara efisien
        try (BufferedReader pembaca = new BufferedReader(new FileReader("mahasiswa.txt"))) {
            String baris;
            int nomor = 1;
            
            // Membaca file baris demi baris hingga akhir (null)
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }
}