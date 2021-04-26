package projekt.frames;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import projekt.Refactor;
import projekt.helpers.Database;

public class CurrentMeeting extends javax.swing.JFrame {

    private int MeetingID;
    private String day;

    public CurrentMeeting(String day) {
        this.day = day;
        String query = "SELECT  MeetingID, Date, Time, Description, UserID FROM Meeting where Date = '" + day + "'";
        initComponents();

        try {
            fillTable(Database.fetchRows(query));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fyller tabell med aktuella möten. Vid klick öppnas det mötet man valt
     *
     * @param rs
     */
    public void fillTable(ResultSet rs) {
        try {
            jTMeeting = new JTable(Refactor.tableModelBuilder(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jScrollPane1.setViewportView(jTMeeting);
        jTMeeting.setVisible(true);
        jTMeeting.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting()) {

                } else {
                    int id = (int) (jTMeeting.getValueAt(jTMeeting.getSelectedRow(), 0));
                    new ShowMeeting(id).setVisible(true);
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTMeeting = new javax.swing.JTable();
        jBBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTMeeting.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTMeeting);

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
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBBack, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMeeting;
    // End of variables declaration//GEN-END:variables
}
