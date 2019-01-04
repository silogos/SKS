/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Job;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import libs.DBConnect;
/**
 *
 * @author ThinkPad
 */
public class JobController {
    
    public ArrayList<JobModul> getList() {
        ArrayList<JobModul> data = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM job";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                JobModul jm = null;
                jm.setId(rs.getInt("id"));
                jm.setTitle(rs.getString("text"));
                data.add(jm);
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public JobModul getByID(Integer id) {
        JobModul data = null;
        try {
            Connection connection = DBConnect.Conn();
            String query = "SELECT * FROM job where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                data = new JobModul(
                        rs.getInt("id"),
                        rs.getString("title")
                );
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public boolean create(JobModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO job (title) VALUES (?)";
            PreparedStatement stat = connection.prepareStatement(query);
            String title = data.getTitle();
            stat.setString(1, title);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(JobModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "UPDATE job SET title=? where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer id = data.getId();
            String text = data.getTitle();
            stat.setString(1, text);
            stat.setInt(2, id);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(JobModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "DELETE FROM job where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer id = data.getId();
            stat.setInt(1, id);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
}
