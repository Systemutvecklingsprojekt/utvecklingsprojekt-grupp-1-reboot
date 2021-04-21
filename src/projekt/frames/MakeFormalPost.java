/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import projekt.helpers.Database;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projekt.User;
import projekt.helpers.Validation;

/**
 *
 * @author albin
 */
public class MakeFormalPost extends javax.swing.JFrame {

    private int maxTags;
    private ArrayList<String> chosenTags;
    private User user;
    private String oldTag;

    public MakeFormalPost(User user) {
        this.user = user;
        maxTags = 0;
        chosenTags = new ArrayList<>();
        oldTag = "";

        initComponents();
        fillTags();
        jTFNewTag.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser2 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAPost = new javax.swing.JTextArea();
        jTFTitle = new javax.swing.JTextField();
        jCBTags = new javax.swing.JComboBox<>();
        jTFNewTag = new javax.swing.JTextField();
        jBUpload = new javax.swing.JButton();
        jbUploadFile = new javax.swing.JButton();
        jBAddTag = new javax.swing.JButton();
        jLTags = new javax.swing.JLabel();
        jlUplodedFile = new javax.swing.JLabel();
        jBBack = new javax.swing.JButton();
        jBRemoveTag = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_filename = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTAPost.setColumns(20);
        jTAPost.setRows(5);
        jScrollPane1.setViewportView(jTAPost);

        jTFTitle.setText("Rubrik");

        jCBTags.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCBTagsMouseReleased(evt);
            }
        });

        jTFNewTag.setText("Skriv ny tagg...");
        jTFNewTag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTFNewTagMouseReleased(evt);
            }
        });

        jBUpload.setBackground(new java.awt.Color(204, 204, 255));
        jBUpload.setText("Dela");
        jBUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUploadActionPerformed(evt);
            }
        });

        jbUploadFile.setBackground(new java.awt.Color(204, 204, 255));
        jbUploadFile.setText("Ladda upp fil");
        jbUploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUploadFileActionPerformed(evt);
            }
        });

        jBAddTag.setBackground(new java.awt.Color(204, 204, 255));
        jBAddTag.setText("L�gg till tagg");
        jBAddTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddTagActionPerformed(evt);
            }
        });

        jLTags.setText("Taggar: ");

        jlUplodedFile.setText("Fil: ");

        jBBack.setBackground(new java.awt.Color(204, 204, 255));
        jBBack.setText("Tillbaka");
        jBBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackActionPerformed(evt);
            }
        });

        jBRemoveTag.setText("Ta bort tagg");
        jBRemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveTagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTags, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTFNewTag, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBRemoveTag, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBAddTag, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbUploadFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlUplodedFile)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(43, 43, 43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFNewTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBAddTag))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRemoveTag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUploadFile)
                    .addComponent(jlUplodedFile)
                    .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBUpload)
                            .addComponent(jBBack))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbUploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUploadFileActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txt_filename.setText(filename);
        Image getAbsolutePath = null;
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);

        lbl_image.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(image).getImage().getScaledInstance(lbl_image.getHeight(), lbl_image.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_jbUploadFileActionPerformed

    private void checkFullTags() {
        if (maxTags == 3) {
            jBAddTag.setEnabled(false);
        }
    }

    private void jBAddTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddTagActionPerformed
        // TODO add your handling code here:
        checkFullTags();
        boolean found = false;
        String tag = "";
        oldTag = "";
        if (jCBTags.isEnabled()) {
            tag = jCBTags.getSelectedItem().toString();
            oldTag = jLTags.getText();
            if (chosenTags.isEmpty()) {
                chosenTags.add(tag);
                found = true;
                jLTags.setText(oldTag + "   " + tag);
            } else {
                for (String tagInList : chosenTags) {
                    if (tagInList.equalsIgnoreCase(tag)) {
                        found = true;
                    }
                }
                if (!found) {
                    chosenTags.add(tag);
                    maxTags++;
                    jLTags.setText(oldTag + "   " + tag);
                }
            }

        } else if (jTFNewTag.isEnabled()) {
            tag = jTFNewTag.getText();
            oldTag = jLTags.getText();
            if (chosenTags.isEmpty()) {
                chosenTags.add(tag);
                found = true;
                jLTags.setText(oldTag + "   " + tag);
            } else {
                for (String tagInList : chosenTags) {
                    if (tagInList.equalsIgnoreCase(tag)) {
                        found = true;
                    }
                }
                if (!found) {
                    chosenTags.add(tag);
                    maxTags++;
                    jLTags.setText(oldTag + "   " + tag);
                }
            }
        }
    }//GEN-LAST:event_jBAddTagActionPerformed

    private void jBUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUploadActionPerformed
        String title = jTFTitle.getText();
        String post = jTAPost.getText();
        int userId = user.getUserID();
        String stringPostId = "";
        ArrayList<Integer> tagIds = new ArrayList<>();
        if (chosenTags.isEmpty()) {
            JOptionPane.showMessageDialog(null, "V�nligen v�lj minst en tagg!");
        } else if (Validation.checkTextField(jTFTitle) && Validation.checkTextArea(jTAPost)) {
            try {
                insertTagsJosef(chosenTags);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (txt_filename.getText().equals("")) {
                    System.out.println("den g�r in i if");
                    Database.executeUpdate("INSERT into Post (UserID, timeStamp, title, description, typeID) VALUES (" + userId + ", CURRENT_TIMESTAMP, '" + title + "','" + post + "', 1);");
                    stringPostId = Database.fetchSingle("SELECT MAX(PostID) FROM Post;");
                } else {
                    System.out.println("den g�r till else");
                    String image = txt_filename.getText();
                    image = image.replace("\\", "\\\\");
                    
                    System.out.println(image);
                    
                    Database.executeUpdate("INSERT into Post (UserID, timeStamp, title, description, typeID, Picture) "
                            + "VALUES (" + userId + ", CURRENT_TIMESTAMP, '"+ title + "','" + post + "', 1, '" + image +"')");
                    stringPostId = Database.fetchSingle("SELECT MAX(PostID) FROM Post;");

                }
                for (String tagName : chosenTags) {
                    tagIds.add(Integer.parseInt(Database.fetchSingle("SELECT TagID FROM Tag WHERE TagName = '" + tagName + "';")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error");
            }
            int postId = Integer.parseInt(stringPostId);
            try {
                for (Integer tag : tagIds) {
                    Database.executeUpdate("INSERT INTO Post_Tag (PostID, TagID) VALUES (" + postId + ", " + tag + ");");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("fel i dela");
            }

            /*if (txt_filename.getText() != null) {

                String image = txt_filename.getText();
                image = image.replace("\\", "\\\\");

                String sql = "insert into Inl�ggBild(Inl�ggID, Titel, File) values (1, '" + title + "','" + image + "')";
                try {
                    Database.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(BildTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
            JOptionPane.showMessageDialog(null, "Ditt inl�gg har publicerats");
            new FormalBlog(user).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jBUploadActionPerformed

    private void jTFNewTagMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNewTagMouseReleased
        jTFNewTag.setEnabled(true);
        jCBTags.setEnabled(false);
    }//GEN-LAST:event_jTFNewTagMouseReleased

    private void jCBTagsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBTagsMouseReleased
        jCBTags.setEnabled(true);
        jTFNewTag.setEnabled(false);
    }//GEN-LAST:event_jCBTagsMouseReleased

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormalBlog(user).setVisible(true);
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveTagActionPerformed
        // TODO add your handling code here:
        int index;
        if (chosenTags.size() == 0) {
            return;
        } else if (chosenTags.size() == 1) {
            chosenTags.remove(0);
            jLTags.setText("Taggar: ");
        } else {
            index = chosenTags.size() - 1;
            chosenTags.remove(index);
            jLTags.setText(oldTag);
        }
    }//GEN-LAST:event_jBRemoveTagActionPerformed

    private void insertTagsJosef(ArrayList<String> tagsToCheck) throws SQLException {
        ArrayList<String> rsTags = new ArrayList<>();
        String querySize = "SELECT TagName FROM Tag";
        ResultSet rs = Database.fetchRows(querySize);
        while (rs.next()) {
            rsTags.add(rs.getString(1));

        }
        for (String rsTag : rsTags) {
            System.out.println(rsTag);
        }
        for (String var : tagsToCheck) {
            boolean flagDuplicate = false;
            for (String rsTag : rsTags) {
                if (var.equalsIgnoreCase(rsTag)) {
                    flagDuplicate = true;
                }
            }

            if (flagDuplicate == false) {
                System.out.println("Inl�ggs: " + var);
                Database.executeUpdate("Insert Into Tag (TagName)Values('" + var + "')");
            }
        }

    }

    private void fillTags() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Forskning");
        tags.add("Programmering");
        tags.add("Utbildning");

        for (String tag : tags) {
            jCBTags.addItem(tag);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddTag;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBRemoveTag;
    private javax.swing.JButton jBUpload;
    private javax.swing.JComboBox<String> jCBTags;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLTags;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAPost;
    private javax.swing.JTextField jTFNewTag;
    private javax.swing.JTextField jTFTitle;
    private javax.swing.JButton jbUploadFile;
    private javax.swing.JLabel jlUplodedFile;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txt_filename;
    // End of variables declaration//GEN-END:variables

}
