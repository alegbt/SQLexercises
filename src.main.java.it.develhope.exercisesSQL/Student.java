package src.main.java.it.develhope.exercisesSQL;

import java.sql.*;
import java.util.ArrayList;

public class Student {





        String name;
        String surname;

    public Student(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName () {
            return name;
        }

        public String getSurname () {
            return surname;
        }




    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "123";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            Statement statement = con.createStatement();

            String italian_students = "CREATE OR REPLACE VIEW italian_students AS SELECT first_name, last_name FROM newdb.students WHERE country = \"Italy\";";
            String german_students = "CREATE OR REPLACE VIEW german_students AS SELECT first_name, last_name FROM newdb.students WHERE country = \"Germany\";";

            PreparedStatement preparedStatement = con.prepareStatement(italian_students);
            PreparedStatement preparedStatement2 = con.prepareStatement(german_students);

            preparedStatement.execute();
            preparedStatement2.execute();

            ArrayList<Student> italianStudents = new ArrayList<>();
            String getIta = "Select * from italian_students";
            ResultSet rs1 = statement.executeQuery(getIta);

            while (rs1.next()){
                italianStudents.add(new Student(rs1.getString("first_name"), rs1.getString("last_name") ));
            }
            rs1.close();

            ArrayList<Student> germananStudents = new ArrayList<>();
            String getGer = "Select * from german_students";
            ResultSet rs2 = statement.executeQuery(getGer);

            while (rs2.next()){
                germananStudents.add(new Student(rs2.getString("first_name"),rs2.getString("last_name") ));
            }
            rs2.close();

            for(Student x : italianStudents){
                System.out.println("ita= "+x.getName()+" "+ x.getSurname());
            }

            for(Student x : germananStudents){
                System.out.println("ger= "+x.getName()+" "+ x.getSurname());
            }

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }




    }





}
