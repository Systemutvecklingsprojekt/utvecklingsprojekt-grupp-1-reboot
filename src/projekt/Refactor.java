/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josef
 */
public class Refactor
{
	
    private static String capitalize(final String line){
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
    public static DefaultTableModel tableModelBuilder(ResultSet rs) throws SQLException
	{
		ResultSetMetaData metaData = rs.getMetaData();

		//kör igenom metadatan (ex hur många columner, och hämtar namnen)
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
                    String header = metaData.getColumnName(column);
                    String refactoredHeader = header.replaceAll("\\d+", "").replaceAll("(.)([A-Z])", "$1 $2");
                    columnNames.add(capitalize(refactoredHeader));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);
	}
	
}
