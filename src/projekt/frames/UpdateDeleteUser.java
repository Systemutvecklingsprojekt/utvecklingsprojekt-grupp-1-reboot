package projekt.frames;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import projekt.helpers.Database;
import projekt.Refactor;

public class UpdateDeleteUser extends javax.swing.JFrame {

    ResultSet rs;
    private javax.swing.JTable table2;

    public UpdateDeleteUser() {

        initComponents();

        getResultset();
        try {
            table2 = new JTable(Refactor.tableModelBuilder(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jScrollPane1.setViewportView(table2);
        table2.setVisible(true);
    }

    public void getResultset() {
        //K?r emot Databasen och h?mtar raderna fr?n User
        try {
            rs = Database.fetchRows("SELECT CONCAT(UserID) as ID, CONCAT(firstName, ' ', lastName) as Namn,CONCAT(eMail) as Epost, CONCAT(adminStatus) AS Admin FROM User;");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        changeInformationButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Firstname", "Lastname", "Email", "Password", "Adminstatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        deleteButton.setBackground(new java.awt.Color(204, 204, 255));
        deleteButton.setText("Ta bort");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        changeInformationButton.setBackground(new java.awt.Color(204, 204, 255));
        changeInformationButton.setText("?ndra information");
        changeInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInformationButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel1.setText("*V?nligen marker en anv?ndare du vill ta bort eller ?ndra");

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Uppdatera och ta bort en anv?ndare");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(changeInformationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(changeInformationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Skapar variabler av alla SQL-fr?gor som beh?vs n?r en anv?ndare ska tas bort. I try:en k?rs dessa fr?gor och tar bort data
 * i databasen fr?n den valda anv?ndaren.
 * @param evt 
 */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int userID = -1;
        try {
            userID = (int) Refactor.getTableValueFirstColumn(table2);
            String namn = Database.fetchSingle("Select firstName from User where UserID = " + userID + ";") + " " + Database.fetchSingle("Select lastName from User where UserID = " + userID + ";");

            if (true) {
                String updatePost = "Update Post SET UserID = 11 Where UserID = " + userID;
                String delUser = "Delete from User where UserID =" + userID;
                String delMeeting = "Delete from Meeting where UserID =" + userID;
                String delMetAt = "Delete from Meeting_Attandence where UserID =" + userID;
                String delPost = "Delete from Post where UserID =" + userID;
                String delCom = "Delete from Comments where UserID =" + userID;
                String updatCom = "Update Comments Set UserID = 11 Where UserID = " + userID;

                String updateCommentLikes = "Update Comment_Likes SET UserID = 11 WHERE UserID = " + userID;
                String delInvites = "Delete from Invites WHERE UserID = " + userID;
                String updatePostLikes = "UPDATE Post_Likes SET UserID = 11 WHERE UserID = " + userID;
                String selectPmId = "SELECT ProposedMeetingID FROM Proposed_Meeting WHERE UserCreatorID = " + userID;
                String deleteProposedMeeting = "DELETE FROM Proposed_Meeting WHERE UserCreatorID = " + userID;
                String deleteUserVotes = "DELETE FROM user_votes WHERE UserID = " + userID;
                String deleteUserNotice = "DELETE FROM User_Notice WHERE UID = " + userID;
                String deleteUserPrem = "DELETE FROM UserPrem WHERE UserCreatorID = " + userID;
                String deleteUserprem2 = "DELETE FROM UserPrem WHERE UserSubscriberID = " + userID;

                if (idKoll() == false) {
                    return;
                }

                int dialog2 = JOptionPane.showConfirmDialog(null, "Vill du spara " + namn + " inl?gg?");

                try {

                    if (dialog2 == JOptionPane.YES_OPTION) {
                        Database.executeUpdate(updatePost);//set posts ownership to deleted user
                        Database.executeUpdate(updatCom);
                        Database.executeUpdate(delMetAt);
                        Database.executeUpdate(delMeeting);

                        Database.executeUpdate(updateCommentLikes);
                        Database.executeUpdate(delInvites);
                        Database.executeUpdate(updatePostLikes);
                        String sqlSelect = Database.fetchSingle(selectPmId);
                        Database.executeUpdate("DELETE FROM Proposed_Date_Time WHERE ProsedMeetingID = " + sqlSelect);
                        Database.executeUpdate(deleteProposedMeeting);
                        Database.executeUpdate(deleteUserVotes);
                        Database.executeUpdate(deleteUserNotice);
                        Database.executeUpdate(deleteUserPrem);
                        Database.executeUpdate(deleteUserprem2);

                        Database.executeUpdate(delUser);

                        JOptionPane.showMessageDialog(null, "Anv?ndaren ?r nu borttagen");
                        new UpdateDeleteUser().setVisible(true);
                        this.dispose();

                    } else if (dialog2 == JOptionPane.NO_OPTION) {
                        Database.executeUpdate("DELETE FROM Post_Tag WHERE PostID in (SELECT PostID FROM Post WHERE UserID = " + userID + ")");
                        Database.executeUpdate(delCom);
                        Database.executeUpdate(delPost);
                        Database.executeUpdate(delMetAt);
                        Database.executeUpdate(delMeeting);

                        Database.executeUpdate(updateCommentLikes);
                        Database.executeUpdate(delInvites);
                        Database.executeUpdate(updatePostLikes);
                        String sqlSelect = Database.fetchSingle(selectPmId);
                        Database.executeUpdate("DELETE FROM Proposed_Date_Time WHERE ProsedMeetingID = " + sqlSelect);
                        Database.executeUpdate(deleteProposedMeeting);
                        Database.executeUpdate(deleteUserVotes);
                        Database.executeUpdate(deleteUserNotice);
                        Database.executeUpdate(deleteUserPrem);
                        Database.executeUpdate(deleteUserprem2);

                        Database.executeUpdate(delUser);

                        JOptionPane.showMessageDialog(null, "Anv?ndaren och dess inl?gg ?r nu borttagna");
                        new UpdateDeleteUser().setVisible(true);
                        this.dispose();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Var v?nlig markera en anv?ndare");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
/**
 * H?mtar v?rde fr?n tabell ang?ende vald anv?ndare f?r att ?ppna rutan f?r redigering av anv?ndaren.
 * @param evt 
 */
    private void changeInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInformationButtonActionPerformed
        int userID = -1;
        try {
            userID = (int) Refactor.getTableValueFirstColumn(table2);
            new EditUsers(userID).setVisible(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Var v?nlig markera en anv?ndare");
        }
    }//GEN-LAST:event_changeInformationButtonActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed
/**
 * Kontrollerar att man valt en anv?ndare
 * Kontrollerar vald anv?ndare
 * @return 
 */
    private boolean idKoll() {

        try {
            int userID = (int) Refactor.getTableValueFirstColumn(table2);

            String validId = Database.fetchSingle("SELECT UserID FROM User WHERE UserID =" + userID);
            if (validId == null) {
                JOptionPane.showMessageDialog(null, "Var god ange ett giltigt UserID!");
                new UpdateDeleteUser().setVisible(true);
                this.dispose();
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Var v?nlig markera en anv?ndare");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeInformationButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jBBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
