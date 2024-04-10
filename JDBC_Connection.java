import java.sql.*;
public class Main {
    private static final String url="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password="mysql password";

    public static void main(String[] args) {
        // Step1 --> Load the Driver

        // in java.lang package we have a class named as "Class" and this Class have a method named as "forName("DriverN)
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        // Step2 --> Create a Connection
        // we have a DriverManager class in which we have a static method
        // named as .getConnection(url,username,password) and it will return
        // a Connection object and Connection is an interface.
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            // now this "con" have the connection to the database
            // Step 3  --> Create a Statement
            Statement stmt=con.createStatement();// Statement is an interface

             String query="select *from students";
             // this query will execute with the help of Statement interface.
             // this object of Statement interface having to methods by which we can execute the query
             // 1. executeQuery() --> we'll use whenever we'll retrieve the data
             // 2. executeUpdate() --> when we perform insert, update, delete on data.
             ResultSet resultset=stmt.executeQuery(query);// it will return the result from database in the form ResultSet
            // ResultSet is an Interface which can store the table
            while(resultset.next()){// next() is a method of resultset instance
                int id=resultset.getInt("id");
                String name=resultset.getString("name");
                int age=resultset.getInt("age");
                double marks=resultset.getDouble("marks");
                System.out.println("id: "+id);
                System.out.println("name: "+name);
                System.out.println("age: "+age);
                System.out.println("marks: "+marks);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
