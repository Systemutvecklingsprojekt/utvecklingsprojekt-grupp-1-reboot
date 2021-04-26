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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTAPost.setColumns(20);
        jTAPost.setRows(5);
        jScrollPane1.setViewportView(jTAPost);

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

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Gör ett formellt inlägg");

        jLabel2.setText("Lägg till en rubrik:");

        jLabel3.setText("Lägg till kategori:");

        jLabel4.setText("Lägg till en bildfil:");

        jLabel5.setText("Dela inlägg:");

        jLabel6.setText("Lägg till en tagg:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jlUplodedFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTags, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTFNewTag, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBRemoveTag, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jBAddTag, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbUploadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBRemoveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAddTag)
                    .addComponent(jTFNewTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRemoveTag)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbUploadFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemoveFile))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlUplodedFile)
                                .addComponent(txt_filename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBUpload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jBBack)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Denna metod kallas när användaren vill ladda upp en fil från datorn.
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
     * Metod som kollar antalet taggar på inlägget.
     */
    private void checkFullTags() {
        if (maxTags == 3) {
            jBAddTag.setEnabled(false);
        } else {
            jBAddTag.setEnabled(true);
        }
    }

    /**
     * Metod för att lägga till taggar på en label.
     * @param evt 
     */
    private void jBAddTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddTagActionPerformed
        checkFullTags();
        boolean found = false;
        String tag = "";
        oldTag = "";
        //Välj om tagg från jComboBox eller jTextField ska tas med
        if (jCBTags.isEnabled()) {
            tag = jCBTags.getSelectedItem().toString();
            oldTag = jLTags.getText();
            if (chosenTags.isEmpty()) {
                chosenTags.add(tag);
                found = true;
                jLTags.setText(oldTag + "   " + tag);
            } else {
                //Kollar så att duplicates inte läggs till
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
     * Metod för att ladda upp inlägg i databasen.
     * @param evt 
     */
    private void jBUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUploadActionPerformed
        String title = jTFTitle.getText();
        String post = jTAPost.getText();
        int userId = user.getUserID();
        String stringPostId = "";
        ArrayList<Integer> tagIds = new ArrayList<>();
        if (chosenTags.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vänligen välj minst en tagg!");
        } else if (Validation.checkTextField(jTFTitle) && Validation.checkTextArea(jTAPost)) {
            try {
                //Lägger in taggar i databasen
                insertTagsJosef(chosenTags);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                //Lägger in i Post.
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
            JOptionPane.showMessageDialog(null, "Ditt inlägg har publicerats");
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
     * Metod för att ta bort taggar från label i MakeFormalPost
     * @param evt 
     */
    private void jBRemoveTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveTagActionPerformed
        checkFullTags();
        int index;
        //Använder oss av StringBuilder för att komma åt append()
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
     * Metod för att sätta in taggarna i databasen
     * @param tagsToCheck ArrayList<String> som innehåller taggarna som ska sättas in.
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
                System.out.println("Inläggs: " + var);
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
     * Metod för att skapa en notis för användare som vill se detta inlägg.
     */
    private void notis() {
        ArrayList subs;
        int notisID;
        int postID;
        //Gör om localdatetimenow (Systemets klocka) till ett godtagbart format för tabellen Notice
        LocalDateTime now = LocalDateTime.now();    
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formatDateTime = now.format(format) + ".000"; 
        
        //Lägger till notiser i tabellerna om prem ger true
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
            System.out.println("Något fel med inserts");
        
        }

        
    }
    }
    //Metod som kollar om det finns prenumerationer hos användaren som skapar ett inlägg, ger en boolean
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTAPost;
    private javax.swing.JTextField jTFNewTag;
    private javax.swing.JTextField jTFTitle;
    private javax.swing.JButton jbUploadFile;
    private javax.swing.JLabel jlUplodedFile;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txt_filename;
    // End of variables declaration//GEN-END:variables

}
