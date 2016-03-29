import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
 
public class MaximumTableNameLength {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/userdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
 
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            DatabaseMetaData metadata = connection.getMetaData();
 
            //
            // Get the information of maximum length of database table name
            //
            int maxLength = metadata.getMaxTableNameLength();
            System.out.println("Max Table Name Length = " + maxLength);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}