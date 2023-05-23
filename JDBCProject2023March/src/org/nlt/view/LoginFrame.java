
package org.nlt.view;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JFrame  implements ParentInterface{
    
    public LoginFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        forgotpasswordButton = new javax.swing.JButton();
        signupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 20, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("USERNAME/EMAIL/PHONE");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);

        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(usernameTextField);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);
        jPanel1.add(passwordTextField);

        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        forgotpasswordButton.setText("FORGOT PASSWORD");
        forgotpasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpasswordButtonActionPerformed(evt);
            }
        });
        jPanel2.add(forgotpasswordButton);

        signupButton.setText("SIGNUP");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        jPanel2.add(signupButton);

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
          try {
              String username=usernameTextField.getText();
              String password=passwordTextField.getText();
              
              Statement smt = connect.createStatement();
              ResultSet rs = smt.executeQuery("select * from users where (email='" + username +"' or phone='"+username+"' or username='"+username+"') and password='" + password + "' and status=1");
              
              
              if (rs.next()) 
              {
                  personFrame.setVisible(true);
                  personFrame.setTitle(projectTitle+" : "+rs.getString("name"));
                  personFrame.loginUserEmail=rs.getString("email");

                  this.dispose();
              } else {
                  JOptionPane.showMessageDialog(this, "Invalid Username or Password", projectTitle, JOptionPane.ERROR_MESSAGE);
              }
              rs.close();
              smt.close();
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e, projectTitle, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
          signupFrame.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_signupButtonActionPerformed

    private void forgotpasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpasswordButtonActionPerformed
    }//GEN-LAST:event_forgotpasswordButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgotpasswordButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton signupButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

}
