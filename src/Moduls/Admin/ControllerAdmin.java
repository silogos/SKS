/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import libs.DBConnect;

/**
 *
 * @author ThinkPad
 */
public class ControllerAdmin {
    
    public ArrayList<ModelAdmin> view() {
        ArrayList<ModelAdmin> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `admin`";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelAdmin data;
            while (rs.next()) {
                data = new ModelAdmin(
                    rs.getInt("id"), 
                    rs.getString("username"), 
                    rs.getString("password")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ModelAdmin viewByID(int ID) {
        ModelAdmin data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `admin` where id = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelAdmin(
                    rs.getInt("id"), 
                    rs.getString("username"), 
                    rs.getString("password")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public void create(String username, String password) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "INSERT INTO `admin` VALUES (NULL, '"+ username +"', '"+ password +"')";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void update(int ID, String username, String password) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `admin` SET `username` = '"+ username +"', `password` = '"+ password +"' WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
        
    public void delete(int ID) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "DELETE FROM `admin` WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
