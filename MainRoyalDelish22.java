import java.util.Scanner;

public class MainRoyalDelish22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // instansiasi objek data antrean dan daftar pesanan
        AntrianPembeli22 antrian = new AntrianPembeli22();
        DaftarPesanan22 pesanan = new DaftarPesanan22();

        // penambahan data menggunakan konstruktor
        antrian.addLast(new Pembeli22(antrian.generateNo(), "Ainra", "08224500000", "08:00"));
        antrian.addLast(new Pembeli22(antrian.generateNo(), "Danra", "08:05", "08:05"));
        antrian.addLast(new Pembeli22(antrian.generateNo(), "Sanri", "08224522222", "08:10"));
        antrian.addLast(new Pembeli22(antrian.generateNo(), "Nindya", "08224533333", "08:15"));

        int pilihan;

        do {
            System.out.println("\n==================================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==================================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Cari Pembeli Berdasarkan Waktu Daftar");
            System.out.println("0. keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine(); // membersihkan enter (newline) dari memori scanner setelah input angka

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli             : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP                    : ");
                    String noHp = sc.nextLine();
                    System.out.print("Waktu Daftar (ex: 12:50) : ");
                    String waktu = sc.nextLine();
                    int noAntrian = antrian.generateNo(); // untuk meminta no antrian secara otomatis 
                    Pembeli22 pembeliBaru = new Pembeli22(noAntrian, nama, noHp, waktu); // untuk memasukkan inputan data ke objek Pembeli

                    // memasukkan objek Pembeli ke dalam Double Linked List Antrian
                    antrian.addLast(pembeliBaru);
                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " +noAntrian);
                    break;

                case 2:
                    antrian.printAntrian(); // untuk memanggil method print dari class AntrianPembeli22
                    break;

                case 3:
                    if (antrian.isEmpty()) { // jk antrian kosong maka output akan mengeluarkan print antrian kosong
                        System.out.println("Antrian kosong! Belum ada pembeli yang bisa dipanggil.");
                    } else {
                        // panggil method removeFirst(), agar otomatis mengambil antrian pertama (head)
                        NodePembeli22 hapus = antrian.removeFirst();

                        // untuk mengecek apakah node berhasil ditemukan dan dihapus
                        if (hapus != null) {
                            System.out.print("Kode Pesanan : ");
                            int kode = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nama Pesanan : ");
                            String namaPesanan = sc.nextLine();
                            System.out.print("Harga        : ");
                            int harga = sc.nextInt();
                            sc.nextLine();

                            // untuk memasukkan inputan data pesanan ke dalam objek Pesanan
                            Pesanan22 pesananBaru = new Pesanan22(kode, namaPesanan, harga);
                            // masukkan objek Pesanan ke dalam DLL pesanan
                            pesanan.addLast(pesananBaru);
                            System.out.println(hapus.data.namaPembeli + " telah memesan " + namaPesanan);
                        }
                    }
                    break;

                case 4:
                    pesanan.cetaklaporan(); // memanggil method cetaklapran() dan sudah otomatis memanggil sortByNama()
                    break;

                case 5:
                    System.out.print("Masukkan waktu daftar yang dicari (ex: 08:00): ");
                    String cariWaktu = sc.nextLine();
                    antrian.searchByWaktu(cariWaktu); // Memanggil method pencarian
                    break;

                case 0:
                    System.out.println("Terima Kasih, Sistem Ditutup."); // jk memilih menu 0, maka sistem akan otomatis berhenti
                    break;

                default:
                    System.out.println("Menu tidak valid! Silakan pilih menu yang tersedia.");
            }
        } while (pilihan != 0); // looping akan berhenti ketika memilih 0
        sc.close(); // menutup scanner ketika sudah tdk digunakan lagi
    }
}

/*
     * PENJELASAN ALUR MAIN PROGRAM:
     * 1. Program ini dikendalikan oleh perulangan 'do-while', yang artinya program akan terus 
     * menampilkan menu dan meminta input pengguna selama pilihan tidak sama dengan 0.
     * 2. Untuk efisiensi testing, digunakan teknik Hardcode (memasukkan data Ainra, Danra, Sanri 
     * langsung di kode) sehingga tidak perlu mengetik ulang saat program baru dijalankan.
     * 3. Pada Menu 3 (Hapus dan Pesan), alur otomatis memanggil 'removeFirst()' dari class Antrean 
     * untuk mengambil pembeli paling depan. Data pembeli yang terhapus (hapus.data) kemudian 
     * ditampilkan namanya saat memproses pesanan, mengukuhkan konsep relasi antara antrean 
     * dan daftar pesanan.
*/
