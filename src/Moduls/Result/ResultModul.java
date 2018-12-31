/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Result;

import Moduls.Characteristic.CharacteristicModul;
import Moduls.User.UserModul;

/**
 *
 * @author ThinkPad
 */
public class ResultModul {
    
    private Integer id;
    private UserModul user_id;
    private CharacteristicModul characteristic_id;

    public ResultModul(Integer id, UserModul user_id, CharacteristicModul characteristic_id) {
        this.id = id;
        this.user_id = user_id;
        this.characteristic_id = characteristic_id;
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
     * @return the user_id
     */
    public UserModul getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(UserModul user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the characteristic_id
     */
    public CharacteristicModul getCharacteristic_id() {
        return characteristic_id;
    }

    /**
     * @param characteristic_id the characteristic_id to set
     */
    public void setCharacteristic_id(CharacteristicModul characteristic_id) {
        this.characteristic_id = characteristic_id;
    }
    
    
    
}
