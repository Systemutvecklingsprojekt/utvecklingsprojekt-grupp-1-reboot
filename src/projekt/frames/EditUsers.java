/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import projekt.User;
import javax.swing.JOptionPane;
import projekt.helpers.Database;

/**
 *
 * @author Amand
 */
public class EditUsers extends javax.swing.JFrame {
    
    private int id;
    private User user;

    /**
     * Creates new form EditUsers
     */
    public EditUsers(int id) {
        initComponents();
        this.id = id;
        this.user = new User(id);
        setLabel();
        setTextField();
        
    }
    
    public void setLabel () {
    
        lbinfo.setText("Du h�ller p� och �ndrar anv�ndare : " + user.getFirstName() + " " + user.getLastName() );
    }
    
    public void setTextField() {
    
        jtfFirstName.setText(user.getFirstName());
        jtfLastName.setText(user.getLastName());
        jtfPassword.setText(user.getPassword());
        jtfEmail.setText(user.getEmail());
        if(user.getAdmin().equals("J")) {
            jRadioAdmin.setSelected(true);
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

        jBBack = new javax.swing.JButton();
        lbinfo = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        lblEfterNamn = new javax.swing.JLabel();
        jtfLastName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jRadioAdmin = new javax.swing.JRadioButton();
        jBSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        lbinfo.setText("Redigera anv�ndare:");

        lblFirstName.setText("F�rnamn:");

        jtfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirstNameActionPerformed(evt);
            }
        });

        lblEfterNamn.setText("Efternamn: ");

        lblPassword.setText("L�senord");

        lblAdmin.setText("Admin Status");

        lblEmail.setText("Epost:");

        jRadioAdmin.setText("Ja");
        jRadioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioAdminActionPerformed(evt);
            }
        });

        jBSave.setText("Spara �ndringar");
        jBSave.setPreferredSize(new java.awt.Dimension(100, 25));
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(lbinfo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEfterNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAdmin)
                                    .addComponent(jBSave, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfFirstName)
                                    .addComponent(jtfLastName)
                                    .addComponent(jtfEmail)
                                    .addComponent(jtfPassword))))
                        .addGap(0, 197, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbinfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFirstName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEfterNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioAdmin)
                .addGap(18, 18, 18)
                .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    private void jtfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFirstNameActionPerformed

    private void jRadioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioAdminActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        String firstName = jtfFirstName.getText();
        String lastName = jtfLastName.getText();
        String password = jtfPassword.getText();
        String email = jtfEmail.getText();
                
        try {
            String sqlEmail = Database.fetchSingle("SELECT eMail FROM User WHERE eMail = '" + email + "';");
            String tempId = Database.fetchSingle("SELECT UserID FROM User WHERE eMail = '" + email + "';");
            if(sqlEmail != null){
                if(id != Integer.parseInt(tempId)){
                JOptionPane.showMessageDialog(null, "Denna Email anv�nds redan!");
                return;
                }
            }
            
            Database.executeUpdate("UPDATE User SET firstName ='" + firstName +"' WHERE UserID =" + id);
            Database.executeUpdate("UPDATE User SET lastName ='" + lastName +"' WHERE UserID =" + id);
            Database.executeUpdate("UPDATE User SET Password ='" + password +"' WHERE UserID =" + id);
            Database.executeUpdate("UPDATE User SET eMail ='" + email +"' WHERE UserID =" + id);
            if(jRadioAdmin.isSelected()){
                Database.executeUpdate("UPDATE User SET adminStatus ='J' WHERE UserID =" + id); 
              }
            else{
                Database.executeUpdate("UPDATE User SET adminStatus ='N' WHERE UserID =" + id); 
            }
            JOptionPane.showMessageDialog(null, "Anv�ndare " + firstName +" "+ lastName + " �r nu uppdaterad!");
        } catch (Exception e) {
            System.out.println("fel");
        }
    }//GEN-LAST:event_jBSaveActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBSave;
    private javax.swing.JRadioButton jRadioAdmin;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JLabel lbinfo;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblEfterNamn;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblPassword;
    // End of variables declaration//GEN-END:variables
}
