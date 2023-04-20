
package javacramera;

import java.sql.*;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class getDbMysql {

    public static String getDb(int currntId) {

        String url = "jdbc:mysql://wmsp2.mysql.database.azure.com/sanderdb";
        String user = "ADM";
        String password = "QQ1122ww";
        //String password = "Mwr57bwk!";

        String currntString = "null_vardi";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            String query = "SELECT * FROM persons WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, currntId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String contucCode = result.getString("state");
                int age = result.getInt("age");
                currntString = "id: " + id + ", name: " + name + ", age: " + age;
                System.out.println("id: " + id + ", name: " + name + ", age: " + age);
            }
            conn.close();

        } catch (SQLException ex) {

            Logger.getLogger(getDbMysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return currntString;
    }

    public static void insertDb(int id, String currntName, String CountryCode, int age) {
        String url = "jdbc:mysql://wmsp2.mysql.database.azure.com/sanderdb";
        String user = "ADM";
        String password = "QQ1122ww";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO persons (name, age, state, id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(4, id);
            statement.setString(1, currntName);
            statement.setInt(2, age);
            statement.setString(3, CountryCode);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {     
                System.out.println("A new person was inserted successfully!");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
        }

    }

}
