/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Personality;
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
public class PersonalityController {
    
    public ArrayList<PersonalityModul> getQuestion() {
        ArrayList<PersonalityModul> data = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * FROM personality";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                PersonalityModul jm = null;
                jm.setId(rs.getInt("id"));
                jm.setTitle(rs.getString("title"));
                jm.setDescription(rs.getString("description"));
                data.add(jm);
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public PersonalityModul getByID(Integer id) {
        PersonalityModul data = null;
        try {
            Connection connection = DBConnect.Conn();
            String query = "SELECT * FROM personality where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                data = new PersonalityModul(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public boolean create(PersonalityModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO job (title, description) VALUES (?,?)";
            PreparedStatement stat = connection.prepareStatement(query);
            String title = data.getTitle();
            String description = data.getDescription();
            stat.setString(1, title);
            stat.setString(2, description);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(PersonalityModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "UPDATE job SET title=?, description=? where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer id = data.getId();
            String text = data.getTitle();
            String description = data.getDescription();
            stat.setString(1, text);
            stat.setString(2, description);
            stat.setInt(3, id);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(PersonalityModul data) {
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
