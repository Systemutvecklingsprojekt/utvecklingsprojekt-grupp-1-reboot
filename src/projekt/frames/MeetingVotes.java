/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import java.sql.SQLException;
import java.util.ArrayList;
import projekt.helpers.Database;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import projekt.User;

/**
 *
 * @author Amand
 */
public class MeetingVotes extends javax.swing.JFrame {

    private int proposedMeetingID;
    private static User user;
    private ArrayList<Integer> dateTimes;
    private ArrayList<String> votedTimeID;

    /**
     * Creates new form MeetingVotes
     */
    public MeetingVotes(int proposedMeetingID, User user) {
        this.proposedMeetingID = proposedMeetingID;
        this.user = user;
        initComponents();
        fillCBDate();
        dateTimes = new ArrayList<Integer>();
        getUserVotes();
    }

    private void getUserVotes() {
        this.votedTimeID = new ArrayList<>();
        try{
            votedTimeID = Database.fetchColumn("SELECT DateTimeID FROM user_votes where UserID = "+ user.getUserID());
        }catch(SQLException e){
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

        jCBDate = new javax.swing.JComboBox<>();
        jBAddTime = new javax.swing.JButton();
        jBSendAvailable = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCBTime = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAChosenTimes = new javax.swing.JTextArea();
        jBDeleteTime = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCBDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDateActionPerformed(evt);
            }
        });

        jBAddTime.setBackground(new java.awt.Color(204, 204, 255));
        jBAddTime.setText("L�gg till tid");
        jBAddTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddTimeActionPerformed(evt);
            }
        });

        jBSendAvailable.setBackground(new java.awt.Color(204, 204, 255));
        jBSendAvailable.setText("Skicka tillg�nglighet");
        jBSendAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSendAvailableActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Tillbaka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mina valda tider:");

        jTAChosenTimes.setEditable(false);
        jTAChosenTimes.setColumns(20);
        jTAChosenTimes.setRows(5);
        jScrollPane1.setViewportView(jTAChosenTimes);

        jBDeleteTime.setBackground(new java.awt.Color(204, 204, 255));
        jBDeleteTime.setText("Ta bort alla valda tider");
        jBDeleteTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteTimeActionPerformed(evt);
            }
        });

        jLabel2.setText("V�lj tillg�nlighet f�r m�te:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSendAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCBDate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCBTime, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBDeleteTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBAddTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAddTime)
                    .addComponent(jCBTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jBDeleteTime)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jBSendAvailable))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDateActionPerformed
        jCBTime.removeAllItems();
        fillCBTime();

    }//GEN-LAST:event_jCBDateActionPerformed

    private void jBAddTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddTimeActionPerformed
        String date = jCBDate.getSelectedItem().toString();
//        String time = jCBTime.getSelectedItem().toString();
    String id[] = date.split(",");
    boolean alreadyVoted = false;
    for(String ID: votedTimeID){
        try{
            if(ID.equals(id[0])){
                alreadyVoted = true;
            }
        } catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    if(alreadyVoted == false){
        dateTimes.add(Integer.parseInt(id[0]));
                String oldLabel = jTAChosenTimes.getText();
                jTAChosenTimes.setText(oldLabel +id[0] +": " + id[1] + ", " + id[2]+ "\n");
    } else {
         JOptionPane.showMessageDialog(null, "Du har redan r�stat p� denna m�testid");
    }
//        try {
//            String dateTime = Database.fetchSingle("Select DateTimeID from Proposed_Date_Time where Time = '" + time + "' and Date = '" + date + "'");
//            String query = "Select UserID, DateTimeID from user_votes where UserID = " + user.getUserID() + " and DateTimeID = " + dateTime;
//            query = Database.fetchSingle(query);
//            System.out.println(query);
//            if (query == null) {
//                dateTimes.add(Integer.parseInt(dateTime));
//                String oldLabel = jTAChosenTimes.getText();
//                jTAChosenTimes.setText(oldLabel + " " + date + " " + time + "\n");
//            } else {
//                JOptionPane.showMessageDialog(null, "Du har redan r�stat p� denna m�testid");
//
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println("errr");
//        }


    }//GEN-LAST:event_jBAddTimeActionPerformed

    private void jBSendAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSendAvailableActionPerformed

        ResultSet rs;
        
        String alreadyVoted = "SELECT UserID, DateTimeID, COUNT(*)\n" +
            " FROM user_votes\n" +
            " WHERE UserID = " + user.getUserID() + " AND DateTimeID = " + proposedMeetingID + "\n" +
            " GROUP BY UserID, DateTimeID\n" +
            " HAVING COUNT(*) > 1;";
        try {
            rs = Database.fetchRows(alreadyVoted);
            
            if(rs.next() == false) {
                
                for(Integer dateTime : dateTimes){
                    
                    Database.executeUpdate("INSERT INTO user_votes (UserID, DateTimeID) VALUES (" + user.getUserID() + ", " + dateTime + ");");
                    
                }
                JOptionPane.showMessageDialog(null, "Dina tider �r skickade till m�tesv�rden!");
            } else {
                JOptionPane.showMessageDialog(null, "Du har redan anm�lt dig till detta m�te!");
            }
            Database.executeUpdate("DELETE FROM Invites WHERE UserID = " + user.getUserID() + " AND ProposedMeeting = " + proposedMeetingID + ";");
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");

        }
    }//GEN-LAST:event_jBSendAvailableActionPerformed

    private void jBDeleteTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteTimeActionPerformed
        jTAChosenTimes.setText("");
        dateTimes.removeAll(dateTimes);
    }//GEN-LAST:event_jBDeleteTimeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    

    private void fillCBDate() {

        String query = "Select CONCAT(DateTimeID,', ',Date,', ',Time) from Proposed_Date_Time where ProsedMeetingID = " + proposedMeetingID;
        ArrayList<String> dates = new ArrayList<>();
        try {
            ResultSet rs = Database.fetchRows(query);
            while (rs.next()) {
                dates.add(rs.getString(1));
            }
            for (String date : dates) {
                jCBDate.addItem(date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fillCBTime() {
        String date = jCBDate.getSelectedItem().toString();
        String query = "Select Distinct Time from Proposed_Date_Time where ProsedMeetingID = " + proposedMeetingID + " and Date = '" + date + "'";

        ArrayList<String> times = new ArrayList<>();
        try {
            ResultSet rs = Database.fetchRows(query);
            while (rs.next()) {
                times.add(rs.getString(1));
            }
            for (String time : times) {
                jCBTime.addItem(time);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddTime;
    private javax.swing.JButton jBDeleteTime;
    private javax.swing.JButton jBSendAvailable;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBDate;
    private javax.swing.JComboBox<String> jCBTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAChosenTimes;
    // End of variables declaration//GEN-END:variables
}
