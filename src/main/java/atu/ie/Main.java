package atu.ie;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lab7JDBC", "root", "password")){


            PreparedStatement stmt = con.prepareStatement("INSERT INTO user (name, email) VALUES (?, ?)");
            stmt.setString(1, "John");
            stmt.setString(2, "John@atu.ie");
            stmt.executeUpdate();

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("Name: " + name + ", Email: " + email);
            }


        } catch (Exception e){
            e.printStackTrace();
        }








    }
}