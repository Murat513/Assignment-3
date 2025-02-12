package kz.aitu.oop.restservice.entities;

public class Room {
    private int id;
    private String type;
    private double price;

    public Room(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Room() {}

    public int getId() { return id; }
    public String getType() { return type; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) { this.price = price; }
}