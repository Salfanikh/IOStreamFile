package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {
        
        // 1. Cek keberadaan dan ukuran file
        File berkas = new File("laporan.txt");
        if (berkas.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkas.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        // 2. Buat folder baru bernama "arsip"
        File folder = new File("arsip");
        if (folder.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat (mungkin sudah ada).");
        }

        // 3. Buat, lalu hapus berkas "sementara.txt"
        File fileSementara = new File("sementara.txt");
        try {
            fileSementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + fileSementara.exists());
            
            fileSementara.delete();
            System.out.println("Sesudah dihapus, ada? " + fileSementara.exists());
        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}

