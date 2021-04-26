package projekt.frames;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import projekt.Refactor;
import projekt.User;
import projekt.helpers.Database;

public class Blog extends javax.swing.JFrame {

    String queryFormal;
    String queryInformal;
    String queryAllPosts;
    User user;
    boolean isFormal;

    /**
     * Creates new form Blog
     */
    public Blog() {
        queryFormal = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.timeStamp FROM User, Post WHERE Post.UserID = User.UserID AND TypeID = 1;";
        queryInformal = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.timeStamp FROM User, Post WHERE Post.UserID = User.UserID AND TypeID = 2;";
        queryAllPosts = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.timeStamp FROM User, Post WHERE Post.UserID = User.UserID";
        initComponents();
    }

    public Blog(User user, boolean getFormal) {
        this();
        this.isFormal = getFormal;
        this.user = user;
        if (getFormal && user != null) {
            try {
                jTable1 = Refactor.populateTable(Database.fetchRows(queryFormal));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
            try {
                jTable1 = Refactor.populateTable(Database.fetchRows(queryInformal));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (user == null) {
                btnMakePost.setVisible(false);
            }
        }
        initTable();
    }

    public Blog(String search, User user) {
        this();
        this.user = user;

        String searchQuery;
        searchQuery = "SELECT Post.postID, User.firstName, User.lastName, Post.title, Post.description, Tag.TagName FROM User "
                + "JOIN Post ON User.UserID = Post.UserID "
                + "JOIN Post_Tag ON Post.PostID = Post_Tag.PostID JOIN Tag ON Post_Tag.TagId = Tag.TagId "
                + "AND (User.firstName LIKE '%" + search + "%'OR User.lastName LIKE '%" + search + "%' OR Post.title LIKE '%" + search + "%'OR Post.description LIKE '%" + search + "%' OR Tag.TagName LIKE '%" + search + "%') "
                + "GROUP BY Post.PostID;";
        try {
            jTable1 = Refactor.populateTable(Database.fetchRows(searchQuery));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        initTable();
    }

    private void initTable() {

        jScrollPane1.setViewportView(jTable1);
        jTable1.setVisible(true);
//		
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    Refactor.showPostByPostID(user, jTable1);
                    blogDispose();
                }
            }
        });
    }

    private void blogDispose() {

        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnMakePost = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        btnMakePost.setBackground(new java.awt.Color(204, 204, 255));
        btnMakePost.setText("Gör Inlägg");
        btnMakePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakePostActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMakePost))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnMakePost))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMakePostActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMakePostActionPerformed
    {//GEN-HEADEREND:event_btnMakePostActionPerformed
        this.dispose();
        if (isFormal) {
            new MakeFormalPost(user).setVisible(true);
        } else {
            new MakeInformalPost(user).setVisible(true);
        }
    }//GEN-LAST:event_btnMakePostActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMakePost;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
