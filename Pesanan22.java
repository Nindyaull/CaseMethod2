// Mempresentasikan data pesanan makanan yang dipesan oleh pembeli

public class Pesanan22 {
    int kodePesanan;
    String namaPesanan;
    int harga;

    // konstruktor pesanan
    // menginisialisasi seluruh atribut pesanan saat objek dibuat
    public Pesanan22(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
    }

    // menampilkan data pesanan dalam format tabel satu baris
    public void tampil() {
        System.out.printf("%-15d %-25s %d%n", kodePesanan, namaPesanan, harga);
    }
}

/*
    *PENJELASAN CLASS (Pesanan22 dan Pembeli22): 
    * 1. Fungsi: Class ini bertindak sebagai blueprint atau tipe 
    * data bentukan untuk merepresentasikan sebuah entitas di dunia nyata (orang 
    * yang mengantri dan makanan yang dipesan).
    * 2. Atribut: Variabel seperti noAntrian, namaPembeli, harga, dll adalah sifat 
    * atau identitas yang dimiliki oleh objek tersebut.
    * 3. Konstruktor: Method dengan nama yang sama dengan class ini berfungsi 
    * sebagai pusat pembuatan objek. Saat user menulis keyword 'new', 
    * konstruktor akan langsung mengisi atribut" tadi dengan data awal.
    * 4. Method tampil(): Berfungsi untuk mencetak data atribut ke layar dengan 
    * format printf agar rapi, sehingga class main tidak perlu 
    * repot-repot memformat teks lagi.
 */