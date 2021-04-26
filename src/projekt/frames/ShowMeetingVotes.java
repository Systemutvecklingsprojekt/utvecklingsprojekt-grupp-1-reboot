////GEN-LINE:variables

package projekt.frames;

import javax.swing.JTable;
import projekt.Refactor;
import projekt.User;
import projekt.helpers.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ShowMeetingVotes extends javax.swing.JFrame {

    private int proposedMeetingID;
    private User user;
    private javax.swing.JTable table2;

    public ShowMeetingVotes(int proposedMeetingID, User user) {

        initComponents();
        this.proposedMeetingID = proposedMeetingID;
        this.user = user;
        insertValues();

    }

    private void insertValues() {
        try {
            String query = "";

            ResultSet rs = Database.fetchRows("select COUNT(uv.UserID) AS Röster,\n"
                    + " CONCAT(pdt.Date) AS Datum,\n"
                    + " CONCAT(pdt.Time) AS Tid,\n"
                    + " CONCAT(pdt.DateTimeID) AS Mötesnummer\n"
                    + " from user_votes uv\n"
                    + " RIGHT JOIN Proposed_Date_Time pdt ON uv.DateTimeID = pdt.DateTimeID\n"
                    + " JOIN Proposed_Meeting pm ON pdt.ProsedMeetingID = pm.ProposedMeetingID\n"
                    + " WHERE pm.ProposedMeetingID = " + proposedMeetingID + "\n"
                    + " group by pdt.DateTimeID;");
            table2 = new JTable(Refactor.tableModelBuilder(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jScrollPane1.setViewportView(table2);
        table2.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTMeetingTimes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jBDetermineMeeting = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTMeetingTimes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTMeetingTimes);

        jLabel1.setText("Välj vilket möte du vill fastställa");

        jBDetermineMeeting.setBackground(new java.awt.Color(204, 204, 255));
        jBDetermineMeeting.setText("Fastställ möte");
        jBDetermineMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetermineMeetingActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBDetermineMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDetermineMeeting)
                    .addComponent(jBBack))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>                        

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {                                       
        this.dispose();
    }                                      

    private void jBDetermineMeetingActionPerformed(java.awt.event.ActionEvent evt) {                                                   

        int dateTimeID = Integer.parseInt(table2.getValueAt(table2.getSelectedRow(), 3).toString());
        System.out.println(dateTimeID);
        ArrayList<Integer> userIDS = new ArrayList<>();
        String date = table2.getValueAt(table2.getSelectedRow(), 1).toString();
        
        try {
            String time = Database.fetchSingle("Select Time from Proposed_Date_Time where DateTimeID = " + dateTimeID);
            String description = Database.fetchSingle("Select Description from Proposed_Meeting where ProposedMeetingID = (Select ProsedMeetingID from Proposed_Date_Time where DateTimeID = " + dateTimeID + ")");
            Database.executeUpdate("Insert into Meeting (Date, Time, Description, UserID) values ('" + date + "', '" + time + "', '" + description + "', " + user.getUserID() + ")");
            int newMeetingID = Integer.parseInt(Database.fetchSingle("SELECT MAX(MeetingID) FROM Meeting"));
            ResultSet rs = Database.fetchRows("Select UserID from Invites where ProposedMeeting = " + proposedMeetingID);
            while (rs.next()) {
                userIDS.add(rs.getInt("UserID"));
            }
            for (Integer userID : userIDS) {
                Database.executeUpdate("Insert into Meeting_Attandence (UserID, MeetingID, IsAttending) values (" + userID + ", " + newMeetingID + ", 'J')");
            }
            notiser();
            deleteOldMeeting();
            JOptionPane.showMessageDialog(null, "Möte fastställt!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }                                                  

    private void deleteOldMeeting(){
        try {
            Database.executeUpdate("DELETE FROM Invites WHERE ProposedMeeting = " + proposedMeetingID + ";");
            Database.executeUpdate("DELETE FROM Proposed_Date_Time WHERE ProsedMeetingID = " + proposedMeetingID + ";");
            Database.executeUpdate("DELETE FROM Proposed_Meeting WHERE ProposedMeetingID = " + proposedMeetingID + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void notiser() {
        ArrayList invited;
        int dateTimeID = Integer.parseInt(table2.getValueAt(table2.getSelectedRow(), 3).toString());
        String dateTime =  LocalDateTime.now().toString();
        
        try{

            String name = Database.fetchSingle("Select Name from Proposed_Meeting where ProposedMeetingID = (Select ProsedMeetingID from Proposed_Date_Time where DateTimeID = " + dateTimeID + ")");
            Database.executeUpdate("Insert into Notice (Topic, DateTime, NoticeTypeID) VALUES ('" + name + "','" + dateTime + "', 1)");
            int meetingID = Integer.parseInt(Database.fetchSingle("SELECT MAX(MeetingID) FROM Meeting"));
            int notisID = Integer.parseInt(Database.fetchSingle("Select NoticeID from Notice Where NoticeID = (Select max(NoticeID) from Notice)"));
            Database.executeUpdate("Insert into Meeting_Notice (NID, MID) Values (" + notisID + "," + meetingID + ")");
            invited = Database.fetchColumn("Select UserID from Invites where ProposedMeeting= " + proposedMeetingID +";");
            
            for(int i = 0; i < invited.size(); i++) {
               int invID = Integer.parseInt(invited.get(i).toString());
               Database.executeUpdate("Insert into User_Notice (NID, UID) VALUES (" + notisID + "," + invID + ")");
           }
            int delNot = Integer.parseInt(Database.fetchSingle("Select NID from Notice_Proposed_Meeting where ProposedID =" + proposedMeetingID));
            Database.executeUpdate("Delete from Notice_Proposed_Meeting where NID =" + delNot);
            Database.executeUpdate("Delete from User_Notice where NID =" + delNot);
            Database.executeUpdate("Delete from Notice where NoticeID =" + delNot);
            
            
        }
        catch (Exception e) {
            System.out.println("satans sql notis");
        
        }
        
    }
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBDetermineMeeting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMeetingTimes;
    // End of variables declaration                   
}
