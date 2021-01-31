/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCINFOM;
import java.sql.*;
import java.util.*;

public class Queries {
    public ArrayList <String> seasons = new ArrayList<String>();
    
    // connection string
    //public String connStr = "jdbc:mysql://phtfaw4p6a970uc0.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/l3c6nom2ws5gn61d";
    //
    
    /*
    public static final String connStr = "jdbc:mysql://localhost:3306/nba_mco2?";
    public static final String connSettings = "useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&";
    public static final String connUser = "user=root&";
    public static final String connPass = "password=6969";
    */
    
    public static final String connStr = "jdbc:mysql://j21q532mu148i8ms.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/cbewbrooc8l4shgc?";
    public static final String connSettings = "useSSL=false&allowPublicKeyRetrieval=true&";
    public static final String connUser = "user=j7xayuix5gisz0nn&";
    public static final String connPass = "password=s2yr6nqg7z9ha23l";
    

   
    // query variables
    public Connection conn;
    public PreparedStatement stmt;
    
    public void close()
    {
        try{
            stmt.close();
            conn.close();
        }catch (Exception e) {
                System.out.println("something went wrong" + e.getMessage());
        }  
        
    }
    
    public ResultSet slice(String stat, String year) {
        ResultSet rs = null;
        try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            System.out.println(conn);
            // 2. Prepare the SQL Statement
            stmt = conn.prepareStatement("SELECT g.season, t.nickname, p.player_name AS Player, SUM(" + stat + ") AS " + stat +
                                            " FROM players p, gdetails gd, games g, teams t\n" +
                                            "WHERE p.player_id = gd.player_id AND g.game_id = gd.game_id AND p.SEASON=g.SEASON AND t.team_id=gd.team_id AND g.season = '" + year + "' \n" +
                                            "GROUP BY g.season, t.nickname, p.player_name\n" +
                                            "ORDER BY SUM(" + stat + ") DESC;"
                                        );
          
            // 3. Execute the SQL Statement
            rs = stmt.executeQuery();
                 
        } catch (Exception e) {
                System.out.println("something went wrong" + e.getMessage());
            }  
        return rs;
    }   
    
     public ResultSet rollup(String stat) {
        ResultSet rs = null;
        try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            // 2. Prepare the SQL Statement
            stmt = conn.prepareStatement("SELECT CITY, NICKNAME AS TEAM_NAME, P.PLAYER_NAME AS PLAYER, SUM("+ stat + ") AS " + stat +
                                            " FROM gdetails GD\n" +
                                            "JOIN games G USING(GAME_ID)\n" +
                                            "JOIN teams USING(TEAM_ID)\n" +
                                            "JOIN players P USING(PLAYER_ID)\n" +
                                            "WHERE P.SEASON = G.SEASON\n" +
                                            "GROUP BY CITY, TEAM_NAME, P.PLAYER_NAME\n" +
                                            "WITH ROLLUP;"
                                         );
            // 3. Execute the SQL Statement
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
                System.out.println("something went wrong" + e.getMessage());
            }  
        return rs;
    }   
    
    public ResultSet drilldown1() {
        ResultSet rs = null;
        try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            // 2. Prepare the SQL Statement
            stmt = conn.prepareStatement("SELECT SEASON, SUM(PTS), SUM(AST), SUM(REB)\n" +
                                            "FROM gdetails GD, games G\n" +
                                            "WHERE GD.GAME_ID = G.GAME_ID\n" +
                                            "GROUP BY SEASON\n" +
                                            "ORDER BY SEASON"
                                        );
            // 3. Execute the SQL Statement
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
                System.out.println("something went wrong" + e.getMessage());
            }  
        return rs;
    }
    
    public ResultSet drilldown2() {
        ResultSet rs = null;
        try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            // 2. Prepare the SQL Statement
            stmt = conn.prepareStatement("SELECT SEASON, MONTH_DATE_EST, SUM(PTS), SUM(AST), SUM(REB)\n" +
                                            "FROM gdetails GD, games G\n" +
                                            "WHERE GD.GAME_ID = G.GAME_ID\n" +
                                            "GROUP BY SEASON, MONTH_DATE_EST\n" +
                                            "ORDER BY SEASON, MONTH_DATE_EST"
                                        );
            // 3. Execute the SQL Statement
            rs = stmt.executeQuery();
  
            
        } catch (Exception e) {
                System.out.println("something went wrong" + e.getMessage());
            }  
        return rs;
    } 
    
    public ResultSet drilldown3() {
        ResultSet rs = null;
        try {
            // 1. Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(connStr + connSettings + connUser + connPass);
            // 2. Prepare the SQL Statement
            stmt = conn.prepareStatement("SELECT SEASON, MONTH_DATE_EST, GAME_DATE_EST, SUM(PTS), SUM(AST), SUM(REB)\n" +
                                            "FROM gdetails GD, games G\n" +
                                            "WHERE GD.GAME_ID = G.GAME_ID\n" +
                                            "GROUP BY SEASON, MONTH_DATE_EST, GAME_DATE_EST\n" +
                                            "ORDER BY SEASON, MONTH_DATE_EST, GAME_DATE_EST"
                                        );
            // 3. Execute the SQL Statement
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
                System.out.println("something went wrong" + e.getMessage());
            }  
        return rs;
    } 
    
}
