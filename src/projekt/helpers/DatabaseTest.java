package projekt.helpers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import projekt.helpers.Database;

/**
 * @author Josef Jamai-Haitot
 */
public class DatabaseTest {
//------ Cheat sheet:
//------ https://github.com/rgarciacarmona/Java-Database-Cheatsheets/blob/master/JDBC%20Cheatsheet.md ------//
//------ 

    public static void main(String args[]) {
        Connection conn;
        try {
//------------ Example 1 - Getting Back Multiple Rows
            conn = Database.getConn();
            Statement stat = conn.createStatement();
            ResultSet rs;
//            stat.closeOnCompletion();
            rs = stat.executeQuery("select * from User;");
            
//------------ Example 1 - END ------------------------------------------------
//------------ Example 2 - Print from ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {// .next() goes through one row everytime it is called while return false if there is no next
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    String columnName = rsmd.getColumnName(i);
                    System.out.format("%13s: %-50s \n", columnName, columnValue);
                    //System.out.println(columnName + "" + columnValue);
                }
                System.out.println("");
            }
            rs.close();
//------------ Example 2 - END ------------------------------------------------
//------------ Example 3 - Inserting a row
//            String insertion = "INSERT INTO User(Password, eMail, firstName, lastName, adminStatus) VALUES ('faust', 'fakelin.preis', 'Hersheys', 'Kiss', 'N');";
//            stat.executeUpdate(insertion);
//            String deletion = "DELETE FROM User WHERE eMail = 'fakelin.preis'";
//            stat.executeUpdate(deletion);
//------------ Example 3 - END ------------------------------------------------
//------------ Example 4 - Fetch Single
            System.out.println("Fetch Single: " + Database.fetchSingle("SELECT eMail FROM User WHERE UserID = 7"));

//------------ Example 4 - END ------------------------------------------------
//------------ Example 5 - Update
Database.executeUpdate("INSERT INTO User VALUES (5,'faust', 'test@insert and delete', 'Hersheys', 'Kiss', 'N');");
System.out.println("Fetch Single: " + Database.fetchSingle("SELECT eMail FROM User WHERE UserID = 5"));
//------------ Example 5 - END ------------------------------------------------
//------------ Example 5 - Delete
Database.executeUpdate("DELETE FROM User WHERE UserID = 5");
//------------ Example 5 - END ------------------------------------------------
//------------ Example 6 - Fetch Rows
Database.fetchRows("select * from User;");
//------------ Example 6 - END ------------------------------------------------
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
