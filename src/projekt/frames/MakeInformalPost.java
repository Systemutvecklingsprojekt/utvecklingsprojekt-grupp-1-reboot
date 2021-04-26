
package projekt.frames;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projekt.User;
import projekt.helpers.Database;
import projekt.helpers.Validation;


public class MakeInformalPost extends javax.swing.JFrame {

    private int maxTags;
    private ArrayList<String> chosenTags;
    private User user;
    private String oldTag;

    public MakeInformalPost(User user) {
        this.user = user;
        maxTags = 0;
        chosenTags = new ArrayList<>();
        oldTag = "";

        initComponents();
        fillTags();
        jTFNewTag.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser2 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAPost = new javax.swing.JTextArea();
        jTFTitle = new javax.swing.JTextField();
        jCBTags = new javax.swing.JComboBox<>();
        jTFNewTag = new javax.swing.JTextField();
        jbUpload = new javax.swing.JButton();
        jbUploadFile = new javax.swing.JButton();
        jBAddTag = new javax.swing.JButton();
        jLTags = new javax.swing.JLabel();
        jlUplodedFile = new javax.swing.JLabel();
        jBBack = new javax.swing.JButton();
        txt_filename = new javax.swing.JTextField();
        lbl_image = new javax.swing.JLabel();
        jBRemoveFile = new javax.swing.JButton();
        jBRemoveTag = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTAPost.setColumns(20);
        jTAPost.setRows(5);
        jScrollPane1.setViewportView(jTAPost);

        jTFTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTitleActionPerformed(evt);
            }
        });

        jCBTags.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCBTagsMouseReleased(evt);
            }
        });

        jTFNewTag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTFNewTagMouseReleased(evt);
            }
        });
        jTFNewTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNewTagActionPerformed(evt);
            }
        });

        jbUpload.setBackground(new java.awt.Color(204, 204, 255));
        jbUpload.setText("Dela");
        jbUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUploadActionPerformed(evt);
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
        jBAddTag.setText("Lägg till tagg");
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

        txt_filename.setEditable(false);

        jBRemoveFile.setBackground(new java.awt.Color(204, 204, 255));
        jBRemoveFile.setText("Ta bort fil");
        jBRemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveFileActionPerformed(evt);
            }
        });

        jBRemoveTag.setBackground(new java.awt.Color(204, 204, 255));
        jBRemoveTag.setText("Ta bort tagg");
        jBRemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveTagActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Gör ett informellt inlägg");

        jLabel2.setText("Lägg till en rubrik:");

        jLabel3.setText("Lägg till kategori:");

        jLabel4.setText("Lägg till en tagg:");

        jLabel5.setText("Lägg till en bildfil:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTFNewTag, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBRemoveTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBAddTag, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))
                            .addComponent(jLTags, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbUploadFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBRemoveFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jlUplodedFile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addComponent(jbUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFNewTag, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAddTag)
                        .addGap(8, 8, 8)
                        .addComponent(jBRemoveTag)))
                .addGap(18, 18, 18)
                .addComponent(jLTags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUploadFile)
                    .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUplodedFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBRemoveFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jBBack))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbUploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUploadFileActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            if (f != null) {
                String filename = f.getAbsolutePath();
                if (Validation.isImageValid(filename)) {
                    txt_filename.setText(filename);
                    Image getAbsolutePath = null;
                    javax.swing.ImageIcon icon = new javax.swing.ImageIcon(filename);
                    Image image = icon.getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
                    lbl_image.setVisible(true);
                    lbl_image.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(image).getImage().getScaledInstance(lbl_image.getHeight(), lbl_image.getHeight(), Image.SCALE_SMOOTH)));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbUploadFileActionPerformed

    private void checkFullTags() {
        
        if (maxTags == 3) {
            jBAddTag.setEnabled(false);
        } else {
            jBAddTag.setEnabled(true);
        }
    }

    private void jBAddTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddTagActionPerformed
      
        checkFullTags();
        boolean found = false;
        String tag = "";
        String oldTag = "";
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

    private void insertTags(ArrayList<String> tagsToCheck) throws SQLException {
        ArrayList<String> rsTags = new ArrayList<>();
        String querySize = "SELECT TagName FROM Tag";
        ResultSet rs = Database.fetchRows(querySize);
        while (rs.next()) {
            rsTags.add(rs.getString(1));

        }
     
        for (String var : tagsToCheck) {
            boolean flagDuplicate = false;
            for (String rsTag : rsTags) {
                if (var.equalsIgnoreCase(rsTag)) {
                    flagDuplicate = true;
                }
            }
            if (flagDuplicate == false) {
              
                Database.executeUpdate("Insert Into Tag (TagName)Values('" + var + "')");
            }
        }
    }

    private void jbUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUploadActionPerformed
        String title = jTFTitle.getText();
        String post = jTAPost.getText();
        int userId = user.getUserID();
        String stringPostId = "";
        ArrayList<Integer> tagIds = new ArrayList<>();

        if (chosenTags.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vänligen välj minst en tagg!");

        } else if (Validation.checkTextField(jTFTitle) && Validation.checkTextArea(jTAPost)) {
            try {
                insertTags(chosenTags);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (txt_filename.getText().equals("")) {
                    Database.executeUpdate("INSERT into Post (UserID, timeStamp, title, description, typeID) VALUES (" + userId + ", CURRENT_TIMESTAMP, '" + title + "','" + post + "', 2);");
                    stringPostId = Database.fetchSingle("SELECT MAX(PostID) FROM Post;");
                    notis();
                } else {
                    
                    String image = txt_filename.getText();
                    image = image.replace("\\", "\\\\");

                    Database.executeUpdate("INSERT into Post (UserID, timeStamp, title, description, typeID, Picture) "
                            + "VALUES (" + userId + ", CURRENT_TIMESTAMP, '" + title + "','" + post + "', 2, '" + image + "')");
                    stringPostId = Database.fetchSingle("SELECT MAX(PostID) FROM Post;");
                    notis();

                }

                for (String tagName : chosenTags) {
                    tagIds.add(Integer.parseInt(Database.fetchSingle("SELECT TagID FROM Tag WHERE TagName = '" + tagName + "';")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
               
            }
            int postId = Integer.parseInt(stringPostId);
            try {
                for (Integer tag : tagIds) {
                    Database.executeUpdate("INSERT INTO Post_Tag (PostID, TagID) VALUES (" + postId + ", " + tag + ");");
                }

            } catch (SQLException e) {
                e.printStackTrace();
               
            }
            JOptionPane.showMessageDialog(null, "Ditt inlägg har publicerats");

            new Blog(user, false).setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_jbUploadActionPerformed

    private void jTFNewTagMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFNewTagMouseReleased
       jTFNewTag.setEnabled(true);
        jCBTags.setEnabled(false);
    }//GEN-LAST:event_jTFNewTagMouseReleased

    private void jCBTagsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBTagsMouseReleased
        jCBTags.setEnabled(true);
        jTFNewTag.setEnabled(false);
    }//GEN-LAST:event_jCBTagsMouseReleased

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
        this.dispose();
        new Blog(user, false).setVisible(true);
    }//GEN-LAST:event_jBBackActionPerformed

    private void jBRemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveFileActionPerformed
        txt_filename.setText("");
        lbl_image.setVisible(false);
    }//GEN-LAST:event_jBRemoveFileActionPerformed

    private void jBRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveTagActionPerformed
        checkFullTags();
        int index;
        StringBuilder str = new StringBuilder("Taggar: ");
        if (chosenTags.isEmpty()) {
            return;
        } else if (chosenTags.size() == 1) {
            chosenTags.remove(0);
            jLTags.setText(str.toString());
        } else {
            index = chosenTags.size() - 1;
            chosenTags.remove(index);
            for (String tag : chosenTags) {
                jLTags.setText(str.append(tag + "   ").toString());
            }
        }
    }//GEN-LAST:event_jBRemoveTagActionPerformed

    private void jTFTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTitleActionPerformed

    private void jTFNewTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNewTagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNewTagActionPerformed

    private void fillTags() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("AW");
        tags.add("Vänner");
        tags.add("Solsken");

        for (String tag : tags) {
            jCBTags.addItem(tag);
        }
    }
    
    private void notis() {
        ArrayList subs;
        int notisID;
        int postID;
        LocalDateTime now = LocalDateTime.now();    
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formatDateTime = now.format(format) + ".000"; 
        
        if(prem()) {
        try {
           
           subs = Database.fetchColumn("Select UserSubscriberID from UserPrem where UserCreatorID= " + user.getUserID() +";");
           Database.executeUpdate("Insert into Notice (Topic, DateTime, NoticeTypeID) VALUES ('" + jTFTitle.getText() + "','" + formatDateTime + "', 2)");
           notisID = Integer.parseInt(Database.fetchSingle("Select NoticeID from Notice Where NoticeID = (Select max(NoticeID) from Notice)"));
           postID = Integer.parseInt(Database.fetchSingle("Select PostID from Post Where PostID = (Select max(PostID) from Post)"));
           Database.executeUpdate("Insert into Notice_Post (NID, PID) Values (" + notisID + "," + postID + ")");

           
           for(int i = 0; i < subs.size(); i++) {
               int subID = Integer.parseInt(subs.get(i).toString());
               Database.executeUpdate("Insert into User_Notice (NID, UID) VALUES (" + notisID + "," + subID + ")");
           }
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        }
    
    }
    
    private boolean prem() {
        ArrayList test;
        boolean resultat = true;
        try {
            test = Database.fetchColumn("Select UserSubscriberID from UserPrem where UserCreatorID= " + user.getUserID() +";");
            
            if(test.isEmpty()) {
                resultat = false;
                return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            resultat = false;
        }
        return resultat;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddTag;
    private javax.swing.JButton jBBack;
    private javax.swing.JButton jBRemoveFile;
    private javax.swing.JButton jBRemoveTag;
    private javax.swing.JComboBox<String> jCBTags;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLTags;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTAPost;
    private javax.swing.JTextField jTFNewTag;
    private javax.swing.JTextField jTFTitle;
    private javax.swing.JButton jbUpload;
    private javax.swing.JButton jbUploadFile;
    private javax.swing.JLabel jlUplodedFile;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txt_filename;
    // End of variables declaration//GEN-END:variables

}
