package smarthome;

public class SmartHome {
    Room[] rooms;

    SmartHome(Room[] rooms) {
        this.rooms = rooms;
    }

    public void printRoomNames() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + rooms[i].name);
        }
    }
}
