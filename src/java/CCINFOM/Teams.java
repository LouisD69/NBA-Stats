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

public class Teams {
    public ArrayList <String> teams = new ArrayList<String>();   
 
    
    public void getTeams() {
      try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn;
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            // 2. Prepare the SQL Statement
            PreparedStatement stmt = conn.prepareStatement("select distinct city, nickname\n" +
                                                            "from teams order by city;");
            // 3. Execute the SQL Statement
            ResultSet rs = stmt.executeQuery();
            // 4. Process the results
            while (rs.next()) {
                teams.add(rs.getString("city") + " " + rs.getString("nickname"));
            }
            
            // 5. Disconnect
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("something went wrong " + e.getMessage());
        }        
    }
    
}
