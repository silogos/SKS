/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Pertanyaan;

import java.util.ArrayList;

public class ModelPertanyaan {
    private Integer ID;
    private ArrayList<ModelPilihan> pilihan;
    
    public ModelPertanyaan(int ID, ArrayList<ModelPilihan> pilihan) {
        this.ID = ID; 
        this.pilihan = pilihan;
    }

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * @return the pilihan
     */
    public ArrayList<ModelPilihan> getPilihan() {
        return pilihan;
    }

    /**
     * @param pilihan the pilihan to set
     */
    public void setPilihan(ArrayList<ModelPilihan> pilihan) {
        this.pilihan = pilihan;
    }

}
