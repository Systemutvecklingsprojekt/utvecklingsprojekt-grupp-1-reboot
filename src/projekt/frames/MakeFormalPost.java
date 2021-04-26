package projekt.frames;

import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import projekt.helpers.Database;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projekt.User;
import projekt.helpers.Validation;

/**
 *
 * @author team1
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
        jBRemoveFile = new javax.swing.JButton();

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

        jBRemoveTag.setBackground(new java.awt.Color(204, 204, 255));
        jBRemoveTag.setText("Ta bort tagg");
        jBRemoveTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveTagActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTags, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jbUploadFile)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jlUplodedFile))
                                        .addComponent(jBRemoveFile))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jBBack))
                            .addGap(27, 27, 27)
                            .addComponent(jBUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTFNewTag, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBRemoveTag, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBAddTag, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBRemoveFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBBack)
                                .addGap(39, 39, 39))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBUpload)
                        .addGap(40, 40, 40))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Denna metod kallas n�r anv�ndaren vill ladda upp en fil fr�n datorn.
     * @param evt Parameter som tar in en ActionEvent
     */
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

    /**
     * Metod som kollar antalet taggar p� inl�gget.
     */
    private void checkFullTags() {
        if (maxTags == 3) {
            jBAddTag.setEnabled(false);
        } else {
            jBAddTag.setEnabled(true);
        }
    }

    /**
     * Metod f�r att l�gga till taggar p� en label.
     * @param evt 
     */
    private void jBAddTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddTagActionPerformed
        checkFullTags();
        boolean found = false;
        String tag = "";
        oldTag = "";
        //V�lj om tagg fr�n jComboBox eller jTextField ska tas med
        if (jCBTags.isEnabled()) {
            tag = jCBTags.getSelectedItem().toString();
            oldTag = jLTags.getText();
            if (chosenTags.isEmpty()) {
                chosenTags.add(tag);
                found = true;
                jLTags.setText(oldTag + "   " + tag);
            } else {
                //Kollar s� att duplicates inte l�ggs till
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

    /**
     * Metod f�r att ladda upp inl�gg i databasen.
     * @param evt 
     */
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
                //L�gger in taggar i databasen
                insertTagsJosef(chosenTags);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                //L�gger in i Post.
                if (txt_filename.getText().equals("")) {
                    Database.executeUpdate("INSERT into Post (UserID, timeStamp, title, description, typeID) VALUES (" + userId + ", CURRENT_TIMESTAMP, '" + title + "','" + post + "', 1);");
                    stringPostId = Database.fetchSingle("SELECT MAX(PostID) FROM Post;");
                    notis();
                } else {
                    String image = txt_filename.getText();
                    image = image.replace("\\", "\\\\");

                    Database.executeUpdate("INSERT into Post (UserID, timeStamp, title, description, typeID, Picture) "
                            + "VALUES (" + userId + ", CURRENT_TIMESTAMP, '" + title + "','" + post + "', 1, '" + image + "')");
                    stringPostId = Database.fetchSingle("SELECT MAX(PostID) FROM Post;");
                    notis();

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
            JOptionPane.showMessageDialog(null, "Ditt inl�gg har publicerats");
            new Blog(user, true).setVisible(true);
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
        new Blog(user, true).setVisible(true);
    }//GEN-LAST:event_jBBackActionPerformed

    /**
     * Metod f�r att ta bort taggar fr�n label i MakeFormalPost
     * @param evt 
     */
    private void jBRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveTagActionPerformed
        checkFullTags();
        int index;
        //Anv�nder oss av StringBuilder f�r att komma �t append()
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

    private void jBRemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveFileActionPerformed
        txt_filename.setText("");
        lbl_image.setVisible(false);
    }//GEN-LAST:event_jBRemoveFileActionPerformed

    /**
     * Metod f�r att s�tta in taggarna i databasen
     * @param tagsToCheck ArrayList<String> som inneh�ller taggarna som ska s�ttas in.
     * @throws SQLException 
     */
    private void insertTagsJosef(ArrayList<String> tagsToCheck) throws SQLException {
        ArrayList<String> rsTags = new ArrayList<>();
        String querySize = "SELECT TagName FROM Tag";
        ResultSet rs = Database.fetchRows(querySize);
        while (rs.next()) {
            rsTags.add(rs.getString(1));
        }
        //Kollar om det finns duplicates
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
    /**
     * Metod f�r att skapa en notis f�r anv�ndare som vill se detta inl�gg.
     */
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
            System.out.println("N�got fel med inserts");
        
        }

        
    }
    }
    
    private boolean prem() {
        ArrayList test;
        boolean resultat = true;
        try {
            test = Database.fetchColumn("Select UserSubscriberID from UserPrem where UserCreatorID = " + user.getUserID() +";");
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
