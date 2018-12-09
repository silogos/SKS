package Moduls.Book;

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
public class ControllerBook {
    
    public ArrayList<ModelBook> view() {
        ArrayList<ModelBook> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `book`";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelBook data;
            while (rs.next()) {
                data = new ModelBook(
                    rs.getInt("id"), 
                    rs.getString("code_book"), 
                    rs.getString("code_category"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getInt("quantity"),
                    rs.getString("location")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public ModelBook viewByID(int ID) {
        ModelBook data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `book` where id = " + ID;
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelBook(
                    rs.getInt("id"), 
                    rs.getString("code_book"), 
                    rs.getString("code_category"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getInt("quantity"),
                    rs.getString("location")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public ModelBook viewByCode(String code) {
        ModelBook data = null;
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `book` where code_book = '" + code +"'";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                data = new ModelBook(
                    rs.getInt("id"), 
                    rs.getString("code_book"), 
                    rs.getString("code_category"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getInt("quantity"),
                    rs.getString("location")
                );
            } else {
                System.err.println("Data tidak ditemukan");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return data;
    }
    
    public ArrayList<ModelBook> viewWithSearch(String search) {
        ArrayList<ModelBook> list = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM `book` "
                    + "WHERE "
                    + "code_book LIKE '%"+search+"%' "
                    + "OR "
                    + "title LIKE '%"+search+"%'";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelBook data;
            while (rs.next()) {
                data = new ModelBook(
                    rs.getInt("id"), 
                    rs.getString("code_book"), 
                    rs.getString("code_category"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getInt("quantity"),
                    rs.getString("location")
                );
                
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
    public boolean create(String code_book, String code_category, String title, String author, String publisher, int quantity, String location) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "INSERT INTO `book` VALUES (NULL, '"+code_book+"', '"+code_category+"', '"+title+"', '"+author+"', '"+publisher+"', "+quantity+", '"+location+"')";

            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(int ID, String code_book, String code_category, String title, String author, String publisher, int quantity, String location) {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "UPDATE `book` SET "
                    + "`code_book` = '"+ code_book +"', "
                    + "`code_category` = '"+ code_category +"', "
                    + "`title` = '"+ title +"', "
                    + "`author` = '"+ author +"', "
                    + "`publisher` = '"+ publisher +"', "
                    + "`quantity` = '"+ quantity +"', "
                    + "`location` = '"+ location +"' "
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
            String sql = "DELETE FROM `book` WHERE `id` = " + ID;
            Statement stat = (Statement) connection.createStatement();
            int rs = stat.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
