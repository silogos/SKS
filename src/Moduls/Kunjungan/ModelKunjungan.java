/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Kunjungan;

import Moduls.Anggota.*;

public class ModelKunjungan {
    private int ID;
    private String nis, nama, kelas, tanggal;
    
    public ModelKunjungan(int ID, String nis, String nama, String kelas, String tanggal) {
        this.ID = ID; 
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.tanggal = tanggal;
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
           
    public String getTanggal() {
        return tanggal;
    }
    
}
