import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectionDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/STUDENTJSOn";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    public static List<Student> getStudentFromDatabase() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query  = "SELECT * FROM Student";
        Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getNString("name");
            String address  =resultSet.getNString("address");
            String phone = resultSet.getString("phone");
            Date DOB = resultSet.getDate("DOB") ;
            String email = resultSet.getString("email");
            students.add(new Student(id ,name, address,phone , DOB, email));
        }
        return students;
    }
}
