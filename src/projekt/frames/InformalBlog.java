/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import projekt.User;
import projekt.helpers.Database;
import projekt.frames.FormalBlog;


/**
 *
 * @author Amand
 */
public class InformalBlog extends javax.swing.JFrame {

    /**
     * Creates new form InformalBlog
     */
    private User user;


    
    public InformalBlog(User user){

        
        this.user = user;
        initComponents();
        
        try{
        String query = "SELECT  title , timeStamp, description, postID FROM Post";
        String joinQuery = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.timeStamp FROM User, Post WHERE Post.UserID = User.UserID AND TypeID = 2;";
	fillTable(Database.fetchRows(joinQuery));
        }
        catch(SQLException e){
            e.printStackTrace();
        }

		
        
    }
    
    public void fillTable(ResultSet rs)
	{
		try {
                    jTable1 = new JTable (FormalBlog.tableModelBuilder(rs));
                       
		} catch(SQLException e) {
                    e.printStackTrace();
		}

		
		jScrollPane1.setViewportView(jTable1);
		jTable1.setVisible(true);
		//K�r emot Databasen och h�mtar raderna fr�n User
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
        jbCreatePost = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBShowPost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jbCreatePost.setText("Skapa inl�gg");
        jbCreatePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreatePostActionPerformed(evt);
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBShowPost.setText("Visa inl�gg");
        jBShowPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBShowPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCreatePost, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBShowPost)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBack)
                    .addComponent(jbCreatePost)
                    .addComponent(jBShowPost))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    private void jbCreatePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreatePostActionPerformed
        // TODO add your handling code here:
        new MakeInformalPost(user).setVisible(true);
    }//GEN-LAST:event_jbCreatePostActionPerformed

    private void jBShowPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBShowPostActionPerformed

    int id = (int) (jTable1.getValueAt(jTable1.getSelectedRow(), 0));
    new ShowPost(id).setVisible(true);
		
    }//GEN-LAST:event_jBShowPostActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBShowPost;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCreatePost;
    // End of variables declaration//GEN-END:variables
}
