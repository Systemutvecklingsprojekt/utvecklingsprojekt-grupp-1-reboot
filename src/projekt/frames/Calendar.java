package projekt.frames;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import projekt.helpers.Database;
import java.sql.ResultSet;
import javax.swing.JTable;
import projekt.Refactor;

public class Calendar extends javax.swing.JFrame {

    public Calendar() {
        initComponents();

        try {
            String query = "SELECT Date, COUNT(Description) as antalMöten FROM Meeting GROUP BY Date";

            fillDates(Database.fetchRows(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBBack = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jspDates = new javax.swing.JScrollPane();
        jTDates = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jBShowMeeting = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jTDates.setModel(new javax.swing.table.DefaultTableModel(
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
        jTDates.setShowVerticalLines(false);
        jspDates.setViewportView(jTDates);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Möten:");

        jBShowMeeting.setBackground(new java.awt.Color(204, 204, 255));
        jBShowMeeting.setText("Visa alla möten");
        jBShowMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBShowMeetingActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Visa möten för vald dag");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jspDates, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jBShowMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspDates, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBShowMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * fyller tabellen under kalender med data. Det som displayas i tabellen är
     * antal möten på specifika dagar.
     *
     * @param rs
     */
    public void fillDates(ResultSet rs) {
        try {
            jTDates = new JTable(Refactor.tableModelBuilder(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jspDates.setViewportView(jTDates);
        jTDates.setVisible(true);

        jTDates.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    Date date = (Date) jTDates.getValueAt(jTDates.getSelectedRow(), 0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

                    String dateString = format1.format(date);
                    new CurrentMeeting(dateString).setVisible(true);
                }
            }
        });

    }

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBShowMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBShowMeetingActionPerformed
        try {
            String query = "SELECT Date, COUNT(Description) as antalMöten FROM Meeting GROUP BY Date";
            fillDates(Database.fetchRows(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBShowMeetingActionPerformed

    /**
     * Knappen/metoden hämtar möten för dagen man väljer i kalendern och
     * displayar enbart möten för den dagen i tabellen.
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date day = jCalendar1.getDate();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = format1.format(day);
        try {
            String sqlQuery = "SELECT MeetingID, Date, Description from Meeting where Date = '" + date1 + "'";
            ResultSet rs1 = Database.fetchRows(sqlQuery);
            jTDates = new JTable(Refactor.tableModelBuilder(rs1));
            jspDates.setViewportView(jTDates);
            jTDates.setVisible(true);
            jTDates.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int meetingId = Refactor.getTableValueFirstColumn(jTDates);
                        new ShowMeeting(meetingId).setVisible(true);
                    }
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBShowMeeting;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTDates;
    private javax.swing.JScrollPane jspDates;
    // End of variables declaration//GEN-END:variables
}
