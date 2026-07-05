import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // IO Sederhana
        Scanner scan = new Scanner(System.in);
        
        // Array of Object untuk list lapangan
        Lapangan[] listLap = new Lapangan[2];
        listLap[0] = new Lapangan("LP-01 (Reguler)", 100000);
        listLap[1] = new LapanganSintetis("LP-02 (Premium)", 150000, 20000); // Polymorphism

        System.out.println("=== REKAP PENYEWAAN FUTSAL UNISKA ===");
        System.out.println("Opsi Lapangan:");
        
        // Perulangan untuk membaca array
        for (int i = 0; i < listLap.length; i++) {
            System.out.println((i + 1) + ". " + listLap[i].ambilDetail());
        }

        int NoPilihan = 0;
        int totalJam = 0;
        boolean inputSelesai = false;

        // Error Handling dengan Try-Catch
        while (!inputSelesai) {
            try {
                System.out.print("\nMasukkan nomor lapangan pilihan (1-2): ");
                NoPilihan = Integer.parseInt(scan.nextLine());
                
                // Seleksi / Percabangan
                if (NoPilihan < 1 || NoPilihan > 2) {
                    System.out.println("Nomor tidak valid! Ketik 1 atau 2 saja.");
                    continue;
                }

                System.out.print("Berapa jam sewa? ");
                totalJam = Integer.parseInt(scan.nextLine());
                
                // Seleksi nilai input
                if (totalJam <= 0) {
                    System.out.println("Durasi sewa tidak boleh kosong atau minus!");
                    continue;
                }

                inputSelesai = true; 
                
            } catch (NumberFormatException err) {
                System.out.println("Gagal: Harus memasukkan angka bulat, jangan huruf!");
            }
        }

        // Kalkulasi Total Biaya
        Lapangan lapTerpilih = listLap[NoPilihan - 1]; // Object terenkapsulasi
        double jumlahBayar = lapTerpilih.getTarifPerJam() * totalJam;

        // Seleksi khusus mengecek tipe objek (Polymorphism)
        if (lapTerpilih instanceof LapanganSintetis) {
            LapanganSintetis ls = (LapanganSintetis) lapTerpilih;
            jumlahBayar += (ls.getBonusPapanSkor() * totalJam);
        }

        // IO Sederhana: Cetak Struk akhir
        System.out.println("\n------------------------------------");
        System.out.println("       STRUK BOOKING LAPANGAN       ");
        System.out.println("------------------------------------");
        System.out.println("Tipe Lapangan : " + lapTerpilih.getKodeLap());
        System.out.println("Durasi Main   : " + totalJam + " Jam");
        System.out.println("Total Tagihan : Rp" + jumlahBayar);
        System.out.println("------------------------------------");
        
        scan.close();
    }
}