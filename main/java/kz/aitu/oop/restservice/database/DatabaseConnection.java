package kz.aitu.oop.restservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/hotel_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Aktobe04";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");  // Проверка загрузки драйвера
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Драйвер PostgreSQL не найден!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Ошибка подключения к базе данных!");
            e.printStackTrace();
        }
        return null;
    }
}
