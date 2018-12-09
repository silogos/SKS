/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Transaksi.Peminjaman;

public class ModelPeminjaman {
    private int ID, quantity;
    private String code_book, title, author, publisher, category, tanggal_pinjam, tanggal_kembali;
    
    public ModelPeminjaman(int ID, String code_book, String title, String author, String publisher, String category, String tanggal_pinjam, String tanggal_kembali, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.code_book = code_book;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.tanggal_pinjam = tanggal_pinjam;
        this.tanggal_kembali = tanggal_kembali; 
    }

    public int getID () {
        return ID;
    }

    public int getQuantity () {
        return quantity;
    }

    public String getCodeBook () {
        return code_book;
    }

    public String getTitle () {
        return title;
    }

    public String getAuthor () {
        return author;
    }

    public String getPublisher () {
        return publisher;
    }

    public String getCategory () {
        return category;
    }

    public String getTanggalPinjam () {
        return tanggal_pinjam;
    }

    public String getTanggalKembali () {
        return tanggal_kembali;
    }

    
}
