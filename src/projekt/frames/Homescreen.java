/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import projekt.User;

/**
 *
 * @author Amand
 */
public class Homescreen extends javax.swing.JFrame {

    private int id;
    private String firstName;
    private String lastName;
    private User user;

    /**
     * Creates new form Homescreen
     */
    public Homescreen(int id) {
        initComponents();
        jBAdminUsers.setVisible(false);
        this.id = id;
        this.user = new User(this.id);    
        
        adminCheck();
        lblWelcome.setText("V�LKOMMEN: " + user.getFirstName() + " " + user.getLastName() + "!");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBFormal.setBackground(new java.awt.Color(153, 153, 255));
        jBFormal.setText("Formell blogg");
        jBFormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFormalActionPerformed(evt);
            }
        });

        jBInformal.setBackground(new java.awt.Color(255, 153, 204));
        jBInformal.setText("Informell blogg");
        jBInformal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInformalActionPerformed(evt);
            }
        });

        jBMeetings.setText("M�ten");
        jBMeetings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMeetingsActionPerformed(evt);
            }
        });

        jBProfile.setBackground(new java.awt.Color(84, 255, 79));
        jBProfile.setText("Profil");
        jBProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProfileActionPerformed(evt);
            }
        });

        jBAdminUsers.setBackground(new java.awt.Color(255, 50, 50));
        jBAdminUsers.setText("Hantera anv�ndare");
        jBAdminUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdminUsersActionPerformed(evt);
            }
        });

        lblSearch.setText("S�k p� nyckelord i inl�gg");

        jBsearch.setText("S�k");
        jBsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsearchActionPerformed(evt);
            }
        });

        lblWelcome.setText("V�LKOMMEN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSearch)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBFormal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBInformal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBAdminUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsearch))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBFormal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBInformal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jBAdminUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBFormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFormalActionPerformed
        new FormalBlog(user).setVisible(true);

    }//GEN-LAST:event_jBFormalActionPerformed

    private void jBInformalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInformalActionPerformed
        new InformalBlog(user).setVisible(true);


    }//GEN-LAST:event_jBInformalActionPerformed

    private void jBMeetingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMeetingsActionPerformed
        new PersonalMeetings(id).setVisible(true);
    }//GEN-LAST:event_jBMeetingsActionPerformed

    private void jBProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProfileActionPerformed
        new Profile(this.id).setVisible(true);
    }//GEN-LAST:event_jBProfileActionPerformed

    private void jBAdminUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdminUsersActionPerformed

        new ManageUsers().setVisible(true);
    }//GEN-LAST:event_jBAdminUsersActionPerformed

    private void jBsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsearchActionPerformed

       new SearchResults(jtfSearch.getText().toLowerCase()).setVisible(true);
    }//GEN-LAST:event_jBsearchActionPerformed

    private void adminCheck() {

        if (user.getAdmin().equals("J")) {
            jBAdminUsers.setVisible(true);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdminUsers;
    private javax.swing.JButton jBFormal;
    private javax.swing.JButton jBInformal;
    private javax.swing.JButton jBMeetings;
    private javax.swing.JButton jBProfile;
    private javax.swing.JButton jBsearch;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
