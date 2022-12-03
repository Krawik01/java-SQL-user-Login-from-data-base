import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection connection = getConnection();

        Statement statement = connection.createStatement();
       // PreparedStatement preparedStatement = connection.prepareStatement("use users");
        statement.executeUpdate("use users");


        ResultSet rs = statement.executeQuery("select * from Users");

    }
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/?user=root";
            System.out.println(DriverManager.getDriver(url));
            String userName = "root";
            String password = "Kurczak12@";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,userName,password);
            System.out.println("Connected with data base");
            return con;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;

    }
}
