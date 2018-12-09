package Moduls.Admin;

/**
 *
 * @author ThinkPad
 */
public class ModelAdmin {
    private int ID;
    private String username, password;
    
    public ModelAdmin(int ID, String username, String password) {
        this.ID = ID; 
        this.username = username; 
        this.password = password;
    }
    
    public int getId() {
        return ID;
    }
    
    public String getUsename() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
