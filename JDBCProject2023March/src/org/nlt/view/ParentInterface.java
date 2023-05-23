package org.nlt.view;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public interface ParentInterface  {

    public Connection connect = getDatabaseConnection();
    public String projectTitle = "NLT JDBC CRUD";
    
    public LoginFrame loginFrame = new LoginFrame();
    public PersonFrame personFrame = new PersonFrame();
    public SignupFrame signupFrame = new SignupFrame();
    public ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame();
    
    public static Connection getDatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/divya", "root", "");
            System.out.println("Connectivity received & ready in connect");
            return con;
        } catch (Exception ex) {
           
            return null;
        }
    }
}

