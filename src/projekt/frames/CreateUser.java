/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import projekt.helpers.Database;
import javax.swing.JOptionPane;

/**
 *
 * @author Amand
 */
public class CreateUser extends javax.swing.JFrame {

    private String sqlQuery;

    /**
     * Creates new form CreateUser
     */
    public CreateUser() {
        initComponents();
    }

    private void createVariables() {

        String password = jTFPassword.getText();
        String email = jTFEmail.getText();
        String firstName = jTFFirstName.getText();
        String lastName = jTFLastName.getText();
        String adminStatus = "";
        if (jRBAdminJa.isSelected()) {
            adminStatus = "J";
        } else {
            adminStatus = "N";
        }
        sqlQuery = "INSERT INTO User (password, eMail, firstName, lastName, adminStatus) VALUES ( '" + password + "','" + email + "','" + firstName + "','" + lastName + "','" + adminStatus + "');";

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFFirstName = new javax.swing.JTextField();
        jTFLastName = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFPassword = new javax.swing.JTextField();
        jLTitle = new javax.swing.JLabel();
        jLFirstName = new javax.swing.JLabel();
        jLLastName = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jLPassword = new javax.swing.JLabel();
        jLAdmin = new javax.swing.JLabel();
        jRBAdminJa = new javax.swing.JRadioButton();
        jBSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTFFirstName.setColumns(5);
        jTFFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFFirstNameActionPerformed(evt);
            }
        });

        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });

        jLTitle.setText("Skapa ny anv�ndare");

        jLFirstName.setText("F�rnamn");

        jLLastName.setText("Efternamn");

        jLEmail.setText("E-post");

        jLPassword.setText("L�senord");

        jLAdmin.setText("Adminstatus");

        jRBAdminJa.setText("Ja");
        jRBAdminJa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBAdminJaActionPerformed(evt);
            }
        });

        jBSave.setText("Skapa anv�ndare");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jButton1.setText("Tillbaka");
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
                        .addGap(121, 121, 121)
                        .addComponent(jLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBSave, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLFirstName)
                            .addComponent(jLAdmin)
                            .addComponent(jRBAdminJa)
                            .addComponent(jTFPassword)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLPassword)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLFirstName)
                .addGap(2, 2, 2)
                .addComponent(jTFFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLLastName)
                .addGap(5, 5, 5)
                .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBAdminJa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTFFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFFirstNameActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed

        createVariables();
            try {
                String sqlEmail = Database.fetchSingle("SELECT eMail FROM User WHERE eMail = '" + jTFEmail.getText() + "';");
                if (sqlEmail != null) {
                    JOptionPane.showMessageDialog(null, "Denna Email anv�nds redan!");
                    return;
                }
                Database.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(null, "Anv�ndare " + jTFFirstName.getText() +" "+ jTFLastName.getText() + " �r nu skapad!");
                jTFPassword.setText("");
                jTFEmail.setText("");
                jTFFirstName.setText("");
                jTFLastName.setText("");
            } catch (Exception e) {
                System.out.println("fel");
            }
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jRBAdminJaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAdminJaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBAdminJaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLAdmin;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLFirstName;
    private javax.swing.JLabel jLLastName;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JRadioButton jRBAdminJa;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFFirstName;
    private javax.swing.JTextField jTFLastName;
    private javax.swing.JTextField jTFPassword;
    // End of variables declaration//GEN-END:variables
}
