/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Transaksi.Peminjaman;

public class ModelViewPeminjaman {
    private String nis, nama, kelas, judul_buku, tanggal_pinjam;
    private int quantity, late;
    
    public ModelViewPeminjaman(String tanggal_pinjam, String nis, String nama, String kelas, String judul_buku, int quantity, int late) {
        this.tanggal_pinjam = tanggal_pinjam; 
        this.nis = nis; 
        this.nama = nama; 
        this.kelas = kelas; 
        this.judul_buku = judul_buku; 
        this.quantity = quantity;  
        this.late = late;  
    }

    public String getTanggalPinjam () {
        return tanggal_pinjam;
    }
    
    public String getNis () {
        return nis;
    }
    
    public String getNama () {
        return nama;
    }
    
    public String getKelas () {
        return kelas;
    }
    
    public String getJudulBuku () {
        return judul_buku;
    }

    public int getQuantity () {
        return quantity;
    }
    
    public int getLate () {
        return late;
    }
    
}
