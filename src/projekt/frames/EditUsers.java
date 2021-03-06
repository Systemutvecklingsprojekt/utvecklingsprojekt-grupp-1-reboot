
package projekt.frames;

import java.util.ArrayList;
import projekt.User;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import projekt.helpers.Database;
import projekt.helpers.Validation;


public class EditUsers extends javax.swing.JFrame {

    private int id;
    private User user;
    private ArrayList<JTextField> textFields;

    
    public EditUsers(int id) {
        initComponents();
        this.id = id;
        this.user = new User(id);
        setLabel();
        setTextField();
        textFields = new ArrayList<>();
        insertTextFields();
    }

    public void setLabel() {

        lbinfo.setText("Du h?ller p? och ?ndrar anv?ndare : " + user.getFirstName() + " " + user.getLastName());
    }

    public void setTextField() {

        jtfFirstName.setText(user.getFirstName());
        jtfLastName.setText(user.getLastName());
        jtfPassword.setText(user.getPassword());
        jtfEmail.setText(user.getEmail());
        if (user.getAdmin().equals("J")) {
            jRadioAdmin.setSelected(true);
        }
    }

    private void insertTextFields() {
        textFields.add(jtfFirstName);
        textFields.add(jtfLastName);
        textFields.add(jtfPassword);
        textFields.add(jtfEmail);
    }

   
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        lbinfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbinfo.setText("Redigera anv?ndare:");

        lblFirstName.setText("F?rnamn:");

        lblEfterNamn.setText("Efternamn: ");

        lblPassword.setText("L?senord:");

        lblAdmin.setText("Adminstatus:");

        lblEmail.setText("Epost:");

        jRadioAdmin.setText("Ja");

        jBSave.setBackground(new java.awt.Color(204, 204, 255));
        jBSave.setText("Spara ?ndringar");
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
                        .addContainerGap()
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblFirstName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEfterNamn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lbinfo)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEfterNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdmin)
                    .addComponent(jRadioAdmin)
                    .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        String firstName = jtfFirstName.getText();
        String lastName = jtfLastName.getText();
        String password = jtfPassword.getText();
        String email = jtfEmail.getText();
        if (Validation.multibleTextFieldEmpty(textFields) && Validation.checkName(jtfFirstName) && Validation.checkName(jtfLastName) && Validation.checkPTextField(jtfPassword) && Validation.emailVerification(jtfEmail.getText())) {
            try {
                String sqlEmail = Database.fetchSingle("SELECT eMail FROM User WHERE eMail = '" + email + "';");
                String tempId = Database.fetchSingle("SELECT UserID FROM User WHERE eMail = '" + email + "';");
                if (sqlEmail != null) {
                    if (id != Integer.parseInt(tempId)) {
                        JOptionPane.showMessageDialog(null, "Denna Email anv?nds redan!");
                        return;
                    }
                }

                Database.executeUpdate("UPDATE User SET firstName ='" + firstName + "' WHERE UserID =" + id);
                Database.executeUpdate("UPDATE User SET lastName ='" + lastName + "' WHERE UserID =" + id);
                Database.executeUpdate("UPDATE User SET Password ='" + password + "' WHERE UserID =" + id);
                Database.executeUpdate("UPDATE User SET eMail ='" + email + "' WHERE UserID =" + id);
                if (jRadioAdmin.isSelected()) {
                    Database.executeUpdate("UPDATE User SET adminStatus ='J' WHERE UserID =" + id);
                } else {
                    Database.executeUpdate("UPDATE User SET adminStatus ='N' WHERE UserID =" + id);
                }
                JOptionPane.showMessageDialog(null, "Anv?ndare " + firstName + " " + lastName + " ?r nu uppdaterad!");
            } catch (Exception e) {
                e.printStackTrace();
            }
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
