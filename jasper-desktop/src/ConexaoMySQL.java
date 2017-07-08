
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cláudio
 */
public class ConexaoMySQL {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String driver = "jdbc:mysql://localhost/cursojasper";
            Connection con = DriverManager.getConnection(driver, "root", "1234");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
