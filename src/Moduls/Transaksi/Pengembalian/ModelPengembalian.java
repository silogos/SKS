package Moduls.Transaksi.Pengembalian;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ModelPengembalian {
    private int ID, quantity, diff;
    private String nis, code_book, tanggal_pinjam, tanggal_kembali;
    
    public ModelPengembalian(int ID, String nis, String code_book, String tanggal_pinjam, String tanggal_kembali, int quantity, int diff) {
        this.ID = ID;
        this.quantity = quantity;
        this.diff = diff;
        this.code_book = code_book;
        this.nis = nis;
        this.tanggal_pinjam = tanggal_pinjam;
        this.tanggal_kembali = tanggal_kembali; 
    }

    public int getID () {
        return ID;
    }

    public int getQuantity () {
        return quantity;
    }

    public int getDiff () {
        if(diff < 1) {
            return 0;
        }
        return diff;
    }

    public String getNis () {
        return nis;
    }
    
    public String getCodeBook () {
        return code_book;
    }

    public String getTanggalPinjam () {
        return tanggal_pinjam;
    }

    public String getTanggalKembali () {
        return tanggal_kembali;
    }

    
}
