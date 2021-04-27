/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import javax.swing.table.DefaultTableModel;
import projekt.User;
import projekt.helpers.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import projekt.Refactor;

/**
 *
 * @author Amand
 */
public class HomeScreen extends javax.swing.JFrame {

    private int id;
    private String firstName;
    private String lastName;
    private User user;

    /**
     * Creates new form Homescreen
     */
    public HomeScreen(int id) {
        initComponents();
        jBAdminUsers.setVisible(false);
        this.id = id;
        this.user = new User(this.id);
        //checkNotis();
        adminCheck();
        lblWelcome.setText("V�LKOMMEN: " + user.getFirstName() + " " + user.getLastName() + "!");

        jComboBox1.removeAllItems();
        jComboBox1.addItem("M�ten");
        jComboBox1.addItem("Inl�gg");
        jComboBox1.addItem("F�reslagna m�ten");
    }

    public void checkStatement() {
       try {
        if (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 3).equals("Meeting")) {
            int id = (int) (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 0));
           int open = Integer.parseInt(Database.fetchSingle("Select MID from Meeting_Notice where NID =" + id));
            new ShowMeeting(open).setVisible(true);
        }

        if (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 3).equals("Post")) {
            int id = (int) (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 0));
            int open = Integer.parseInt(Database.fetchSingle("Select PID from Notice_Post where NID =" + id));
            new ShowPost(this.user, open).setVisible(true);
        }

        if (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 3).equals("ProposedMeeting")) {
            int id = (int) (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 0));
            new PersonalMeetings(this.user).setVisible(true);
        } }
       catch (Exception e) {
           System.out.println("kan ej �ppna r�tt sak");
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

        jBFormal = new javax.swing.JButton();
        jBInformal = new javax.swing.JButton();
        jBMeetings = new javax.swing.JButton();
        jBProfile = new javax.swing.JButton();
        jBAdminUsers = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jBsearch = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jBSignOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNotifications = new javax.swing.JTable();
        jlblNotiser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jBCalendar = new javax.swing.JButton();
        jBclearNotifications = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBFormal.setBackground(new java.awt.Color(204, 204, 255));
        jBFormal.setText("Formell blogg");
        jBFormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFormalActionPerformed(evt);
            }
        });

        jBInformal.setBackground(new java.awt.Color(204, 204, 255));
        jBInformal.setText("Informell blogg");
        jBInformal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInformalActionPerformed(evt);
            }
        });

        jBMeetings.setBackground(new java.awt.Color(204, 204, 255));
        jBMeetings.setText("M�ten");
        jBMeetings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMeetingsActionPerformed(evt);
            }
        });

        jBProfile.setBackground(new java.awt.Color(204, 204, 255));
        jBProfile.setText("Profil");
        jBProfile.setToolTipText("");
        jBProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProfileActionPerformed(evt);
            }
        });

        jBAdminUsers.setBackground(new java.awt.Color(204, 204, 255));
        jBAdminUsers.setText("Hantera anv�ndare");
        jBAdminUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdminUsersActionPerformed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lblSearch.setText("*S�k efter nyckelord i inl�gg");

        jBsearch.setBackground(new java.awt.Color(204, 204, 255));
        jBsearch.setText("S�k");
        jBsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsearchActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblWelcome.setText("V�LKOMMEN");

        jBSignOut.setBackground(new java.awt.Color(204, 204, 255));
        jBSignOut.setText("Logga ut");
        jBSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSignOutActionPerformed(evt);
            }
        });

        jTNotifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NotisID", "Text", "Typ", "Skapad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTNotifications);

        jlblNotiser.setText("Notiser:");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("F�lj anv�ndare");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M�ten", "Inl�gg\t" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jBCalendar.setBackground(new java.awt.Color(204, 204, 255));
        jBCalendar.setText("Kalender");
        jBCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalendarActionPerformed(evt);
            }
        });

        jBclearNotifications.setBackground(new java.awt.Color(204, 204, 255));
        jBclearNotifications.setText("Rensa notiser");
        jBclearNotifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBclearNotificationsActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfSearch)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jBCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jBFormal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBInformal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jBProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jBAdminUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(lblWelcome)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jBSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblNotiser)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jBclearNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jlblNotiser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBclearNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcome)
                .addGap(36, 36, 36)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsearch))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBFormal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBInformal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jBSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jBAdminUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBFormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFormalActionPerformed
        new Blog(user, true).setVisible(true);

    }//GEN-LAST:event_jBFormalActionPerformed

    private void jBInformalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInformalActionPerformed
        new Blog(user, false).setVisible(true);


    }//GEN-LAST:event_jBInformalActionPerformed

    private void jBMeetingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMeetingsActionPerformed
        new PersonalMeetings(user).setVisible(true);
    }//GEN-LAST:event_jBMeetingsActionPerformed

    private void jBProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProfileActionPerformed
        new Profile(id, user).setVisible(true);
    }//GEN-LAST:event_jBProfileActionPerformed

    private void jBAdminUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdminUsersActionPerformed

        new ManageUsers().setVisible(true);
    }//GEN-LAST:event_jBAdminUsersActionPerformed

    private void jBsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsearchActionPerformed

        new Blog(jtfSearch.getText().toLowerCase(), user).setVisible(true);
    }//GEN-LAST:event_jBsearchActionPerformed

    private void jBSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSignOutActionPerformed
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBSignOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new FollowUser(user).setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            if (jComboBox1.getSelectedItem() == ("M�ten")) {
                fillNotifications(1);
            }
            if (jComboBox1.getSelectedItem() == ("Inl�gg")) {
                jTNotifications.clearSelection();
                fillNotifications(2);
            }
            if (jComboBox1.getSelectedItem() == ("F�reslagna m�ten")) {
                jTNotifications.clearSelection();
                fillNotifications(3);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jBCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalendarActionPerformed
        new Calendar().setVisible(true);
    }//GEN-LAST:event_jBCalendarActionPerformed

    private void jBclearNotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBclearNotificationsActionPerformed
        int tempUserId = user.getUserID();
        int dialog1 = JOptionPane.showConfirmDialog(null, "Vill du rensa alla notiser?");

        if (dialog1 == JOptionPane.YES_OPTION) {
            String deleteQuery = "DELETE FROM User_Notice WHERE UID = " + tempUserId;
            try {
                Database.executeUpdate(deleteQuery);
                fillNotifications(1);

            } catch (SQLException ex) {
                Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBclearNotificationsActionPerformed

    private void adminCheck() {

        if (user.getAdmin().equals("J")) {
            jBAdminUsers.setVisible(true);
        }
    }

    public void fillNotifications(int notificationTypeId) {
        try {
            String check = Database.fetchSingle("Select NID from User_Notice where UID =" + id);
            ResultSet rs;

            rs = Database.fetchRows("SELECT NoticeID, Topic, DateTime, TypeName FROM Notice JOIN Notice_Type ON Notice.NoticeTypeID = Notice_Type.NoticeTypeID JOIN User_Notice ON Notice.NoticeID = User_Notice.NID WHERE UID = " + id + " AND Notice_Type.NoticeTypeID = " + notificationTypeId);
            DefaultTableModel dmb = Refactor.tableModelBuilder(rs);

            jTNotifications = new JTable(dmb);
            jScrollPane1.setViewportView(jTNotifications);
            jTNotifications.setVisible(true);
            jTNotifications.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (e.getValueIsAdjusting()) {

                    } else {

                        checkStatement();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTest(int notificationTypeId) {

        {

            try {
                ResultSet rs = Database.fetchRows("SELECT NoticeID, Topic, DateTime, TypeName FROM Notice JOIN Notice_Type ON Notice.NoticeTypeID = Notice_Type.NoticeTypeID JOIN User_Notice ON Notice.NoticeID = User_Notice.NID WHERE UID = " + id + " AND Notice_Type.NoticeTypeID = " + notificationTypeId);
                DefaultTableModel dmb = Refactor.tableModelBuilder(rs);
                dmb.getDataVector().removeAllElements();
                jTNotifications = new JTable(dmb);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            jScrollPane1.setViewportView(jTNotifications);
            jTNotifications.setVisible(true);
            if (jTNotifications.getRowCount() != 0) {
                jTNotifications.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        if (e.getValueIsAdjusting()) {

                        } else {
                            int id = (int) (jTNotifications.getValueAt(jTNotifications.getSelectedRow(), 0));

                            if (notificationTypeId == 1) {
                                new ShowMeeting(id).setVisible(true);
                            }
                            if (notificationTypeId == 2) {
                                new ShowPost(user, id).setVisible(true);
                            }
                        }
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Finns inga notiser att visa h�r!");
            }

        }
    }

    /*
    private void checkNotis() {
        try {
            String check = Database.fetchSingle("Select NID from User_Notice where UID =" + id);
            // if(check != null) {
            ArrayList<String> types = new ArrayList<>();
            ArrayList<String> date = new ArrayList<>();
            ArrayList<String> text = new ArrayList<>();
            ArrayList<String> NotisID = new ArrayList<>();
            ResultSet rs;

            //jontes efterblivna kommentarer :
//                        types = Database.fetchColumn("Select TypeName from Notice_Type where NoticeTypeID IN (Select NoticeTypeID from Notice where NoticeID IN(Select NID from User_Notice where UID =" + this.id + "))");
//                        date = Database.fetchColumn("Select DateTime from Notice where NoticeID IN(Select NID from User_Notice where UID =" + id+ ")");
//                        text = Database.fetchColumn("Select Topic from Notice where NoticeID IN(Select NID from User_Notice where UID =" + id+ ")");
//                        NotisID = Database.fetchColumn("Select NoticeID from Notice where NoticeID in (Select NID from User_Notice Where UID =" + id + ")");
            rs = Database.fetchRows("SELECT NoticeID, Topic, DateTime, TypeName FROM Notice JOIN Notice_Type ON Notice.NoticeTypeID = Notice_Type.NoticeTypeID JOIN User_Notice ON Notice.NoticeID = User_Notice.NID WHERE UID = " + id);
            DefaultTableModel dmb = Refactor.tableModelBuilder(rs);
            jTNotifications = new JTable(dmb);
            jScrollPane1.setViewportView(jTNotifications);
            jTNotifications.setVisible(true);
            jTNotifications.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (e.getValueIsAdjusting()) {

                    } else {

                        checkStatement();
                    }
                }
            });

            //  DefaultTableModel model = (DefaultTableModel) jTableNotiser.getModel();
            //model.addRow(new Object[]{null, beskrivning, startTid, meetingDate});     
            //Database.fetchSingle("Select MeetingID from Meeting where NotisID =" + check); //h�mta specifika m�ten, loop?
            //Database.fetchSingle("Select PostID from Post where NotisID =" + check ); // H�mta specifika posts
            //Database.executeUpdate("Delete from Notiser where notisID =" + check); //Ta bort notiser, de har aviserats
            //Databasen , vettefan hur men p� n�got s�tt s�
            //table.getselectedValue(column med 1)
            //if(getSelectedValue type = 2/1)
            //getMeetingID->ShowMeeting(ID)
            //getPostID->sHOWPost(id);
            //St�rsta problemet: Kolla date/timestamp mot localdatetime - en tabell att f� ett RS av s� man slipper fetch single
            //Selecta vilka notiser man vill ha, m�ten/post mer? Remove knapp brevid?
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdminUsers;
    private javax.swing.JButton jBCalendar;
    private javax.swing.JButton jBFormal;
    private javax.swing.JButton jBInformal;
    private javax.swing.JButton jBMeetings;
    private javax.swing.JButton jBProfile;
    private javax.swing.JButton jBSignOut;
    private javax.swing.JButton jBclearNotifications;
    private javax.swing.JButton jBsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTNotifications;
    private javax.swing.JLabel jlblNotiser;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
