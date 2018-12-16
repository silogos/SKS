package Moduls.Pertanyaan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import libs.DBConnect;

/**
 *
 * @author ThinkPad
 */
public class ControllerPertanyaan {
    
    private static int index = 0;
    private static ArrayList<ModelPertanyaan> list = new ArrayList<>();
    
    public void getPertanyaan() {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT * from question ORDER BY RAND() LIMIT 10";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelPertanyaan data;
            ArrayList<ModelPilihan> list_pilihan;
            while (rs.next()) {
                list_pilihan = new ArrayList<>();
                ModelPilihan dominan = new ModelPilihan(1, 0, rs.getString("dominan"));
                ModelPilihan influens = new ModelPilihan(2, 1, rs.getString("influens"));
                ModelPilihan complaien = new ModelPilihan(3, 2, rs.getString("complaien"));
                ModelPilihan stediness = new ModelPilihan(4, 3, rs.getString("stediness"));
                list_pilihan.add(dominan);
                list_pilihan.add(influens);
                list_pilihan.add(complaien);
                list_pilihan.add(stediness);
                Collections.shuffle(list_pilihan);
                data = new ModelPertanyaan(rs.getInt("question_id"), list_pilihan);
                
                getList().add(data);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public ModelPertanyaan viewByIndex(int ID) {
       ModelPertanyaan item = getList().get(getIndex());
       return item;
    }
    
    public boolean create(String dominan, String influens, String complaien, String stediness) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO `question` (dominan, influens, complaien, stediness) VALUES (?, ?, ?, ?)";
            PreparedStatement stat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, dominan);
            stat.setString(2, influens);
            stat.setString(3, complaien);
            stat.setString(4, stediness);
            int exe = stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();
            if (rs.next()){
                int inserted_id=rs.getInt(1);
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(int ID) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "DELETE FROM `question` WHERE `question_id` = ?";
            PreparedStatement stat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, ID);
            int exe = stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();
            if (rs.next()){
                int inserted_id=rs.getInt(1);
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    /**
     * @return the index
     */
    public static int getIndex() {
        return index;
    }

    /**
     * @param aIndex the index to set
     */
    public static void setIndex(int aIndex) {
        index = aIndex;
    }

    /**
     * @return the list
     */
    public static ArrayList<ModelPertanyaan> getList() {
        return list;
    }

    /**
     * @param aList the list to set
     */
    public static void setList(ArrayList<ModelPertanyaan> aList) {
        list = aList;
    }
}
