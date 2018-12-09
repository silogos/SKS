package Moduls.BookCategory;

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
public class ControllerBookCategory {
    
    public ArrayList<ModelBookCategory> view() {
        ArrayList<ModelBookCategory> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `category`";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelBookCategory data;
            while (rs.next()) {
                data = new ModelBookCategory(
                    rs.getInt("id"), 
                    rs.getString("code_category"),
                    rs.getString("title")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ModelBookCategory viewByID(int ID) {
        ModelBookCategory data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `book` where id = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelBookCategory(
                    rs.getInt("id"), 
                    rs.getString("code_category"),
                    rs.getString("title")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public boolean create(String code_category, String title) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "INSERT INTO `category` "
                    + "VALUES "
                    + "(NULL, '"+ code_category +"', '"+ title +"')";
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(int ID, String code_category, String title) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `category` SET "
                    + "`code_category` = '"+ code_category +"', "
                    + "`title` = '"+ title +"' "
                    + "WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
        
    public boolean delete(int ID) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "DELETE FROM `category` WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
