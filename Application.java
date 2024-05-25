import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        //Load Date
        List<Student> students = ConnectionDB.getStudentFromDatabase();
        //ghi file JSON
        String filePath = "Student.json";
        StudentToJsonFileWrite.writeStudentToJsonFile(students,filePath);
        System.out.println("DATA has been written to " +filePath);
    }
}
