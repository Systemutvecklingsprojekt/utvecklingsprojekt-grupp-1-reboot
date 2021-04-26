package projekt.frames;

/**
 *
 * @author Team 1
 */
public class ManageUsers extends javax.swing.JFrame {

    public ManageUsers() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAddUser = new javax.swing.JButton();
        jBUpdateDelete = new javax.swing.JButton();
        jBBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBAddUser.setBackground(new java.awt.Color(204, 204, 255));
        jBAddUser.setText("Lägg till ny användare");
        jBAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddUserActionPerformed(evt);
            }
        });

        jBUpdateDelete.setBackground(new java.awt.Color(204, 204, 255));
        jBUpdateDelete.setText("Uppdatera eller ta bort användare");
        jBUpdateDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateDeleteActionPerformed(evt);
            }
        });

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tiilbaka");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(jBUpdateDelete))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jBAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBUpdateDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddUserActionPerformed
        new CreateUser().setVisible(true);
    }//GEN-LAST:event_jBAddUserActionPerformed

    private void jBUpdateDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateDeleteActionPerformed
        new UpdateDeleteUser().setVisible(true);
    }//GEN-LAST:event_jBUpdateDeleteActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
       this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddUser;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBUpdateDelete;
    // End of variables declaration//GEN-END:variables
}
