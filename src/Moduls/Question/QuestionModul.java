/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Question;

import Moduls.Characteristic.CharacteristicModul;
import java.util.ArrayList;
/**
 *
 * @author ThinkPad
 */
public class QuestionModul {
    
    private Integer id;
    private ArrayList<CharacteristicModul> answer;

    public QuestionModul(Integer id, ArrayList<CharacteristicModul> answer) {
        this.id = id;
        this.answer = answer;
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the answer
     */
    public ArrayList<CharacteristicModul> getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(ArrayList<CharacteristicModul> answer) {
        this.answer = answer;
    }

}
