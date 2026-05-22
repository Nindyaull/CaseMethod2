// Implementasi DLL untuk mengelola antrian pembeli

public class AntrianPembeli22 {
    NodePembeli22 head; // pointer terdepan
    NodePembeli22 tail; // pointer terbelakang
    int size; // jumlah node yang ada dalam antrian
    int autoAntrian; // no antrian secara otomatis (terus bertambah)

    // untuk inisialisasi DLL dalam keadaan kosong
    public AntrianPembeli22() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.autoAntrian = 0;
    }

    // untuk mengecek apakah antrian kosong
    public boolean isEmpty() {
        return head == null;
    }

    // untuk membuat no antrian baru secara otomatis
    public int generateNo() {
        autoAntrian++;
        return autoAntrian;
    }

    // untuk menambahkan pembeli baru di tail
    public void addLast(Pembeli22 data) {
        NodePembeli22 newNode = new NodePembeli22(data);
        if (isEmpty()) {
            head = tail = newNode; // jk data kosong, node pertama akan menjadi head & tail
        } else {
            tail.next = newNode; // utk menyambungkan tail lama ke node baru (maju)
            newNode.prev = tail; // utk menyambungkan tail lama ke node baru (mundur)
            tail = newNode; // utk memperbarui tail
        }
        size++; // update jmlh node
    }

    // untuk mencari node pembeli berdasarkan no antrian
    public NodePembeli22 search(int noAntrian) {
        NodePembeli22 current = head; // traversal dari head
        while (current != null) { // utk cek apakah node memiliki antrian yg dicari
            if (current.data.noAntrian == noAntrian) {
                return current;
            }
            current = current.next; // utk lenjut ke node berikutnya
        }
        return null; // jk tdk ditemukan node yg dicari
    }

    // untuk hapus antrean dari urutan paling depan (FIFO)
    public NodePembeli22 removeFirst() {
        if (isEmpty()) {
            return null;
        }
        NodePembeli22 target = head; // utk menyimpan node urutan pertama
        if (head == tail) { // jk antrean hanya 1 node
            head = null;
            tail = null;
        } else { // jk antrean lebih dari 1 node
            head = head.next; // head menuju ke node selanjutnya 
            head.prev = null; // putuskan koneksi dari node lama
        }
        target.next = null; // utk memutus pointer target agar benar" terhapus
        size--;
        return target; // utk mengembalikan data org yg dihapus ke main
    }

    // untuk mencari pembeli berdasarkan waktu daftar (linear search) [MODIFIKASI]
    public void searchByWaktu(String waktu) {
        NodePembeli22 current = head; // Mulai pencarian dari head
        boolean ditemukan = false;

        System.out.println("Hasil pencarian untuk waktu: " + waktu);
        while (current != null) { // Traversal sepanjang list
            // untuk membandingkan waktu daftar dengan inputan user
            if (current.data.waktuDaftar.equalsIgnoreCase(waktu)) {
                current.data.tampil();
                ditemukan = true;
            }
            current = current.next; // maju ke node berikutnya
        }
        if (!ditemukan) { // jika tidak ada yg cocok
            System.out.println("Data tidak ditemukan.");
        }
    }

    // untuk menampilkan seluruh data antrian dari head ke tail
    public void printAntrian() {
        System.out.println("================================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("================================================");

        if (isEmpty()) {
            System.out.println("Antrian Kosong.");
            return; // utk keluar dri method print ketika bernilai true
        }
        System.out.printf("%-13s %-20s %-15s %s%n", "No Antrian", "Nama", "No Hp", "Waktu Daftar"); // tambahkan format waktu daftar
        NodePembeli22 current = head; // traversal dari head
        while (current != null) {
            current.data.tampil(); // memberikan tampilan data ke method tampil() milik pembeli
            current = current.next; // maju ke node berikut
        }
    }
}

/*
    *PENJELASAN CLASS AntrianPembeli22:
    * Class ini bertugas sebagai kepala stasiun yang mengatur lalu lintas gerbong (Node).
    * * 1. Atribut Utama: 
    * - head: Untuk penunjuk ke gerbong urutan pertama (paling depan).
    * - tail: Untuk penunjuk ke gerbong urutan terakhir (paling belakang).
    * - size: Untuk menghitung jumlah orang di dalam antrean.
    * - autoAntrian: Variabel counter untuk membuat nomor antrean urut (1, 2, 3..).
    * * 2. Method addLast(data): 
    * - Jika kosong: Orang baru ini otomatis jadi 'head' sekaligus 'tail'.
    * - Jika ada isi: Pengait 'next' dari tail lama dihubungkan ke node baru, 
    * dan prev node baru dihubungkan ke tail lama. Lalu tail pindah ke node baru.
    * * 3. Method removeFirst(): 
    * Menggunakan aturan FIFO (First In First Out)
    * - target menyimpan orang pertama saat ini.
    * - head digeser ke orang kedua (head.next).
    * - Koneksi node kedua ke node pertama diputus (head.prev = null).
    * - Koneksi node pertama ke node kedua juga diputus (target.next = null) agar benar" hilang.
    * * 4. Method search(noAntrian) & printAntrian():
    * Keduanya menggunakan teknik traversal. Kita membuat 
    * pointer bantuan bernama current yang ditaruh di head. Lalu, current 
    * akan terus melangkah ke belakang (current = current.next) sampai menemukan 
    * data yang dicari atau sampai akhir antrian (null) untuk dicetak.
 */
