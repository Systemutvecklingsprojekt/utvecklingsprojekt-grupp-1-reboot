/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import projekt.User;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projekt.helpers.Database;
import projekt.helpers.Validation;
import projekt.Refactor;

/**
 *
 * @author jonat
 */
public class NewMeeting extends javax.swing.JFrame {
    
    private ArrayList<String> pers;
    private ArrayList<String> dbPers;
    private User user;
    private int creatorID;

    /**
     * Creates new form NewMeeting
     */
    public NewMeeting(User user) {
        initComponents();
        this.user = user;
        creatorID = this.user.getUserID();
        jComboPers.removeAllItems();
        pers = getArrayPers();
        jDateChooser1.setEnabled(false);
        jDateChooser1.getCalendarButton().setEnabled(true);
        jTimeStart.setText("00.00");
        jTimeStart.setEnableArrowKeys(true);
        

        fyllCombo();
        
    }
    
    private ArrayList<String> getArrayPers() {
        
        ArrayList<String> pers = null;
        try {
            String logInMail = Database.fetchSingle("Select email from User WHERE userID = " + creatorID + "");

            pers = Database.fetchColumn("Select email from User WHERE NOT email = 'DELETEDUSER' AND NOT email= '" + logInMail +"'");
            return pers;
        } catch (Exception e) {
            System.out.println("feeeeel arraylist personer");
        }
        return pers;
    }
    
