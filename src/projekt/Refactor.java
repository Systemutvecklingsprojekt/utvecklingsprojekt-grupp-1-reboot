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
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projekt.frames.ShowPost;

/**
 *
 * @author Josef
 */
public class Refactor
{

	private static String capitalize(final String line)
	{
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
			/*
                    Först tar vi bort eventuella siffror, sedan lägger vi in ett whitespace framför kapitaliserade karaktärer
                    som inte är den första karaktären.
			 */
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

	public static int getTableValueFirstColumn(JTable table) throws ArrayIndexOutOfBoundsException
	{
		return (int) table.getValueAt(table.getSelectedRow(), 0);
	}

	public static void showPostByPostID(User user, JTable table) throws ArrayIndexOutOfBoundsException
	{
		int id = Refactor.getTableValueFirstColumn(table);
		new ShowPost(user, id).setVisible(true);

	}

	public static JTable populateTable(ResultSet resultSet)
	{
		JTable table = null;
		try {
			table = new JTable(Refactor.tableModelBuilder(resultSet));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	public static void setFocus(JFrame frame)
	{
		frame.setLocationRelativeTo(null);
	}

}
