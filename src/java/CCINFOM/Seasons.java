/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCINFOM;
import static CCINFOM.Queries.connPass;
import static CCINFOM.Queries.connSettings;
import static CCINFOM.Queries.connStr;
import static CCINFOM.Queries.connUser;
import java.sql.*;
import java.util.*;

public class Seasons {
    public ArrayList <String> seasons = new ArrayList<String>();

    public void getSeasons() {
      try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn;
            //conn = DriverManager.getConnection("jdbc:mysql://z3iruaadbwo0iyfp.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/jhf5oqmi1k3k4c9p?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&user=y3pq3f2uhp9t2gbp&password=i0alc39yfp0yqmeo");
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            // 2. Prepare the SQL Statement
            PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Season FROM players ORDER BY Season");
            // 3. Execute the SQL Statement
            ResultSet rs = stmt.executeQuery();
            // 4. Process the results
            seasons.clear();
            while (rs.next()) {
                seasons.add(rs.getString("Season"));
            }
            // 5. Disconnect
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("something went wrong" + e.getMessage());
        }        
    }   
    
}
