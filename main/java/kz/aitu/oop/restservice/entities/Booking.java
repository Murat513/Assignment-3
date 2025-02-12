package kz.aitu.oop.restservice.entities;

import java.util.Date;

public class Booking {
    private int id;
    private int guestId;
    private int roomId;
    private Date startDate;
    private Date endDate;

    public Booking(int id, int guestId, int roomId, Date startDate, Date endDate) {
        this.id = id;
        this.guestId = guestId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getGuestId() { return guestId; }
    public void setGuestId(int guestId) { this.guestId = guestId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
}
