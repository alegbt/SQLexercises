package src.main.java.it.develhope.exercisesSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_SQL_table {

    public static void main(String[] args) {



        String url       = "jdbc:mysql://localhost:3306/newdb";
        String user      = "developer";
        String password  = "123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO students2 (student_id, last_name, first_name)\n" +
                    "VALUES ('1','gob', 'ale');" );
            statement.execute("INSERT INTO students2 (student_id, last_name, first_name)\n" +
                    "VALUES ('2','ugo', 'pino');" );
            statement.execute("INSERT INTO students2 (student_id, last_name, first_name)\n" +
                    "VALUES ('3','rossi', 'mario');" );
            statement.execute("INSERT INTO students2 (student_id, last_name, first_name)\n" +
                    "VALUES ('4','caciotta', 'franco');" );
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }




    }
}
