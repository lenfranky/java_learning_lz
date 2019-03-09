package learning_java.DataBase;

import java.sql.*;

public class TestResultSetMetaData {
    public TestResultSetMetaData() {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC", "lenfranky", "tiger");
        System.out.println("Database connected");
        DatabaseMetaData dbMetaData = connection.getMetaData();
        System.out.println("database URL: " + dbMetaData.getURL());
        System.out.println("database username: " + dbMetaData.getUserName());
        System.out.println("database product name: " + dbMetaData.getDatabaseProductName());
        System.out.println("database product version: " + dbMetaData.getDatabaseProductVersion());
        System.out.println("JDBC driver name: " + dbMetaData.getDriverName());
        System.out.println("JDBC driver version: " + dbMetaData.getDriverVersion());
        System.out.println("JDBC driver major version: " + dbMetaData.getDriverMajorVersion());
        System.out.println("JDBC driver minor version: " + dbMetaData.getDriverMinorVersion());
        System.out.println("Max number of connections: " + dbMetaData.getMaxConnections());
        System.out.println("MaxTableNameLength: " + dbMetaData.getMaxTableNameLength());
        System.out.println("MaxColumnsInTable: " + dbMetaData.getMaxColumnsInTable());

        System.out.println("\n-----------------------------------------------------------------------------------------\n");

//        DatabaseMetaData dbMetaData = connection.getMetaData();
        ResultSet rsTables = dbMetaData.getTables((String)null, (String)null, (String)null, new String[]{"TABLE"});
        System.out.print("User tables: ");

        while(rsTables.next()) {
            System.out.print(rsTables.getString("TABLE_NAME") + " ");
        }

        System.out.println("\n-----------------------------------------------------------------------------------------\n");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from WEBSITES");
        ResultSetMetaData rsMetaData = resultSet.getMetaData();

        int i;
        for(i = 1; i <= rsMetaData.getColumnCount(); ++i) {
            System.out.printf("%-16s\t", rsMetaData.getColumnName(i));
        }

        System.out.println();

        while(resultSet.next()) {
            for(i = 1; i <= rsMetaData.getColumnCount(); ++i) {
                System.out.printf("%-16s\t", resultSet.getObject(i));
            }

            System.out.println();
        }

        connection.close();
    }
}
