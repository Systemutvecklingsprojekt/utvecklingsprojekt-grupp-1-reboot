/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import javax.swing.JOptionPane;
import java.util.HashMap;
import projekt.helpers.Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekt.helpers.Validation;

/**
 *
 * @author Victor & Noel
 */
public class LogIn extends javax.swing.JFrame {
    
    /**
     * Creates new form LogIn
     */
   
    public LogIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBLogInButton = new javax.swing.JButton();
        jTFEmailField = new javax.swing.JTextField();
        jLEmailLabel = new javax.swing.JLabel();
        jLPasswordLabel = new javax.swing.JLabel();
        jPFPasswordField = new javax.swing.JPasswordField();
        jLWelcomeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBLogInButton.setBackground(new java.awt.Color(204, 204, 255));
        jBLogInButton.setText("Logga in");
        jBLogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogInButtonActionPerformed(evt);
            }
        });

        jLEmailLabel.setText("E-postadress:");

        jLPasswordLabel.setText("L�senord:");

        jLWelcomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLWelcomeLabel.setText("V�nligen ange E-postadress och l�senord");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLWelcomeLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLEmailLabel)
                            .addComponent(jLPasswordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFEmailField)
                            .addComponent(jPFPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBLogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLWelcomeLabel)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPFPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPasswordLabel))
                .addGap(30, 30, 30)
                .addComponent(jBLogInButton)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLogInButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        // Connecta till Databasen typ h�r

        String eMail = jTFEmailField.getText();
        String password = jPFPasswordField.getText();

        
        try {
            String userIDQuery = Database.fetchSingle("SELECT USERID FROM User WHERE EMAIL ='" + eMail + "'");
            String eMailQuery = Database.fetchSingle("SELECT EMAIL FROM User WHERE USERID =" + userIDQuery);
            String passwordQuery = Database.fetchSingle("SELECT PASSWORD FROM User WHERE USERID ="+ userIDQuery);
            if (Validation.checkTextField(jTFEmailField)) {
                if(Validation.checkPasswordField(jPFPasswordField)){
                    if(eMailQuery.equals(eMail)){
                        if(passwordQuery.equals(password)){
                            int ID = Integer.parseInt(userIDQuery);
                            new HomeScreen(ID).setVisible(true);
                            this.dispose(); 
                        } else {
                            JOptionPane.showMessageDialog(null, "Anv�ndarnamn eller l�senord �r felaktigt!");
                        }
                    } 
                }
            }
        } catch(SQLException ex) {
            System.out.println("error");
            
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Anv�ndarnamn eller l�senord �r felaktigt!");
        }    
    }                                           

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLogInButton;
    private javax.swing.JLabel jLEmailLabel;
    private javax.swing.JLabel jLPasswordLabel;
    private javax.swing.JLabel jLWelcomeLabel;
    private javax.swing.JPasswordField jPFPasswordField;
    private javax.swing.JTextField jTFEmailField;
    // End of variables declaration//GEN-END:variables
}
