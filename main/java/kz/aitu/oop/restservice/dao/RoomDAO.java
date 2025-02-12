package kz.aitu.oop.restservice.dao;

import kz.aitu.oop.restservice.entities.Room;
import kz.aitu.oop.restservice.database.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAO {
    private Connection connection;

    public RoomDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT id, room_number, room_type, is_available, price FROM rooms";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getInt("room_number")); // Исправлено
                room.setRoomType(rs.getString("room_type")); // Используем room_type
                room.setAvailable(rs.getBoolean("is_available")); // Флаг доступности
                room.setPrice(rs.getDouble("price"));
                rooms.add(room);
                System.out.println("Добавлена комната: " + room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }



    public boolean addRoom(Room room) {
        String query = "INSERT INTO rooms (roomNumber, roomType, isAvailable, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, room.getRoomNumber());
            stmt.setString(2, room.getRoomType());
            stmt.setBoolean(3, room.isAvailable());
            stmt.setDouble(4, room.getPrice());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
