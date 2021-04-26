package projekt.frames;

import java.util.ArrayList;
import projekt.helpers.Database;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import projekt.helpers.Validation;

/**
 *
 * @author Team 1
 */
public class CreateUser extends javax.swing.JFrame {

    private String sqlQuery;
    private ArrayList<JTextField> textFields;

    public CreateUser() {
        initComponents();
        textFields = new ArrayList<>();
        insertFields();
    }

    /**
     * Metod för att skapa en ny användare som ska in i databasen
     */
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
        sqlQuery = "INSERT INTO User (password, eMail, firstName, lastName, adminStatus) VALUES "
                + "( '" + password + "','" + email + "','" + firstName + "','" + lastName + "','" + adminStatus + "');";
    }

    private void clearTextFields() {
        jTFPassword.setText("");
        jTFEmail.setText("");
        jTFFirstName.setText("");
        jTFLastName.setText("");
    }

    private void insertFields() {
        textFields.add(jTFPassword);
        textFields.add(jTFEmail);
        textFields.add(jTFFirstName);
        textFields.add(jTFLastName);
    }

   
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

        jLTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLTitle.setText("Skapa ny användare");

        jLFirstName.setText("Förnamn:");

        jLLastName.setText("Efternamn:");

        jLEmail.setText("E-post:");

        jLPassword.setText("Lösenord:");

        jLAdmin.setText("Adminstatus:");

        jRBAdminJa.setText("Ja");

        jBSave.setBackground(new java.awt.Color(204, 204, 255));
        jBSave.setText("Skapa användare");
        jBSave.setPreferredSize(new java.awt.Dimension(100, 25));
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
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
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLFirstName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(jLEmail))
                                                .addComponent(jLPassword))
                                            .addGap(25, 25, 25)
                                            .addComponent(jTFPassword))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTFFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLLastName)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLAdmin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBAdminJa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(220, 220, 220)))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLFirstName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLastName)
                    .addComponent(jTFLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAdmin)
                    .addComponent(jRBAdminJa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metod för att checka korrekta inmatningar som gjorts i alla textfält.
     * @param evt 
     */
    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed

        if (Validation.multibleTextFieldEmpty(textFields) && Validation.checkName(jTFFirstName) && Validation.checkName(jTFLastName) && Validation.checkPTextField(jTFPassword) && Validation.emailVerification(jTFEmail.getText())) {
            createVariables();
            try {
                String sqlEmail = Database.fetchSingle("SELECT eMail FROM User WHERE eMail = '" + jTFEmail.getText() + "';");
                if (sqlEmail != null) {
                    JOptionPane.showMessageDialog(null, "Denna Email används redan!");
                    return;
                }
                Database.executeUpdate(sqlQuery);
                JOptionPane.showMessageDialog(null, "Användare " + jTFFirstName.getText() + " " + jTFLastName.getText() + " är nu skapad!");
                clearTextFields();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jBSaveActionPerformed

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
