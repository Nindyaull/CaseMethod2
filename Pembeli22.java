// Class ini untuk empresentasikan data seorang pembeli yang masuk ke antrian

public class Pembeli22 {
    int noAntrian;
    String namaPembeli;
    String noHp;

    // konstruktor pembeli 
    // untuk menginisialisasi seluruh atribut pembeli saat objek dibuat
    public Pembeli22(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    // tampilkan data pembeli dalam format tabel
    public void tampil() {
        System.out.printf("%-13d %-20s %s%n", noAntrian, namaPembeli, noHp);
    }
}

