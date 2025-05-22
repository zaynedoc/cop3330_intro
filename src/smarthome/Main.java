package smarthome;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public void enterDevice(String choice, SmartDevice[] devices, Room[] rooms) {

    }   // placeholder function rn, meant for entering devices to prevent repeated code

    public static void main (String [] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.println("Create a new SmartHome:");
        System.out.println("How many rooms?");

        int roomCount = stdin.nextInt();
        stdin.nextLine(); // Eat newline from previous scanner call
        System.out.println();

        Room[] rooms = new Room[roomCount]; // Required to set a capacity to array
        for (int i = 0; i  < roomCount; i++) {
            System.out.println("Name for room " + (i + 1) + ":");
            String temp = stdin.nextLine();
            rooms[i] = new Room(temp, new SmartDevice[20]); // Construct room with name & 20 device limit
        }

        SmartHome home = new SmartHome(rooms);
        System.out.println("\nAdd " + roomCount + " rooms: ");
        home.printRoomNames();

        SmartDevice[][] devices = new SmartDevice[roomCount][20]; // 2D array of rooms and 20 device limit per room
                                                                  // This means the array is within indices [0][0] to [roomCount - 1][19]
        for (int i = 0; i < roomCount; i++) {
            String loopEnd = "";
            boolean isThermostat = false;   // Prevents user from adding more than one per room

            while (!loopEnd.equals("End")) {
                System.out.println("\nChoose device to add to " + rooms[i].name + ":\n\t- SmartSpeaker\n\t- SmartLight\n\t- SmartThermostat\n\t- End");
                String choice = stdin.nextLine();

                if (devices[i][19] != null) {   // if final device in array is NOT null, or has info
                    System.out.println("Exceeded device limit for " + rooms[i].name + "\n");
                    loopEnd = "End";    // Prevent user from adding anymore devices to array
                } else if (choice.equals("SmartSpeaker")){
                    System.out.println("\nIn '" + rooms[i].name + "':");
                    System.out.println("Provide a name for new SmartSpeaker: ");
                    String name = stdin.nextLine();

                    System.out.println("Provide manufacturer name for " + name);
                    String brand = stdin.nextLine();

                    System.out.println("Set volume (0-100): ");
                    int val = stdin.nextInt();
                    stdin.nextLine();

                    SmartDevice device = new SmartSpeaker(val, brand, name);

                    rooms[i].addDevice(devices[i], device);
                    System.out.println("\nDevices in '" + rooms[i].name + "':");
                    rooms[i].deviceStatuses(devices[i]);
                } else if (choice.equals("SmartLight")) {
                    System.out.println("\nIn '" + rooms[i].name + "':");
                    System.out.println("Provide a name for new SmartLight: ");
                    String name = stdin.nextLine();

                    System.out.println("Provide manufacturer name for " + name);
                    String brand = stdin.nextLine();

                    System.out.println("Set brightness (0-100): ");
                    int val = stdin.nextInt();
                    stdin.nextLine();

                    SmartDevice device = new SmartLight(val, brand, name);

                    rooms[i].addDevice(devices[i], device);
                    System.out.println("\nDevices in '" + rooms[i].name + "':");
                    rooms[i].deviceStatuses(devices[i]);
                } else if (choice.equals("SmartThermostat") && isThermostat == false){
                    System.out.println("\nIn '" + rooms[i].name + "':");
                    System.out.println("Provide a name for new SmartThermostat: ");
                    String name = stdin.nextLine();

                    System.out.println("Provide manufacturer name for " + name);
                    String brand = stdin.nextLine();

                    System.out.println("Set temperature (°F): ");
                    int val = stdin.nextInt();
                    stdin.nextLine();

                    SmartDevice device = new SmartThermostat(val, brand, name);

                    rooms[i].addDevice(devices[i], device);
                    System.out.println("\nDevices in '" + rooms[i].name + "':");
                    rooms[i].deviceStatuses(devices[i]);
                    isThermostat = true;
                } else if (choice.equals("SmartThermostat") && isThermostat == true){
                    System.out.println("\nThermostat already in current room");
                } else if (choice.equals("End")) {
                    loopEnd = "End";    // Prevent user from adding anymore devices to array
                } else {
                    System.out.println("\nInvalid option, try again");
                }
            }
        }



        /*
                        SmartHome home; -> String name;
                                    |
                                    |
                                    v
                            Room[] room = new Room[roomCount];
                                    |
                                    |
                                    v
                                  room[n] -> String name; SmartDevices[] devices;
                                    | - toggleOnAll()
                                    | - toggleOffAll()
                                    | - addDevice(devices, device) -> (e.g.: addDevice(devices[roomCount], device))
                                    | - deviceStatuses()
                                    v
                    SmartDevice[] devices = new SmartDevice[roomCount][20];
                                    | - toggleOn()
                                    | - toggleOff()
                                    | - printStatus()
                                    |
                          ----------|----------
                         /          |          \
                        /           |           \
                       /            |            \
                      v             v             v
                SmartLight         ...           ...
         */

        stdin.close();
    }
}
