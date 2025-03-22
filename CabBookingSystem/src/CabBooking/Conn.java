package CabBookingSystem;


import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL, change credentials if needed
            String url = "jdbc:mysql://localhost:3306/cbs1"; // Ensure database is running
            String username = "root"; // Your MySQL username
            String password = "Ansh2005#"; // Your MySQL password

            // Establish connection
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection error: " + e);
        }
    }
}