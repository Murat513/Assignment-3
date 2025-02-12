package kz.aitu.oop.restservice.service;

import kz.aitu.oop.restservice.dao.RoomDAO;
import kz.aitu.oop.restservice.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final RoomDAO roomDAO;

    @Autowired
    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public boolean addRoom(Room room) {
        return roomDAO.addRoom(room);
    }
}
