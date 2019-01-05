/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Question;

import Moduls.Characteristic.CharacteristicModul;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import libs.DBConnect;
import libs.Session;
/**
 *
 * @author ThinkPad
 */
public class QuestionController {

    public QuestionController() {}
    
    public ArrayList<QuestionModul> getList() {
        ArrayList<QuestionModul> data = new ArrayList<>();
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT " +
                         "	Q.*, " +
                         "	D.text as dominance, " +
                         "	D.type as dominance_type, " +
                         "	I.text as influence,  " +
                         "	I.type as influence_type, " +
                         "	S.text as steadiness, " +
                         "	S.type as steadiness_type, " +
                         "	C.text as compliance, " +
                         "	C.type as compliance_type " +
                         "FROM `question` Q " +
                         "JOIN characteristic D ON Q.dominance_id = D.id " +
                         "JOIN characteristic I ON Q.influence_id = I.id " +
                         "JOIN characteristic S ON Q.steadiness_id = s.id " +
                         "JOIN characteristic C ON Q.compliance_id = c.id";
            
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                QuestionModul qm = null;
                ArrayList<CharacteristicModul> answer_list = new ArrayList<>();
                CharacteristicModul dominance, influence, steadiness, compliance;
                dominance = new CharacteristicModul(
                    rs.getInt("dominance_id"), 
                    rs.getInt("dominance_type"),
                    rs.getString("dominance")
                );
                influence = new CharacteristicModul(
                    rs.getInt("influence_id"), 
                    rs.getInt("influence_type"), 
                    rs.getString("influence")
                );
                steadiness = new CharacteristicModul(
                    rs.getInt("steadiness_id"), 
                    rs.getInt("steadiness_type"), 
                    rs.getString("steadiness")
                );
                compliance = new CharacteristicModul(
                    rs.getInt("compliance_id"), 
                    rs.getInt("compliance_type"), 
                    rs.getString("compliance")
                );
                answer_list.add(dominance);
                answer_list.add(influence);
                answer_list.add(steadiness);
                answer_list.add(compliance);
                Collections.shuffle(answer_list);
                qm = new QuestionModul(rs.getInt("id"), answer_list);
                data.add(qm);
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public QuestionModul getByID(QuestionModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "SELECT " +
                           "	Q.*, " +
                           "	D.text as dominance, " +
                           "	D.type as dominance_type, " +
                           "	I.text as influence,  " +
                           "	I.type as influence_type, " +
                           "	S.text as steadiness, " +
                           "	S.type as steadiness_type, " +
                           "	C.text as compliance, " +
                           "	C.type as compliance_type " +
                           "FROM `question` Q " +
                           "JOIN characteristic D ON Q.dominance_id = D.id " +
                           "JOIN characteristic I ON Q.influence_id = I.id " +
                           "JOIN characteristic S ON Q.steadiness_id = s.id " +
                           "JOIN characteristic C ON Q.compliance_id = c.id "+ 
                           "WHERE Q.id = ?";
            PreparedStatement stat = connection.prepareStatement(query);
            Integer id = data.getId();
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                ArrayList<CharacteristicModul> answer_list = null;
                CharacteristicModul dominance, influence, steadiness, compliance;
                dominance = new CharacteristicModul(
                    rs.getInt("dominance_id"), 
                    rs.getInt("dominance_type"),
                    rs.getString("dominance")
                );
                influence = new CharacteristicModul(
                    rs.getInt("influence_id"), 
                    rs.getInt("influence_type"), 
                    rs.getString("influence")
                );
                steadiness = new CharacteristicModul(
                    rs.getInt("steadiness_id"), 
                    rs.getInt("steadiness_type"), 
                    rs.getString("steadiness")
                );
                compliance = new CharacteristicModul(
                    rs.getInt("compliance_id"), 
                    rs.getInt("compliance_type"), 
                    rs.getString("compliance")
                );
                answer_list.add(dominance);
                answer_list.add(influence);
                answer_list.add(steadiness);
                answer_list.add(compliance);
                data = new QuestionModul(
                        rs.getInt("id"),
                        answer_list
                );
            }
            return data;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public boolean create(ArrayList<CharacteristicModul> answer_list) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO characteristic (dominance_id, influence_id, steadiness_id, compliance_id) VALUES (?,?,?,?)";
            PreparedStatement stat = connection.prepareStatement(query);
            CharacteristicModul dominance, influence, steadiness, compliance;
            dominance = answer_list.get(0);
            influence = answer_list.get(1);
            steadiness = answer_list.get(2);
            compliance = answer_list.get(3);
            stat.setInt(1, dominance.getId());
            stat.setInt(2, influence.getId());
            stat.setInt(3, steadiness.getId());
            stat.setInt(4, compliance.getId());
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean update(QuestionModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "UPDATE characteristic SET type=?, text=? where id=?";
            PreparedStatement stat = connection.prepareStatement(query);
            ArrayList<CharacteristicModul> answer_list = data.getAnswer();
            CharacteristicModul dominance, influence, steadiness, compliance;
            dominance = answer_list.get(0);
            influence = answer_list.get(1);
            steadiness = answer_list.get(2);
            compliance = answer_list.get(3);
            stat.setInt(1, dominance.getId());
            stat.setInt(2, influence.getId());
            stat.setInt(3, steadiness.getId());
            stat.setInt(4, compliance.getId());
            stat.setInt(5, data.getId());
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(QuestionModul data) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "DELETE FROM characteristic where id=?";
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
    
    public boolean insertAnswers(ArrayList<CharacteristicModul> most, ArrayList<CharacteristicModul> least) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO `result` (`user_id`, `characteristic_id`, `type`) VALUES ";
            Integer user_id = Session.getID();
            for(CharacteristicModul cm : most){
                query += "("+user_id+", "+ cm.getId() +", 'most'),";
            }
            Integer indexLoop = 1; 
            for(CharacteristicModul cm : least){
                if(least.size() == indexLoop){
                    query += "("+user_id+", "+ cm.getId() +", 'least');";
                } else {
                    query += "("+user_id+", "+ cm.getId() +", 'least'),";
                }
                indexLoop++;
            }
            System.out.println("query: " + query);
            PreparedStatement stat = connection.prepareStatement(query);
            int rs = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
}
