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
public class DiscModul {
    
    private Integer dominance, influence, steadiness, compliance, total_nilai;
    private String description;

    public DiscModul(Integer dominance, Integer influence, Integer steadiness, Integer compliance, Integer total_nilai, String description) {
        this.dominance = dominance;
        this.influence = influence;
        this.steadiness = steadiness;
        this.compliance = compliance;
        this.total_nilai = total_nilai;
        this.description = description;
    }

    /**
     * @return the dominance
     */
    public Integer getDominance() {
        return dominance;
    }

    /**
     * @param dominance the dominance to set
     */
    public void setDominance(Integer dominance) {
        this.dominance = dominance;
    }

    /**
     * @return the influence
     */
    public Integer getInfluence() {
        return influence;
    }

    /**
     * @param influence the influence to set
     */
    public void setInfluence(Integer influence) {
        this.influence = influence;
    }

    /**
     * @return the steadiness
     */
    public Integer getSteadiness() {
        return steadiness;
    }

    /**
     * @param steadiness the steadiness to set
     */
    public void setSteadiness(Integer steadiness) {
        this.steadiness = steadiness;
    }

    /**
     * @return the compliance
     */
    public Integer getCompliance() {
        return compliance;
    }

    /**
     * @param compliance the compliance to set
     */
    public void setCompliance(Integer compliance) {
        this.compliance = compliance;
    }

    /**
     * @return the total_nilai
     */
    public Integer getTotal_nilai() {
        return total_nilai;
    }

    /**
     * @param total_nilai the total_nilai to set
     */
    public void setTotal_nilai(Integer total_nilai) {
        this.total_nilai = total_nilai;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
