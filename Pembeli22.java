// Class ini untuk empresentasikan data seorang pembeli yang masuk ke antrian

public class Pembeli22 {
    int noAntrian;
    String namaPembeli;
    String noHp;
    String waktuDaftar; // untuk mencatat waktu daftar pembeli [MODIFIKASI]

    // konstruktor pembeli 
    // untuk menginisialisasi seluruh atribut pembeli saat objek dibuat
    public Pembeli22(int noAntrian, String namaPembeli, String noHp, String waktuDaftar) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.waktuDaftar = waktuDaftar; // iniasialisasi wkatuDaftar
    }

    // tampilkan data pembeli dalam format tabel
    public void tampil() {
        System.out.printf("%-13d %-20s %-15s %s%n", noAntrian, namaPembeli, noHp, waktuDaftar); // tambah format waktuDaftar
    }
}

