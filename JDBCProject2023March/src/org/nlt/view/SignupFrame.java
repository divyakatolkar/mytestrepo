
package org.nlt.view;

import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
import static org.nlt.view.ParentInterface.connect;
import static org.nlt.view.ParentInterface.loginFrame;
import static org.nlt.view.ParentInterface.projectTitle;


public class SignupFrame extends javax.swing.JFrame {

    
    public SignupFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailidTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        signupButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 20, 20));

        jLabel1.setText("ENTER NAME");
        jPanel1.add(jLabel1);
        jPanel1.add(nameTextField);

        jLabel2.setText("ENTER EMAIL ID");
        jPanel1.add(jLabel2);
        jPanel1.add(emailidTextField);

        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3);
        jPanel1.add(usernameTextField);

        jLabel4.setText("PHONE");
        jPanel1.add(jLabel4);
        jPanel1.add(phoneTextField);

        signupButton.setText("SIGNUP");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        jPanel1.add(signupButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        try {
            String name = nameTextField.getText().toUpperCase();
            String username = usernameTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailidTextField.getText();
            
            if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid Input", projectTitle, JOptionPane.ERROR_MESSAGE);
                
            } else {
                Random r = new Random();
                int password = r.nextInt(1000000);
                
                Statement smt = connect.createStatement();
                smt.execute("insert into users(name,username,email,phone,password,status) values ('"+name+"', '"+username+"', '"+email+"', '"+phone+"', '"+password+"', 1)");
                smt.close();
                
                Mailer.send("divyakatolkar@gmail.com", "fadephzjyeiasvlp", email, "New Login Credential", "Your Login Password For New Account Is: " + password);
                JOptionPane.showMessageDialog(this, "Your Login Credential Sent On Your Registered Email Id\nplease Check Your Email Id", projectTitle, JOptionPane.ERROR_MESSAGE);
                loginFrame.setVisible(true);
                this.dispose();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, projectTitle, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailidTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton signupButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
