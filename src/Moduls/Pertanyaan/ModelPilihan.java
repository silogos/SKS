/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Pertanyaan;

public class ModelPilihan {
    private Integer ID, type;
    private String jawaban;
    
    public ModelPilihan(int ID, int type, String jawaban) {
        this.ID = ID; 
        this.type = type;
        this.jawaban = jawaban;
    }
    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param aID the ID to set
     */
    public void setID(Integer aID) {
        ID = aID;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param aType the type to set
     */
    public void setType(Integer aType) {
        type = aType;
    }

    /**
     * @return the jawaban
     */
    public String getJawaban() {
        return jawaban;
    }

    /**
     * @param jawaban the jawaban to set
     */
    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
    
    
    
}
