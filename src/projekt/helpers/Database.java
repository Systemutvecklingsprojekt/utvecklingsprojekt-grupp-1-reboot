package projekt.helpers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 *
 * @author Josef
 */
public class Database {
    
    private static Connection conn = null;
    private static final String url = "jdbc:mysql://jamaihaitot.com:2230/development";
    private static final String user = "development";
    private static final String password = "tUG8p6xQsXwEXYS8";
    
    private Database() {
        
    }
    
    
    public static int executeUpdate(String query) throws SQLException {
        Statement stat = getConn().createStatement();
        stat.closeOnCompletion();
        return stat.executeUpdate(query);
    }

    public static String fetchSingle(String query) throws SQLException {
        Statement stat = getConn().createStatement();
        stat.closeOnCompletion();
        String single = null;
        ResultSet rs = stat.executeQuery(query);
        if(rs.next()){
            single = rs.getString(1);
        }
        return single;
    }

    public static ResultSet fetchRows(String query) throws SQLException {
        Statement stat = getConn().createStatement();
        stat.closeOnCompletion();
        return stat.executeQuery(query);
    }
    
    public static Connection getConn() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}
