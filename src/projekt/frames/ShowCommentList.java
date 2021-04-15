/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import projekt.User;
import projekt.helpers.Database;
import projekt.Refactor;

/**
 *
 * @author anton
 */
public class ShowCommentList extends javax.swing.JFrame {

    User user;

    /**
     * Creates new form ShowComments
     */
    public ShowCommentList(User user) {
        initComponents();
        this.user = user;

    }

    public ShowCommentList(int id) {
        initComponents();

        try {
            String joinQuery = "SELECT CommentID, firstName, lastName, Comments.timeStamp, Text FROM User JOIN Comments ON User.UserID = Comments.UserID WHERE PostID =" + id;

            fillTable(Database.fetchRows(joinQuery));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillTable(ResultSet rs) {
        try {
            jTableComments = new JTable(Refactor.tableModelBuilder(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jspComments.setViewportView(jTableComments);
        jTableComments.setVisible(true);
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

        jspComments = new javax.swing.JScrollPane();
        jTableComments = new javax.swing.JTable();
        jbShowComment = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jspComments.setViewportView(jTableComments);

        jbShowComment.setText("Visa kommentar");
        jbShowComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowCommentActionPerformed(evt);
            }
        });

        jbBack.setText("Tillbaka");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbShowComment)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jspComments, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspComments, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbShowComment)
                    .addComponent(jbBack))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbShowCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowCommentActionPerformed
        try {

            int id = (int) (jTableComments.getValueAt(jTableComments.getSelectedRow(), 0));
            new ShowComment(id).setVisible(true);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "V�nligen v�lj ett inl�gg att visa!");

        }
    }//GEN-LAST:event_jbShowCommentActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTableComments;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbShowComment;
    private javax.swing.JScrollPane jspComments;
    // End of variables declaration//GEN-END:variables

}
