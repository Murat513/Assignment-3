package kz.aitu.oop.restservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "room_number")
    private int roomNumber;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "is_available")
    private boolean isAvailable;
    @Column(name = "price")
    private double price;

    public Room() {}

    public int getId() { return id; }
    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public boolean isAvailable() { return isAvailable; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                '}';
    }
}