    private void fyllCombo() {
        for (String pers : pers) {
            
            jComboPers.addItem(pers);
            
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jlblInfo = new javax.swing.JLabel();
        jlblBeskriv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtDesc = new javax.swing.JTextArea();
        jLblTime = new javax.swing.JLabel();
        jlblDatum = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jBtnSkapaM�te = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMeeting = new javax.swing.JTable();
        jComboPers = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePers = new javax.swing.JTable();
        jBtnSkicka = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBAddPers = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTxtNamn = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTimeStart = new com.github.lgooddatepicker.components.TimePicker();
        jBRemovePers = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlblInfo.setText("Skapa m�tesf�rslag");

        jlblBeskriv.setText("M�tes beskrivning:");

        jTxtDesc.setColumns(20);
        jTxtDesc.setRows(5);
        jScrollPane1.setViewportView(jTxtDesc);

        jLblTime.setText("Starttid:");

        jlblDatum.setText("Datum:");

        jBtnSkapaM�te.setText("L�gg till f�rslag");
        jBtnSkapaM�te.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSkapaM�teActionPerformed(evt);
            }
        });

        jTableMeeting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Namn", "Beskrivning", "Starttid", "Datum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(jTableMeeting);

        jComboPers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPersActionPerformed(evt);
            }
        });

        jTablePers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Valda personer"
            }
        ));
        jScrollPane3.setViewportView(jTablePers);

        jBtnSkicka.setText("Skicka m�tesf�rslag");
        jBtnSkicka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSkickaActionPerformed(evt);
            }
        });

        jLabel1.setText("V�lj personer att bjuda in:");

        jBAddPers.setText("L�gg till person");
        jBAddPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddPersActionPerformed(evt);
            }
        });

        jLabel2.setText("M�tesben�mning:");

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Tillbaka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBRemovePers.setText("�ngra val av person");
        jBRemovePers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemovePersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jlblInfo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(377, 377, 377))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLblTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblDatum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTxtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTimeStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnSkicka))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnSkapaM�te)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblBeskriv)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboPers, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBAddPers, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBRemovePers)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblInfo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAddPers))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemovePers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnSkicka, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jlblBeskriv)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblTime)
                            .addComponent(jTimeStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblDatum)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jBtnSkapaM�te)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPersActionPerformed

    }//GEN-LAST:event_jComboPersActionPerformed

    private void jBAddPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddPersActionPerformed
        
        
        String s = "";
        boolean exists = false;
        for (int i = 0; i < jTablePers.getRowCount(); i++) {
            s = jTablePers.getValueAt(i, 0).toString().trim();

            if (jComboPers.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "V�nligen v�l en person att l�gga till.");
            } else {
                if (jComboPers.getSelectedItem().equals(s)) {
                    exists = true;
                    break;
                }
            }
        }
        if (!exists) {
            String add = jComboPers.getSelectedItem().toString();
            DefaultTableModel model = (DefaultTableModel) jTablePers.getModel();
            model.addRow(new Object[]{add});
        } else {
            JOptionPane.showMessageDialog(null, "Anv�ndaren �r redan tillagd.");
        }


    }//GEN-LAST:event_jBAddPersActionPerformed

    private void jBtnSkapaM�teActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSkapaM�teActionPerformed
        if (Validation.checkName(jTxtNamn) && Validation.checkTextArea(jTxtDesc) && Validation.dateChooserValid(jDateChooser1) && Validation.valideraTid(jTimeStart.getText()) && Validation.validTid(jTimeStart.getText()) && Validation.isDateAhead(jDateChooser1.getDate())) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String meetingDate = dateFormat.format(jDateChooser1.getDate());
            String beskrivning = jTxtDesc.getText();
            String name = jTxtNamn.getText();
            String startTid = jTimeStart.getText() + ".00";

            String t = "";
            String d = "";
            boolean exists = false;
            for (int i = 0; i < jTableMeeting.getRowCount(); i++) {
                t = jTableMeeting.getValueAt(i, 2).toString().trim();
                d = jTableMeeting.getValueAt(i, 3).toString().trim();
                if (startTid.equals(t) && meetingDate.equals(d)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                DefaultTableModel model = (DefaultTableModel) jTableMeeting.getModel();
                model.addRow(new Object[]{name, beskrivning, startTid, meetingDate});

                jTxtDesc.setEnabled(false);
                jTxtNamn.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Du har redan gjort ett identiskt m�tesf�rslag.");
            }
        }
        
    }//GEN-LAST:event_jBtnSkapaM�teActionPerformed

    private void jBtnSkickaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSkickaActionPerformed
        
        if(checkList()) {
        int i = 0;
        String beskrivning;
        String name;
        name = jTableMeeting.getValueAt(i, 0).toString();
        beskrivning = jTableMeeting.getValueAt(i, 1).toString();
        int propMeet = 0;
        
        
        try {
            Database.executeUpdate("Insert into Proposed_Meeting (Name, Description, UserCreatorID) VALUES ('" + name + "', '" + beskrivning + "'," + creatorID + ")");
            propMeet = Integer.parseInt(Database.fetchSingle("Select ProposedMeetingID from Proposed_Meeting Where ProposedMeetingID = (Select max(ProposedMeetingID) from Proposed_Meeting)"));
        } catch (Exception e) {
            System.out.println("kunde ej inserta i proposed meeting");
            return;
        }
        
        meeting(propMeet);
        notis(propMeet);
        personer(propMeet);
        
        JOptionPane.showMessageDialog(null, "M�tesf�rslag(en) har skickats till de inbjudna");}

    }//GEN-LAST:event_jBtnSkickaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBRemovePersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemovePersActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) jTablePers.getModel();
        if(jTablePers.getSelectedRowCount() == 1){
            tblModel.removeRow(jTablePers.getSelectedRow());
        }else{
            if(jTablePers.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "Det finns inga valda personer.");
            }else{
             JOptionPane.showMessageDialog(null, "V�nligen v�lj en person att ta bort fr�n listan.");
            }
        }
    }//GEN-LAST:event_jBRemovePersActionPerformed
    
    private void meeting(int propMeet) {
        int i = 0;
        String startTid;
        String date;
        
       
        
        for (i = 0; i < jTableMeeting.getRowCount(); i++) {
            startTid = jTableMeeting.getValueAt(i, 2).toString();
            date = jTableMeeting.getValueAt(i, 3).toString();
            
            try {
                Database.executeUpdate("Insert into Proposed_Date_Time (Date, Time, ProsedMeetingID) VALUES ('" + date + "','" + startTid + "', " + propMeet + ")");
                
            } catch (Exception e) {
                System.out.println("kunde ej s�tta in i databasen");
            }
        }
    }
    
    private void personer(int propMeet) {
        
        int i = 0;
        String email;
        int userID;
        int notisID;
        
        for (i = 0; i < jTablePers.getRowCount(); i++) {
            
            email = jTablePers.getValueAt(i, 0).toString();
            
            try {
                userID = Integer.parseInt(Database.fetchSingle("Select UserID from User Where Email = '" + email + "'"));
                Database.executeUpdate("Insert into Invites (ProposedMeeting, UserID) VALUES (" + propMeet + "," + userID + ")");
                notisID = Integer.parseInt(Database.fetchSingle("Select NoticeID from Notice Where NoticeID = (Select max(NoticeID) from Notice)"));
                Database.executeUpdate("Insert into User_Notice (NID, UID) VALUES (" + notisID + "," + userID + ")");
                
            } catch (Exception e) {
                System.out.println("kunde ej s�tta in i databasen");
            }
            
        }
        
    }
    
    private void notis(int propMeet) {
    
       
        String email;
        String topic;
        String time;
        String date;
        int userID;
        int notisID;
        
        email = jTablePers.getValueAt(0, 0).toString();
        topic = jTableMeeting.getValueAt(0, 0).toString();
        time = jTableMeeting.getValueAt(0, 2).toString() + "000";
        date = jTableMeeting.getValueAt(0, 3).toString() + " " + time;

            try {
                userID = Integer.parseInt(Database.fetchSingle("Select UserID from User Where Email = '" + email + "'"));
                Database.executeUpdate("Insert into Notice (Topic, DateTime, NoticeTypeID) VALUES ('" + topic + "','" + date + "', 3)");
                notisID = Integer.parseInt(Database.fetchSingle("Select NoticeID from Notice Where NoticeID = (Select max(NoticeID) from Notice)"));
                Database.executeUpdate("Insert into Notice_Proposed_Meeting (NID,ProposedID) VALUES (" + notisID + "," + propMeet + ") ");
               
                
                
            } catch (Exception e) {
                System.out.println("kunde ej s�tta in i databasen");
            }
            
    }
    
    private boolean checkList() {
    boolean resultat = true;    
    try {
    String koll2 = jTableMeeting.getValueAt(0, 0).toString();
    String koll = jTablePers.getValueAt(0, 0).toString();
    
        return resultat;
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, "V�nligen fyll i all informatin och minst en deltagare");
    resultat = false;
    return resultat;
    }
    
    
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddPers;
    private javax.swing.JButton jBRemovePers;
    private javax.swing.JButton jBtnSkapaM�te;
    private javax.swing.JButton jBtnSkicka;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboPers;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblTime;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableMeeting;
    private javax.swing.JTable jTablePers;
    private com.github.lgooddatepicker.components.TimePicker jTimeStart;
    private javax.swing.JTextArea jTxtDesc;
    private javax.swing.JTextField jTxtNamn;
    private javax.swing.JLabel jlblBeskriv;
    private javax.swing.JLabel jlblDatum;
    private javax.swing.JLabel jlblInfo;
    // End of variables declaration//GEN-END:variables
}
