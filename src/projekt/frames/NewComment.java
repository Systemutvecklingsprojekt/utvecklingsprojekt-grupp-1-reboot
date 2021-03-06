package projekt.frames;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import projekt.User;
import projekt.helpers.Database;

public class NewComment extends javax.swing.JFrame {

    private User user;
    private int postId;

    public NewComment(User user, int postId) {
        initComponents();

        this.user = user;
        this.postId = postId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfComment = new javax.swing.JTextField();
        jbPublishComment = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtfComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCommentActionPerformed(evt);
            }
        });

        jbPublishComment.setBackground(new java.awt.Color(204, 204, 255));
        jbPublishComment.setText("Publicera kommentar");
        jbPublishComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPublishCommentActionPerformed(evt);
            }
        });

        jbBack.setBackground(new java.awt.Color(204, 204, 255));
        jbBack.setText("Tillbaka");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Skriv en kommentar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbPublishComment))
                        .addComponent(jtfComment, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfComment, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPublishComment)
                    .addComponent(jbBack))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCommentActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        this.dispose();
        new ShowPost(user, postId).setVisible(true);
    }//GEN-LAST:event_jbBackActionPerformed
    /**
     * Metod f?r att kommentera ett inl?gg Kommentaren kopplas till anv?ndarens
     * ID
     *
     * @param evt
     */
    private void jbPublishCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPublishCommentActionPerformed
        String comment = jtfComment.getText();
        if (comment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "V?nligen skriv n?gonting som kommentar");
            return;
        }
        int userId = user.getUserID();
        System.out.println(comment + " " + userId + " " + postId);
        String query = "INSERT INTO Comments (UserID, PostID, Text) VALUES(" + userId + ", " + postId + ",'" + comment + "')";

        try {
            Database.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(query);
        }
        JOptionPane.showMessageDialog(null, "Kommentar ?r nu tillagd!");
        this.dispose();
        new ShowPost(user, postId).setVisible(true);

    }//GEN-LAST:event_jbPublishCommentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbPublishComment;
    private javax.swing.JTextField jtfComment;
    // End of variables declaration//GEN-END:variables
}
