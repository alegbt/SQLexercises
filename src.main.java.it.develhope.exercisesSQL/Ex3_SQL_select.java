package src.main.java.it.develhope.exercisesSQL;

import java.sql.*;
import java.util.ArrayList;

public class Ex3_SQL_select {
    public static void main(String[] args) {

        String url       = "jdbc:mysql://localhost:3306/newdb";
        String user      = "developer";
        String password  = "123";
        ArrayList<String> studentsList = new ArrayList<>();


        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement statement = con.createStatement();
            String query = "Select * from students";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                studentsList.add(rs.getString("first_name"));
            }
            for(String x : studentsList){System.out.println(x);}

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }






    }
}
