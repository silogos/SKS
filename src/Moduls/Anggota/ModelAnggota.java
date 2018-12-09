/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Anggota;

public class ModelAnggota {
    private int ID;
    private String nis, nama, kelas;
    
    public ModelAnggota(int ID, String nis, String nama, String kelas) {
        this.ID = ID; 
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
    }
    
    public int getId() {
        return ID;
    }
    
    public String getNis() {
        return nis;
    }
    
    public String getNama() {
        return nama;
    }
       
    public String getKelas() {
        return kelas;
    }
    
}
