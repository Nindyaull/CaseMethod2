// Mempresentasikan sebuah node dalam DLL pesanan

public class NodePesanan22 {
    Pesanan22 data; // menyimpan data pesanan
    NodePesanan22 next; // null jika node adalah tail
    NodePesanan22 prev; // null jika node adalah head

    // Konstruktor NodePesanan
    // Saat node baru dibuat, prev dan next diinisialisasi nulll
    public NodePesanan22(Pesanan22 data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

/*
    * PENJELASAN NODE (berlaku untuk NodePembeli22 dan NodePesanan22):
    * Konsep Node: Node diibaratkan sebagai Gerbong Kereta. Setiap gerbong memiliki 
    * dua hal penting, yakni isi muatannya yaitu data dan alat pengaitnya yaitu pointer.
    * Double Linked List memiliki 2 pointer pengait pada setiap datanya, yakni:
    * 1. next : berfungsi sebagai tangan kanan yang menggandeng data di depannya.
    * 2. prev : berfungsi sebagai tangan kiri yang menggandeng data di belakangnya.
    * Pada saat node baru dicetak (instansiasi), kedua tangan ini masih bernilai null sampai 
    * nanti disambungkan di dalam class AntrianPembeli22 atau DaftarPesanan22.
*/