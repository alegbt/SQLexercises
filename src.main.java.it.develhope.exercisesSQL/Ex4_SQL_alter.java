package src.main.java.it.develhope.exercisesSQL;

import java.sql.*;


public class Ex4_SQL_alter {

    public static void main(String[] args) {

                String url       = "jdbc:mysql://localhost:3306/newdb";
                String user      = "developer";
                String password  = "123";

                try (Connection con = DriverManager.getConnection(url, user, password)) {
                        Statement statement = con.createStatement();

                        statement.execute("ALTER TABLE students ADD COLUMN country CHAR(30)");

                        String upd = "UPDATE students SET country = 'Italy' WHERE student_id < 3";
                        String upd2 = "UPDATE students SET country = 'Germany' WHERE student_id > 2";
                        PreparedStatement preparedStatement = con.prepareStatement(upd);
                        PreparedStatement preparedStatement2 = con.prepareStatement(upd2);

                        preparedStatement.execute();
                        preparedStatement2.execute();

                        int numberUpdate = preparedStatement.executeUpdate();
                        int numberUpdate2 = preparedStatement2.executeUpdate();

                        System.out.println(numberUpdate + " rows updated" + "\n" + numberUpdate2 + " rows updated2");

                }catch(SQLException e) {
                    System.out.println(e.getMessage());
                }


    }
}
