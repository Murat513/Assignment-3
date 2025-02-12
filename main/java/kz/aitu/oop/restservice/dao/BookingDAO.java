package kz.aitu.oop.restservice.dao;

import kz.aitu.oop.restservice.database.DatabaseConnection;
import kz.aitu.oop.restservice.entities.Booking;
import kz.aitu.oop.restservice.entities.Guest;
import kz.aitu.oop.restservice.entities.Room;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDAO {
    private Connection connection;

    public BookingDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                bookings.add(mapResultSetToBooking(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public Booking getBookingById(int id) {
        String query = "SELECT * FROM bookings WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToBooking(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addBooking(Booking booking) {
        String query = "INSERT INTO bookings (guestId, roomId, startDate, endDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, booking.getGuestId());
            preparedStatement.setInt(2, booking.getRoomId());
            preparedStatement.setDate(3, new java.sql.Date(booking.getStartDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(booking.getEndDate().getTime()));
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBooking(Booking booking) {
        String query = "UPDATE bookings SET guestId = ?, roomId = ?, startDate = ?, endDate = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, booking.getGuestId());
            preparedStatement.setInt(2, booking.getRoomId());
            preparedStatement.setDate(3, new java.sql.Date(booking.getStartDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(booking.getEndDate().getTime()));
            preparedStatement.setInt(5, booking.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBooking(int id) {
        String query = "DELETE FROM bookings WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Booking mapResultSetToBooking(ResultSet resultSet) throws SQLException {
        return new Booking(
                resultSet.getInt("id"),
                resultSet.getInt("guestId"),
                resultSet.getInt("roomId"),
                resultSet.getDate("startDate"),
                resultSet.getDate("endDate")
        );
    }
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        String query = "SELECT * FROM guests";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Guest guest = new Guest(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
                guests.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guests;
    }
    public void addGuest(Guest guest) {
        String query = "INSERT INTO guests (name, email) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, guest.getName());
            statement.setString(2, guest.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM rooms")) {
            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getDouble("price")
                );
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public void addRoom(Room room) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO rooms (type, price) VALUES (?, ?)")) {
            stmt.setString(1, room.getType());
            stmt.setDouble(2, room.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
