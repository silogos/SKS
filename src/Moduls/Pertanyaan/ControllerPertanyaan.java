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
    
    private ArrayList<ModelPertanyaan> list = new ArrayList<>();
    
    
//    public static void main (String[] args) {
//        String s = "Memberi semangat|Petualang|teliti|mudah menyesuaikan diri";
//        String[] data = s.split("\\|");
//        System.out.println(Arrays.toString(data));
//        System.out.println(data[0]);
//    }
    
    public ControllerPertanyaan() {}
    public ArrayList<ModelPertanyaan> getPertanyaan() {
        try {
            Connection connection = DBConnect.Conn();
            String sql = "SELECT " +
                         "	question_id, " +
                         "	GROUP_CONCAT(id) as id, " +
                         "	GROUP_CONCAT(type) as type, " +
                         "	GROUP_CONCAT(text SEPARATOR '|') as text " +
                         "FROM `characteristic` " +
                         "GROUP BY question_id " +
                         "HAVING COUNT(id) = 4 " +
                         "LIMIT 10";
            Statement stat = (Statement) connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ModelPertanyaan data;
            ArrayList<ModelPilihan> list_pilihan;
            while (rs.next()) {
                list_pilihan = new ArrayList<>();
                String[] list_id, list_type, list_text;
                list_id = rs.getString("id").split(",");
                list_type = rs.getString("type").split(",");
                list_text = rs.getString("text").split("\\|");
                System.out.println(rs.getString("text"));
                for(int i = 0; i < 4; i++){
                    ModelPilihan item;
                    item = new ModelPilihan(
                               Integer.parseInt(list_id[i]), 
                               Integer.parseInt(list_type[i]), 
                               list_text[i]
                           );
                    list_pilihan.add(item);
                }
                Collections.shuffle(list_pilihan);
                data = new ModelPertanyaan(rs.getInt("question_id"), list_pilihan);
                list.add(data);
            }
            return list;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ModelPertanyaan viewByIndex(int ID) {
       return this.list.get(ID);
    }
    
    public boolean create(ArrayList<ModelPilihan> list_pilihan) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "INSERT INTO `question` (`id`) VALUES (NULL);";
                   query += "INSERT INTO `characteristic` (`question_id`, `type`, `text`) VALUES ";
            for(ModelPilihan pilihan : list_pilihan ){
                query += "(LAST_INSERT_ID(), "+ pilihan.getType() +", "+ pilihan.getJawaban() +"),";
            }
            PreparedStatement stat = connection.prepareStatement(query);
            int exe = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(int question_id) {
        try {
            Connection connection = DBConnect.Conn();
            String query = "DELETE FROM `question` WHERE `id` = "+ question_id +";"
                         + "DELETE FROM `rules` WHERE `characteristic_id` IN "
                         + "(SELECT id FROM `characteristic` WHERE `question_id` =  "+ question_id +")"
                         + "DELETE FROM `characteristic` WHERE `question_id` = "+ question_id +";";
            PreparedStatement stat = connection.prepareStatement(query);
            int exe = stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    /**
     * @return the list
     */
    public ArrayList<ModelPertanyaan> getList() {
        return list;
    }

    /**
     * @param aList the list to set
     */
    public void setList(ArrayList<ModelPertanyaan> aList) {
        list = aList;
    }
    
    public int getTotalPertanyaan() {
        return list.size();
    }
}
