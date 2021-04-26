package projekt.frames;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import projekt.User;
import java.sql.*;
import javax.swing.JTable;
import projekt.helpers.Database;
import projekt.Refactor;

public class PersonalMeetings extends javax.swing.JFrame {

    private User user;
    private ResultSet rs;
    private javax.swing.JTable table2;

    public PersonalMeetings(User user) {
        initComponents();

        this.user = user;
        jbNewMeeting.setVisible(true);
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Mina inbokade möten");
        jComboBox1.addItem("Mina mötesinbjudningar");
        jComboBox1.addItem("Mina mötesutskick");
    }
    
    /**
     * Metod för att tillåta användaren att direkt få upp ett nytt fönster vid musklick på en rad i tabellen.
     */
    private void initTableListener() {
        if (table2 != null) {
            table2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int id = (int) (table2.getValueAt(table2.getSelectedRow(), 0));
                        new MeetingVotes(id, user).setVisible(true);
                    }
                }
            });
        } else {
            System.out.println("projekt.frames.PersonalMeetings.initTableListener(): table2 is Null");
        }
    }

    /**
     * Metod för att fylla tabellen med inbokade möten.
     */
    private void fillBooked() {
        try {
            rs = Database.fetchRows("SELECT DISTINCT * from Meeting where MeetingID IN (Select MeetingID from Meeting_Attandence where UserID =" + user.getUserID() + " AND isAttending = 'J')");
            table2 = new JTable(Refactor.tableModelBuilder(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jScrollPane1.setViewportView(table2);
        table2.setVisible(true);
        if (table2 != null) {
            table2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int id = (int) (table2.getValueAt(table2.getSelectedRow(), 0));
                        new ShowMeeting(id).setVisible(true);
                    }
                }
            });
        } else {
            System.out.println("table2 is Null");
        }
        
    }

    /**
     * Metod för att fylla tabellen med mötesinbjudningar
     */
    private void fillInvites() {
        try {
            rs = Database.fetchRows("SELECT DISTINCT Proposed_Date_Time.ProsedMeetingID, Proposed_Meeting.Description \n"
                    + "FROM Proposed_Date_Time\n"
                    + "JOIN Proposed_Meeting ON Proposed_Date_Time.ProsedMeetingID = Proposed_Meeting.ProposedMeetingID\n"
                    + "JOIN Invites ON Proposed_Meeting.ProposedMeetingID = Invites.ProposedMeeting\n"
                    + "WHERE UserID = " + user.getUserID());
            table2 = new JTable(Refactor.tableModelBuilder(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jScrollPane1.setViewportView(table2);
        table2.setVisible(true);
        initTableListener();
    }

    /**
     * Metod för att fylla tabellen med mötesutskick
     */
    private void fillHostInvites() {
        try {
            rs = Database.fetchRows("SELECT Proposed_Meeting.ProposedMeetingID, Proposed_Date_Time.Date, Proposed_Date_Time.Time, Proposed_Meeting.Name, Proposed_Meeting.Description \n"
                    + " FROM Proposed_Date_Time\n"
                    + " JOIN Proposed_Meeting ON Proposed_Date_Time.ProsedMeetingID = Proposed_Meeting.ProposedMeetingID\n"
                    + " WHERE UserCreatorID = " + user.getUserID() + "\n"
                    + " GROUP BY ProposedMeetingID;");
            table2 = new JTable(Refactor.tableModelBuilder(rs));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jScrollPane1.setViewportView(table2);
        table2.setVisible(true);
        if (table2 != null) {
            table2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int id = (int) (table2.getValueAt(table2.getSelectedRow(), 0));
                        System.out.println(id);
                        new ShowMeetingVotes(id, user).setVisible(true);
                    }
                }
            });
        } else {
            System.out.println("projekt.frames.PersonalMeetings.fillHostInvites(): table2 is Null");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBBack = new javax.swing.JButton();
        jbNewMeeting = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jbNewMeeting.setBackground(new java.awt.Color(204, 204, 255));
        jbNewMeeting.setText("Skapa nytt möte");
        jbNewMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewMeetingActionPerformed(evt);
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
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)
                        .addComponent(jbNewMeeting))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBack)
                    .addComponent(jbNewMeeting))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    private void jbNewMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewMeetingActionPerformed
        new NewMeeting(user).setVisible(true);
    }//GEN-LAST:event_jbNewMeetingActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        if (jComboBox1.getSelectedItem() == ("Mina inbokade möten")) {
            fillBooked();
        } else if (jComboBox1.getSelectedItem() == ("Mina mötesinbjudningar")) {
            fillInvites();
        } else if (jComboBox1.getSelectedItem() == ("Mina mötesutskick")) {
            fillHostInvites();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbNewMeeting;
    // End of variables declaration//GEN-END:variables
}
