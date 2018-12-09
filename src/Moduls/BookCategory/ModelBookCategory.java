/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.BookCategory;

import Moduls.Book.*;


public class ModelBookCategory {
    private int ID;
    private String code_category, title;
    
    public ModelBookCategory(int ID, String code_category, String title) {
        this.ID = ID; 
        this.code_category = code_category;
        this.title = title;
    }
    
    public int getId() {
        return ID;
    }
    
    public String getCodeCategory() {
        return code_category;
    }
    
    public String getTitle() {
        return title;
    }
    
}
