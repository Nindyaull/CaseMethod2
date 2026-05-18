// Implementasi DLL untuk mengelola seluruh pesanan makanan

public class DaftarPesanan22 {
    NodePesanan22 head;
    NodePesanan22 tail;
    int size;

    // untuk menginisialisasi DLL dalam keadaan kosong
    public DaftarPesanan22() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // untuk mengecek apakah daftar pesanan kosong
    public boolean isEmpty() {
        return head == null;
    }

    // untuk menambahkan pesanan baru di akhir daftar pesanan
    public void addLast(Pesanan22 data) {
        NodePesanan22 newNode = new NodePesanan22(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // untuk mengurutkan daftar pesanan secara ASC berdasarkan nama pesanan
    // menggunakan algoritma Bubble Sort 
    public void sortByNama() {
        if (isEmpty() || head == tail) return; // tdk perlu sort jk list kosong / 1 node
        boolean swap;

        for (int i = 0; i < size-1; i++) {
            swap = false; // jk sdh terurut semua, maka berhenti
            NodePesanan22 current = head; // traversal dari head untuk membandingkan pasangan node yg berdampingan

            // Membandingkan nama pesanan current dgn node berikutnya
            while (current.next != null) {
                // compareTo menghasilkan positif ( > 0 ) jika abjad pertama dri kedua teks blm urut
                // compareTo menghasilkan negatif ( < 0 ) jika abjad pertama dri kedua teks sdh urut
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    // untuk melakukan swap data (objek pesanan) di dalam node
                    Pesanan22 temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swap = true; // menandakan bahwa terjadi pertukaran, lalu mengulangi pengecekan dri depan
                }
                current = current.next; // utk maju ke pasangan berikutnya
            }
            if (!swap) break; // jk tdk ada swap sama sekali, list sdh terurut
        }
    }

    // untuk menghitung total pendapatan dari seluruh pesanan yg masuk
    public int totalPendapatan() {
        int total = 0;
        NodePesanan22 current = head;

        while (current != null) {
            total += current.data.harga; // utk menjumlahkan semua harga
            current = current.next;
        }
        return total;
    }

    // untuk menampilkan laporan seluruh pesana yang sudah masuk
    public void cetaklaporan() {
        System.out.println("================================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("================================================");
        
        if (isEmpty()) {
            System.out.println("Belum ada pesanan yang masuk.");
            return;
        }
        sortByNama(); // diurutkan terlebih dahulu
        System.out.printf("%-15s %-25s %s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
        
        NodePesanan22 current = head; // traversal dri head ke tail dan cetak tiap pesanan
        while (current != null) {
            current.data.tampil(); // memberikan tampilan data ke method tampil() milik pesanan
            current = current.next;
        }
        
        System.out.println("------------------------------------------------");
        System.out.printf("%-41s %d%n", "TOTAL PENDAPATAN (Rp): ", totalPendapatan());
    }
}

/*
    * PENJELASAN CLASS DaftarPesanan22:
    * Class ini berfungsi sebagai history restoran.
    * * 1. Method addLast(data): 
    * Sama seperti antrian, pesanan baru selalu dicatat di baris paling bawah/akhir.
    * * 2. Method sortByNama() (BUBBLE SORT):
    * Berfungsi untuk mengurutkan laporan pesanan berdasarkan abjad (A-Z).
    * - Menggunakan nsested loop. Outer loop membatasi jumlah putaran, 
    * inner loop (while) membandingkan 2 data yang bersebelahan.
    * - compareToIgnoreCase: Jika data kiri abjadnya lebih besar dari data kanan 
    * (urutannya salah), nilainya > 0.
    * - Jika urutan salah, data di dalam node ditukar menggunakan 
    * variabel bantuan temp. Hanya datanya yang ditukar, 
    * pointer prev/next tidak diotak-atik agar list tidak rusak.
    * - Variabel boolean swap: Jika dalam satu putaran penuh tidak ada pertukaran 
    * data (swap == false), artinya daftar sudah urut sempurna dan proses 
    * langsung dihentikan menggunakan break untuk menghemat waktu.
    * * 3. Method totalPendapatan():
    * Berjalan dari depan ke belakang (traversal), sambil terus menjumlahkan
    * variabel harga dari setiap pesanan ke dalam variabel total.
    * * 4. Method cetaklaporan():
    * Method memanggil sortByNama() terlebih dahulu sebelum 
    * melakukan proses print secara traversal. Sehingga output yang keluar akan 
    * selalu rapi sesuai alfabet, dan diakhiri dengan pemanggilan total pendapatan.
 */
