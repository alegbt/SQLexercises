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
            statement.execute("CREATE TABLE IF NOT EXISTS students (\n" +
                    "    student_id  integer(10) NOT NULL AUTO_INCREMENT,\n" +
                    "    last_name  varchar(30),\n" +
                    "    first_name  varchar(30),\n" +
                    "\tCONSTRAINT students_pk PRIMARY KEY(student_id)\n" +
                    ");");

            statement.execute("INSERT INTO students (last_name, first_name)\n" +
                    "VALUES ('gob', 'ale');" );
            statement.execute("INSERT INTO students (last_name, first_name)\n" +
                    "VALUES ('ugo', 'pino');" );
            statement.execute("INSERT INTO students (last_name, first_name)\n" +
                    "VALUES ('rossi', 'mario');" );
            statement.execute("INSERT INTO students (last_name, first_name)\n" +
                    "VALUES ('verdi', 'franco');" );
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }




    }
}
