package kz.aitu.oop.restservice.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM rooms")) {

            while (rs.next()) {
                System.out.println("Room ID: " + rs.getInt("id"));
                System.out.println("Room Number: " + rs.getString("room_number"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Price: " + rs.getBigDecimal("price"));
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
