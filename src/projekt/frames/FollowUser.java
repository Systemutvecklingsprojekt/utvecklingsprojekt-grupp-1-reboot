
package projekt.frames;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import projekt.Refactor;
import projekt.User;
import projekt.helpers.Database;


public class FollowUser extends javax.swing.JFrame {

    private User user;
    private int userSubscriberId;
    private int userCreatorId;


    public FollowUser(User user) {
        initComponents();
        this.user = user;
        userSubscriberId = user.getUserID();

        try {
            String allQuery = "SELECT UserID, firstName, lastName FROM User where UserID <>  11 AND UserID <> " + userSubscriberId;
            String followQuery = "SELECT UserCreatorID, firstName, lastName FROM UserPrem JOIN User ON UserPrem.UserCreatorID = User.UserID WHERE UserSubscriberID = " + userSubscriberId;

            fillAllUsers(Database.fetchRows(allQuery));
            fillFollowing(Database.fetchRows(followQuery));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void fillAllUsers(ResultSet rs) {
        try {
            jTAllUsers = new JTable(Refactor.tableModelBuilder(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jspAllUsers.setViewportView(jTAllUsers);
        jTAllUsers.setVisible(true);
    }

    public void fillFollowing(ResultSet rs) {
        try {
            jTFollowing = new JTable(Refactor.tableModelBuilder(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jspFollowing.setViewportView(jTFollowing);
        jTFollowing.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspAllUsers = new javax.swing.JScrollPane();
        jTAllUsers = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jspFollowing = new javax.swing.JScrollPane();
        jTFollowing = new javax.swing.JTable();
        jBFollow = new javax.swing.JButton();
        jBUnfollow = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTAllUsers.setModel(new javax.swing.table.DefaultTableModel(
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
        jspAllUsers.setViewportView(jTAllUsers);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Alla användare");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Användare du följer");

        jTFollowing.setModel(new javax.swing.table.DefaultTableModel(
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
        jspFollowing.setViewportView(jTFollowing);

        jBFollow.setBackground(new java.awt.Color(204, 204, 255));
        jBFollow.setText("Följ användare");
        jBFollow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFollowActionPerformed(evt);
            }
        });

        jBUnfollow.setBackground(new java.awt.Color(204, 204, 255));
        jBUnfollow.setText("Avfölj användare");
        jBUnfollow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUnfollowActionPerformed(evt);
            }
        });

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspAllUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspFollowing, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jBFollow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jBUnfollow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspAllUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBFollow)
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspFollowing, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBUnfollow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    /**
     * Denna knapp hämtar infomation från vald användare och lägger till det i en annan följ-tabell i databasen.
     * jFramen öppnas på nytt för att uppdateras.
     * @param evt 
     */
    
    private void jBFollowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFollowActionPerformed
        try {
            userCreatorId = (int) Refactor.getTableValueFirstColumn(jTAllUsers);
            String sqlTempId = "SELECT UserCreatorID FROM UserPrem WHERE UserCreatorID = " + userCreatorId + " AND UserSubscriberID = " + userSubscriberId;
            System.out.println(Database.fetchSingle(sqlTempId));
            String tempId = Database.fetchSingle(sqlTempId);
            String firstName = Database.fetchSingle("SELECT firstName FROM User WHERE UserID = " + userCreatorId);

            if (tempId == null) {
                String insertQuery = "INSERT INTO UserPrem (UserSubscriberID, UserCreatorID) VALUES (" + userSubscriberId + ", " + userCreatorId + " )";
                Database.executeUpdate(insertQuery);
                JOptionPane.showMessageDialog(null, "Du följer nu " + firstName + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Du följer redan " + firstName + "!");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Var vänlig markera en användare");
        } catch (SQLException ex) {
            System.out.println("fel");
            Logger.getLogger(FollowUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        new FollowUser(user).setVisible(true);
    }//GEN-LAST:event_jBFollowActionPerformed

    private void jBUnfollowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUnfollowActionPerformed
        userCreatorId = (int) Refactor.getTableValueFirstColumn(jTFollowing);
        System.out.println(userCreatorId);
        System.out.println(userSubscriberId);

        String deleteQuery = "DELETE FROM UserPrem WHERE UserSubscriberID = " + userSubscriberId + " AND UserCreatorID = " + userCreatorId;
        try {
            String firstName = Database.fetchSingle("SELECT firstName FROM User WHERE UserID = " + userCreatorId);
            Database.executeUpdate(deleteQuery);
            JOptionPane.showMessageDialog(null, "Du har nu avföljt " + firstName + "!");
            this.dispose();
            new FollowUser(user).setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Var vänlig markera en användare");
        }
    }//GEN-LAST:event_jBUnfollowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBFollow;
    private javax.swing.JButton jBUnfollow;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTAllUsers;
    private javax.swing.JTable jTFollowing;
    private javax.swing.JScrollPane jspAllUsers;
    private javax.swing.JScrollPane jspFollowing;
    // End of variables declaration//GEN-END:variables
}
