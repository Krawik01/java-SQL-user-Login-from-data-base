import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception,SQLException {
        String url = "jdbc:mysql://localhost:3306/?user=root";
        String userName = "root";
        String password = "Kurczak12@";

        Connect connect = new Connect(url,userName,password);

        Connection connection = connect.getConnection();
        Statement statement =  connection.createStatement();
        statement.executeUpdate("use users");



        UserService userService = new UserService(connection,statement);

        userService.systemLogIn();
    }

}
