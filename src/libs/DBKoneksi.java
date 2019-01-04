package libs;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class DBKoneksi {
    public Connection koneksi;
    public Statement keputusan;
    public ResultSet hasilSet;
    public String bahasasql;
    public void koneksiku(){
        try {
            koneksi = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/artificial_intelegen", "root", "");
            keputusan=(Statement)koneksi.createStatement();
        } catch (Exception e) {
        }
    }
    public void ambilData(){
        try {
            koneksiku();
            hasilSet = keputusan.executeQuery(bahasasql);
        } catch (Exception e) {
        }
    }
    
    public void crud(){
        try {
            koneksiku();
            keputusan.executeUpdate(bahasasql);
        } catch (Exception e) {
        }
    }
}
