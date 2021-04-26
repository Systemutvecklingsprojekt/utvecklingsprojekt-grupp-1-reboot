/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.io.File;
import projekt.helpers.Database;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import projekt.Refactor;
import projekt.User;

/**
 *
 * @author Josef
 */
public class ShowPost extends javax.swing.JFrame {

    private int postID;
    private User user;

    /**
     * Creates new form ShowPost
     */
    public ShowPost(User user, int postID) {
        initComponents();
        fillPost(postID);
        this.postID = postID;
        this.user = user;

        String postUserID;
        int postUserInt = 0;
        try {
            postUserID = Database.fetchSingle("Select UserID from Post where postID = " + postID);
            postUserInt = Integer.parseInt(postUserID);
        } catch (SQLException ex) {
            Logger.getLogger(ShowPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user == null) {
            jBEditPost.setVisible(false);
        } else {
            if (user.getUserID() != postUserInt) {
                jBEditPost.setVisible(false);
            }
        }

        try {
            String joinQuery = "SELECT CommentID, firstName, lastName, Comments.timeStamp, Text FROM User JOIN Comments ON User.UserID = Comments.UserID WHERE PostID =" + postID;

            fillComments(Database.fetchRows(joinQuery));
            System.out.println("ShowPost");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {
            jbNewComment.setVisible(false);
            jBLike1.setVisible(false);
            jBDeletePost.setVisible(false);
        }
        if (user != null && user.getAdmin().equalsIgnoreCase("N")) {
            jBDeletePost.setVisible(false);
        }
        fillPicture();
    }

    public void fillPicture() {
        try {
            String pathway = Database.fetchSingle("SELECT Picture FROM Post WHERE PostID = " + postID);
            System.out.println(pathway);

            txt_filename.setText(pathway);
            Image getAbsolutePath = null;
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(pathway);
            Image image = icon.getImage().getScaledInstance(jLPicture.getWidth(), jLPicture.getHeight(), Image.SCALE_DEFAULT);
            jLPicture.setIcon(new ImageIcon(new ImageIcon(pathway).getImage().getScaledInstance(jLPicture.getHeight(), jLPicture.getHeight(), Image.SCALE_SMOOTH)));

        } catch (SQLException ex) {
            Logger.getLogger(ShowPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillComments(ResultSet rs) {
        try {
            jTableComments = new JTable(Refactor.tableModelBuilder(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jspComments.setViewportView(jTableComments);
        jTableComments.setVisible(true);
        jTableComments.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                    int id = (int) (jTableComments.getValueAt(jTableComments.getSelectedRow(), 0));
                    new ShowComment(id, user).setVisible(true);
                }
            }
        });
    }

    public void fillPost(int postID) {

        try {
            jTextField4.setText(Database.fetchSingle("Select title from Post where PostID=" + postID));
            jTextField2.setText(Database.fetchSingle("Select User.firstName FROM User, Post WHERE Post.UserID = User.UserID AND PostID = " + postID) + " " + Database.fetchSingle("Select User.lastName FROM User, Post WHERE Post.UserID = User.UserID AND PostID = " + postID));
            jTextField3.setText(Database.fetchSingle("Select timeStamp FROM Post where PostID=" + postID));
            jTextArea1.setText(Database.fetchSingle("Select description from Post where PostID=" + postID));
            jtfLikeCount.setText(Database.fetchSingle("SELECT count(likes) FROM Post_Likes WHERE PostID =" + postID));

            ResultSet tagsRs = Database.fetchRows("Select tagName from Tag where tagID in (Select tagID from Post_Tag where PostID=" + postID + ")");
            String tags = "";
            while (tagsRs.next()) {

                tags = tags + tagsRs.getString(1);
                tags = tags + ", ";
            }

            jTextField1.setText(tags);
        } catch (SQLException e) {

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbNewComment = new javax.swing.JButton();
        jspComments = new javax.swing.JScrollPane();
        jTableComments = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfLikeCount = new javax.swing.JTextField();
        jBLike1 = new javax.swing.JButton();
        jBEditPost = new javax.swing.JButton();
        jBDeletePost = new javax.swing.JButton();
        jLPicture = new javax.swing.JLabel();
        txt_filename = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.setEditable(false);
        jTextField1.setText("jTextField1");

        jLabel2.setText("Taggar:");

        jLabel3.setText("Författare:");

        jLabel4.setText("Tid:");

        jTextField2.setEditable(false);
        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setText("jTextField3");

        jTextField4.setEditable(false);
        jTextField4.setText("jTextField4");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbNewComment.setBackground(new java.awt.Color(204, 204, 255));
        jbNewComment.setText("Ny kommentar");
        jbNewComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewCommentActionPerformed(evt);
            }
        });

        jTableComments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jspComments.setViewportView(jTableComments);

        jLabel1.setText("Gillningar:");

        jtfLikeCount.setEditable(false);

        jBLike1.setBackground(new java.awt.Color(255, 153, 153));
        jBLike1.setText("Gilla!");
        jBLike1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLike1ActionPerformed(evt);
            }
        });

