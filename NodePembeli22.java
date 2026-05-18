// Mmpresentasikan sebuah node dalam DLL antrian pembeli

public class NodePembeli22 {
    Pembeli22 data; // menyimpan data pembeli
    NodePembeli22 next; // null jika node adalah tail
    NodePembeli22 prev; // null jika node adalah head

    // Konstruktor NodePembeli
    // saat node baru dibuat, prev dan next diinisialisasi null
    public NodePembeli22(Pembeli22 data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
