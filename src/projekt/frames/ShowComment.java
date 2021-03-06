
package projekt.frames;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import projekt.User;
import projekt.helpers.Database;


public class ShowComment extends javax.swing.JFrame {

    private int id;
    private User user;

    
    public ShowComment(int id, User user) {
        initComponents();
        this.id = id;
        this.user = user;
        fillComment(id);
        jBLike.setVisible(true);
        
        if (user == null){
            jBLike.setVisible(false);
        }
    }

    public void fillComment(int id) {

        try {
            String firstName = Database.fetchSingle("Select firstName from User where UserID IN (Select UserID from Comments where CommentID =" + id + ")");
            String lastName = Database.fetchSingle("Select lastName from User where UserID IN (Select UserID from Comments where CommentID =" + id + ")");
            jLblForfattare.setText("Författare : " + firstName + " " + lastName);
            String timeStamp = Database.fetchSingle("Select timeStamp FROM Comments where CommentID=" + id);
            jLblTime.setText(timeStamp);
            jTextArea1.setText(Database.fetchSingle("Select Text from Comments where CommentID=" + id));
            jTextArea1.setEditable(false);
            jtfLikeCount.setText(Database.fetchSingle("SELECT count(likes) FROM Comment_Likes WHERE CommentID =" + id));

        } catch (SQLException e) {
            System.out.println("?");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblForfattare = new javax.swing.JLabel();
        jLblTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jbBack = new javax.swing.JButton();
        jBLike = new javax.swing.JButton();
        jtfLikeCount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLblForfattare.setText("Författare:");

        jLblTime.setText("Tid:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jbBack.setBackground(new java.awt.Color(204, 204, 255));
        jbBack.setText("Tillbaka");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        jBLike.setText("Gilla!");
        jBLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLikeActionPerformed(evt);
            }
        });

        jtfLikeCount.setEditable(false);

        jLabel1.setText("Gillningar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLblForfattare, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jbBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfLikeCount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBLike))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblForfattare)
                            .addComponent(jLblTime))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBLike))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLikeCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jbBack)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbBackActionPerformed

    private void jBLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLikeActionPerformed
        int userId = user.getUserID();
        String insertQuery = "INSERT INTO Comment_Likes (UserID, CommentID, likes) VALUES (" + userId + ", " + id + ", 1)";
        String nameQuery = "SELECT firstName FROM User WHERE userId = " + userId;
        try {
            
            String tempId = Database.fetchSingle("SELECT UserID FROM Comment_Likes WHERE CommentID = " + id);
            System.out.println(tempId);
            if (tempId == null) {
                Database.executeUpdate(insertQuery);
                jtfLikeCount.setText(Database.fetchSingle("SELECT count(likes) FROM Comment_Likes WHERE CommentID =" + id));
                JOptionPane.showMessageDialog(null, "Du gillade precis " + Database.fetchSingle(nameQuery) + "s kommentar!");
            } else {
                JOptionPane.showMessageDialog(null, "Du har redan gillat denna kommentar!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jBLikeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLike;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblForfattare;
    private javax.swing.JLabel jLblTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbBack;
    private javax.swing.JTextField jtfLikeCount;
    // End of variables declaration//GEN-END:variables
}