        jBEditPost.setBackground(new java.awt.Color(204, 204, 255));
        jBEditPost.setText("Redigera inlägg");
        jBEditPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditPostActionPerformed(evt);
            }
        });

        jBDeletePost.setBackground(new java.awt.Color(204, 204, 255));
        jBDeletePost.setText("Ta bort inlägg");
        jBDeletePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletePostActionPerformed(evt);
            }
        });

        txt_filename.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEditPost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbNewComment))
                    .addComponent(jTextField4)
                    .addComponent(jspComments)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jBDeletePost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfLikeCount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jBLike1)))
                        .addGap(8, 8, 8)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfLikeCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBLike1)
                            .addComponent(jBDeletePost))
                        .addGap(18, 18, 18)
                        .addComponent(jspComments, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbNewComment)
                    .addComponent(jBEditPost))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField2ActionPerformed
    {//GEN-HEADEREND:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbNewCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewCommentActionPerformed
        this.dispose();
        new NewComment(user, postID).setVisible(true);
    }//GEN-LAST:event_jbNewCommentActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed


    private void jBLike1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLike1ActionPerformed
        int userId = user.getUserID();
        String insertQuery = "INSERT INTO Post_Likes (UserID, PostID, likes) VALUES (" + userId + ", " + postID + ", 1)";
        String nameQuery = "SELECT firstName FROM User JOIN Post ON User.UserID = Post.UserID WHERE PostID = " + postID;
        try {
            String tempId = Database.fetchSingle("SELECT UserID FROM Post_Likes WHERE PostID = " + postID);
            System.out.println(tempId);
            if (tempId == null) {
                Database.executeUpdate(insertQuery);
                jtfLikeCount.setText(Database.fetchSingle("SELECT count(likes) FROM Post_Likes WHERE PostID =" + postID));
                JOptionPane.showMessageDialog(null, "Du gillade precis " + Database.fetchSingle(nameQuery) + "s inlägg!");
            } else {
                JOptionPane.showMessageDialog(null, "Du har redan gillat detta inlägg!");
            }
        } catch (SQLException ex) {
            System.out.println("fel");
        }
    }//GEN-LAST:event_jBLike1ActionPerformed

    private void jBLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean getPostTypeID() throws SQLException{
        
        boolean typFormal = false;
        try{
        String typeID = Database.fetchSingle("Select typeID from Post where PostID = " + postID);
        int typeIDint = Integer.parseInt(typeID);
        
        if(typeIDint == 1){
        typFormal = true;
        }}
        catch (SQLException e) {

        }
        return typFormal;
    }
    
    private void jBEditPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditPostActionPerformed
        // TODO add your handling code here:
        new EditPost(user, postID).setVisible(true);
    }//GEN-LAST:event_jBEditPostActionPerformed

    private void jBDeletePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletePostActionPerformed
        int n = JOptionPane.showConfirmDialog(
                null,
                "Vill du verkligen ta bort inlägget?",
                "Förfrågan",
                JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            try {
                Database.executeUpdate("DELETE FROM Post_Tag WHERE PostID = " + postID);
                Database.executeUpdate("DELETE FROM Post_Likes WHERE PostID = " + postID);
                Database.executeUpdate("DELETE FROM Comments WHERE PostID = " + postID);
                Database.executeUpdate("DELETE FROM Post WHERE PostID = " + postID);

            } catch (SQLException ex) {
                Logger.getLogger(ShowPost.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                new Blog(user, getPostTypeID()).setVisible(true);
                
            } catch (SQLException ex) {
            }
            JOptionPane.showMessageDialog(null, "Inlägget är nu borttaget!");
            this.dispose();
        }
    }//GEN-LAST:event_jBDeletePostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDeletePost;
    private javax.swing.JButton jBEditPost;
    private javax.swing.JButton jBLike1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLPicture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComments;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton jbNewComment;
    private javax.swing.JScrollPane jspComments;
    private javax.swing.JTextField jtfLikeCount;
    private javax.swing.JTextField txt_filename;
    // End of variables declaration//GEN-END:variables
}
