/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.frames;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import projekt.helpers.Database;
import projekt.helpers.Validation;
import projekt.Refactor;

/**
 *
 * @author Amand
 */
public class UpdateDeleteUser extends javax.swing.JFrame
{

	ResultSet rs;
	private javax.swing.JTable table2;

	/**
	 * Creates new form UpdateDeleteUser
	 */
	public UpdateDeleteUser()
	{

		initComponents();

		getResultset();
		try {
			table2 = new JTable(Refactor.tableModelBuilder(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jScrollPane1.setViewportView(table2);
		table2.setVisible(true);
	}

	public void getResultset()
	{
		//K�r emot Databasen och h�mtar raderna fr�n User
		try {
			rs = Database.fetchRows("SELECT * FROM User");
		} catch (Exception ex) {
			ex.printStackTrace();
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
        jTable1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        changeInformationButton = new javax.swing.JButton();
        jtfID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Firstname", "Lastname", "Email", "Password", "Adminstatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        deleteButton.setText("Ta bort");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        changeInformationButton.setText("�ndra information");
        changeInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInformationButtonActionPerformed(evt);
            }
        });

        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });

        jLabel1.setText("V�nlige ange UserID p� anv�ndaren du vill �ndra eller ta bort");

        jBBack.setText("Tillbaka");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfID)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(changeInformationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(132, 132, 132)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeInformationButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jBBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
		if (Validation.isInt(jtfID) && Validation.isStringNull(jtfID.getText())) {
			int tempId = Integer.parseInt(jtfID.getText());
			String updatePost = "Update Post SET UserID = 11 Where UserID = " + tempId;
			String delUser = "Delete from User where UserID =" + tempId;
			String delMeeting = "Delete from Meeting where UserID =" + tempId;
			String delMetAt = "Delete from Meeting_Attandence where UserID =" + tempId;
			String delPost = "Delete from Post where UserID =" + tempId;
                        String delCom = "Delete from Comments where UserID =" + tempId;
                        String updatCom = "Update Comments Set UserID = 11 Where UserID = " + tempId;
                        
			if (idKoll() == false) {
				return;
			}
			int dialog = JOptionPane.showConfirmDialog(null, "�r s�ker p� att du vill ta bort denna anv�ndaren");
			if (dialog == JOptionPane.YES_OPTION) {
				int dialog2 = JOptionPane.showConfirmDialog(null, "Vill du spara anv�ndarens inl�gg?");

				try {

					if (dialog2 == JOptionPane.YES_OPTION) {
						Database.executeUpdate(updatePost);//set posts ownership to deleted user
                                                Database.executeUpdate(updatCom);
                                                Database.executeUpdate(delMetAt);
						Database.executeUpdate(delMeeting);
						Database.executeUpdate(delUser);

						JOptionPane.showMessageDialog(null, "Anv�ndaren �r nu borttagen");
						new UpdateDeleteUser().setVisible(true);
						this.dispose();

					} else if (dialog2 == JOptionPane.NO_OPTION) {
						Database.executeUpdate("DELETE FROM Post_Tag WHERE PostID in (SELECT PostID FROM Post WHERE UserID = " + tempId + ")");
                                                Database.executeUpdate(delCom);
                                                Database.executeUpdate(delPost);
                                                Database.executeUpdate(delMetAt);
						Database.executeUpdate(delMeeting);
						Database.executeUpdate(delUser);
						

						JOptionPane.showMessageDialog(null, "Anv�ndaren och dess inl�gg �r nu borttagna");
						new UpdateDeleteUser().setVisible(true);
						this.dispose();

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jtfIDActionPerformed

    private void changeInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInformationButtonActionPerformed

		if (Validation.isInt(jtfID) && Validation.isStringNull(jtfID.getText())) {
			int tempId = Integer.parseInt(jtfID.getText());
			try {
				String validId = Database.fetchSingle("SELECT UserID FROM User WHERE UserID =" + tempId);
				if (validId != null) {
					new EditUsers(tempId).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Var god ange ett giltigt UserID!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


    }//GEN-LAST:event_changeInformationButtonActionPerformed

    private void jBBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackActionPerformed
		this.dispose();
    }//GEN-LAST:event_jBBackActionPerformed

	private boolean idKoll()
	{
		int tempId = Integer.parseInt(jtfID.getText());
		try {
			String validId = Database.fetchSingle("SELECT UserID FROM User WHERE UserID =" + tempId);
			if (validId == null) {
				JOptionPane.showMessageDialog(null, "Var god ange ett giltigt UserID!");
				new UpdateDeleteUser().setVisible(true);
				this.dispose();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeInformationButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jBBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfID;
    // End of variables declaration//GEN-END:variables
}
