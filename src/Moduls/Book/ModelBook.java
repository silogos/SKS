/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Book;


public class ModelBook {
    private int ID, jumlah;
    private String kode, kode_category, judul, pengarang, penerbit, tempat;
    
    public ModelBook(int ID, String kode, String kode_category, String judul, String pengarang, String penerbit, int jumlah, String tempat) {
        this.ID = ID; 
        this.kode = kode; 
        this.kode_category = kode_category;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit; 
        this.jumlah = jumlah; 
        this.tempat = tempat;
    }

    ModelBook(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId() {
        return ID;
    }
    
    public String getKode() {
        return kode;
    }
    
    public String getKode_category() {
        return kode_category;
    }
    
    public String getJudul() {
        return judul;
    }
    
    public String getPengarang() {
        return pengarang;
    }
    
    public String getPenerbit() {
        return penerbit;
    }
    
    public int getJumlah() {
        return jumlah;
    }
    
    public String getTempat() {
        return tempat;
    }
    
}
