import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserService {
    
    private static Connection connection;
    private static Statement statement;

    public UserService(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    public static String userLogin() throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("use users");


        System.out.println("Login:");
        Scanner userNameScanner = new Scanner(System.in);
        int userID = Integer.parseInt(userNameScanner.nextLine());

        System.out.println("Password: ");
        Scanner userPasswordScanner = new Scanner(System.in);
        String userPassword = userPasswordScanner.nextLine();


        ResultSet logIn = statement.executeQuery(
                "SELECT * " +
                        "FROM usersTable " +
                        "where USERSTABLE.ID = " +"\'" + userID + "\'" + " &&" +
                        " usersTable.password =" + "\'" + userPassword + "\'"
        );
        String result = null;
        while (logIn.next()){
            int id = logIn.getInt("ID");
            String name = logIn.getString("NAME");
            String password = logIn.getString("PASSWORD");
            result = (id + " " + name + " " + password);
        }
        return result;
    }

    public static void dataCheck(String logInResult) throws SQLException{
        while (logInResult == null) {
            System.out.println("wrong login or password\nTry again");
            logInResult = userLogin();
        }

        System.out.println("user logged in successfully");
        System.out.print("Hi ");
        int userID = Integer.parseInt(String.valueOf(logInResult.charAt(0)));
        ResultSet resultSet = statement.executeQuery("" +
                "SELECT NAME " +
                "FROM USERSTABLE " +
                "WHERE USERSTABLE.ID =" + "\'" + userID + "\'");
        while (resultSet.next()) {
            String loggedName = resultSet.getString("NAME");
            System.out.print(loggedName);

        }
    }

    public void systemLogIn() throws SQLException {

        boolean logged = false;

        while(!logged) {
            try {
                String logInResult = userLogin();
                dataCheck(logInResult);
                logged = true;
            } catch (NumberFormatException e) {
                System.out.println("Wrong data type\nTry again");
            }
        }

    }
}
