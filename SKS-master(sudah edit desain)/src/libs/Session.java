/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

/**
 *
 * @author ThinkPad
 */
public class Session {
    private static Integer ID;
    private static String nama;
    
    public Session(int ID, String nama) {
        this.ID = ID; 
        this.nama = nama;
    }

    /**
     * @return the ID
     */
    public static Integer getID() {
        return ID;
    }

    /**
     * @param aID the ID to set
     */
    public static void setID(Integer aID) {
        ID = aID;
    }

    /**
     * @return the nama
     */
    public static String getNama() {
        return nama;
    }

    /**
     * @param aNama the nama to set
     */
    public static void setNama(String aNama) {
        nama = aNama;
    }
}
