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
    //public String connSettings = "useSSL=false&allowPublicKeyRetrieval=true&";
    
    public static final String connStr = "jdbc:mysql://localhost:3306/nba_mco2?";
    public static final String connSettings = "useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&";
    public static final String connUser = "user=root&";
    public static final String connPass = "password=6969";
    
    // query variables
    public String name;  
    public String nSeasons;
    public String fg3m;
    public String fgm;
    public String pts;
    public String reb;
    public String ast;
    public String stl;
    public String blk;
    
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
            stmt = conn.prepareStatement("SELECT g.season AS Season, p.player_name AS Player, SUM(" + stat + ") AS " + stat +
                                            " FROM players p, gdetails gd, games g\n" +
                                            "WHERE p.player_id = gd.player_id AND g.game_id = gd.game_id AND p.SEASON=g.SEASON AND g.season = '" + year + "' \n" +
                                            "GROUP BY g.season, p.player_name\n" +
                                            "ORDER BY SUM(" + stat + ") DESC;"
                                        );
            
            // "WHERE p.player_id = gd.player_id AND g.game_id = gd.game_id AND g.season = '" + year + "' " 
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
            stmt = conn.prepareStatement("SELECT CITY, NICKNAME AS TEAM_NAME, START_POSITION, PLAYER_ID, SUM("+ stat + ") AS " + stat +
                                            " FROM GDETAILS GD\n" +
                                            "JOIN GAMES G USING(GAME_ID)\n" +
                                            "JOIN TEAMS USING(TEAM_ID)\n" +
                                            "JOIN PLAYERS P USING(PLAYER_ID)\n" +
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
                                            "FROM GDETAILS GD, GAMES G\n" +
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
                                            "FROM GDETAILS GD, GAMES G\n" +
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
                                            "FROM GDETAILS GD, GAMES G\n" +
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
