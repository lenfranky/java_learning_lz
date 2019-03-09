package learning_java.DataBase;

import java.sql.*;

public class SimpleJDBC {
    public static void main(String[] args)
        throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC", "lenfranky", "tiger");
        System.out.println("Database connected!");

        connection.close();
    }
}
