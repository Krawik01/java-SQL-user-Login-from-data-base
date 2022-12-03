import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private final String url;
    private final String userName;
    private final String password;


    public Connect(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, userName, password);

            System.out.println("Connected with db.");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
