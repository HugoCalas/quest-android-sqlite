package fr.wildcodeschool.roomreservation;

/**
 * Created by bastienwcs on 21/03/18.
 */

public class RoomModel {

    private long id;
    private String roomname;

    public RoomModel(long id, String roomname) {
        this.id = id;
        this.roomname = roomname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return roomname;
    }
}
