/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import javax.swing.JScrollPane;
import projekt.helpers.Database;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Amand
 */
public class SearchResults extends javax.swing.JFrame {

    private javax.swing.JTable jTable2;

    /**
     * Creates new form FormellBlogg
     */
    public SearchResults(String searchResult) {
        //String query = "SELECT Post.postID FROM Post";
        //String joinQuery = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.description, TagName FROM User, Post WHERE Post.UserID = User.UserID AND (User.firstName LIKE '%"+searchResult+"%'OR User.lastName LIKE '%"+searchResult+"%' OR Post.title LIKE '%"+searchResult+"%'OR Post.description LIKE '%"+searchResult+"%');";
        String joinQuery = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.description, Tag.TagName FROM User JOIN Post ON User.UserID = Post.UserID JOIN Post_Tag ON Post.PostID = Post_Tag.PostID JOIN Tag ON Post_Tag.TagId = Tag.TagId AND (User.firstName LIKE '%"+searchResult+"%'OR User.lastName LIKE '%"+searchResult+"%' OR Post.title LIKE '%"+searchResult+"%'OR Post.description LIKE '%"+searchResult+"%' OR Tag.TagName LIKE '%"+searchResult+"%') GROUP BY Post.PostID;";
        initComponents();
        
        try {
            fillTable(Database.fetchRows(joinQuery));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Visa inl�gg");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(132, 132, 132))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(131, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(45, 45, 45)
                .addComponent(jBBack)
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        int id = (int) (jTable2.getValueAt(jTable2.getSelectedRow(), 0));
        new ShowPost(id).setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    public DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        //k�r igenom metadatan (ex hur m�nga columner, och h�mtar namnen)
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
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

    

    private void fillTable(ResultSet rs) {
        
        try {
            jTable2 = new JTable(fyll(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jScrollPane1.setViewportView(jTable2);
        jTable2.setVisible(true);
        //K�r emot Databasen och h�mtar raderna fr�n User
//       
    }

    public DefaultTableModel fyll(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();

		//k�r igenom metadatan (ex hur m�nga columner, och h�mtar namnen)
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
