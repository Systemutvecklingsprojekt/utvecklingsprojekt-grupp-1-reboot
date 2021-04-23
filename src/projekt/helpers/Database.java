package projekt.helpers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Josef
 */
public class Database
{
	
	private static Connection conn = null;
	private static final String CONNECTION_STRING = "jdbc:mysql://jamaihaitot.com:2230/development";
	private static final String USERNAME = "development";
	private static final String PASSWORD = "tUG8p6xQsXwEXYS8";
	
	private Database()
	{
		
	}
	
	public static int executeUpdate(String query) throws SQLException
	{
		Statement stat = getConn().createStatement();
		stat.closeOnCompletion();
		return stat.executeUpdate(query);
	}
	
	public static String fetchSingle(String query) throws SQLException
	{
		Statement stat = getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stat.closeOnCompletion();
		String single = null;
		ResultSet rs = stat.executeQuery(query);
		if (rs.next()) {
			single = rs.getString(1);
		}
		return single;
	}

	public static ArrayList<String> fetchColumn(String query) throws SQLException
	{
		ResultSet rs;
		rs = fetchRows(query);
		ArrayList<String> columnList = new ArrayList<>();
		while (rs.next()) {
			columnList.add(rs.getString(1));
		}
		return columnList;
		
	}

	public static ResultSet fetchRows(String query) throws SQLException
	{
		Statement stat = getConn().createStatement();
		stat.closeOnCompletion();
		return stat.executeQuery(query);
	}
	
	public static Connection getConn()
	{
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
