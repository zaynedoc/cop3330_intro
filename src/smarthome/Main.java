package smarthome;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void enterDevice(String choice, SmartDevice[][] devices, Room[] rooms, int i, Scanner stdin) {
        System.out.println("\nIn '" + rooms[i].name + "':");
        System.out.println("Provide a name for new " + choice + ": ");
        String name = stdin.nextLine();

        System.out.println("Provide manufacturer name for " + name);
        String brand = stdin.nextLine();

        if (choice.equals("SmartSpeaker")) {
            System.out.println("Set volume (0-100): ");
            int val = stdin.nextInt();
            stdin.nextLine();

            SmartDevice device = new SmartSpeaker(val, brand, name);
            rooms[i].addDevice(devices[i], device);
        } else if (choice.equals("SmartLight")) {
            System.out.println("Set brightness (0-100): ");
            int val = stdin.nextInt();
            stdin.nextLine();

            SmartDevice device = new SmartLight(val, brand, name);
            rooms[i].addDevice(devices[i], device);
        } else if (choice.equals("SmartThermostat")) {
            System.out.println("Set temperature (°F): ");
            int val = stdin.nextInt();
            stdin.nextLine();

            SmartDevice device = new SmartThermostat(val, brand, name);
            rooms[i].addDevice(devices[i], device);
        }

        System.out.println("\nDevices in '" + rooms[i].name + "':");
        rooms[i].deviceStatuses(devices[i]);
    }   // Meant for entering devices to prevent repeated code

    public static void main (String [] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.println("Create a new SmartHome:");
        System.out.println("How many rooms?");

        int roomCount = stdin.nextInt();
        stdin.nextLine();                                           // Eat newline from previous scanner call
        System.out.println();

        Room[] rooms = new Room[roomCount];                         // Required to set a capacity to array
        for (int i = 0; i  < roomCount; i++) {
            System.out.println("Name for room " + (i + 1) + ":");
            String temp = stdin.nextLine();
            rooms[i] = new Room(temp, new SmartDevice[20]);         // Construct room with name & 20 device limit
        }

        SmartHome home = new SmartHome(rooms);
        System.out.println("\nAdd " + roomCount + " rooms: ");
        home.printRoomNames();

        SmartDevice[][] devices = new SmartDevice[roomCount][20];   // 2D array of rooms and 20 device limit per room
                                                                    // This means the array is within indices [0][0] to [roomCount - 1][19]
        for (int i = 0; i < roomCount; i++) {
            String loopEnd = "";
            boolean isThermostat = false;                           // Prevents user from adding more than one per room

            while (!loopEnd.equals("End")) {
                System.out.println("\nChoose device to add to " + rooms[i].name + ":\n\t- SmartSpeaker\n\t- SmartLight\n\t- SmartThermostat\n\t- End");
                String choice = stdin.nextLine();

                if (devices[i][19] != null) {                       // if final device in array is NOT null, or has info
                    System.out.println("Exceeded device limit for " + rooms[i].name + "\n");
                    loopEnd = "End";                                // Prevent user from adding anymore devices to array
                } else if (choice.equals("SmartSpeaker")){
                    enterDevice(choice, devices, rooms, i, stdin);
                } else if (choice.equals("SmartLight")) {
                    enterDevice(choice, devices, rooms, i, stdin);
                } else if (choice.equals("SmartThermostat") && isThermostat == false){
                    enterDevice(choice, devices, rooms, i, stdin);
                    isThermostat = true;
                } else if (choice.equals("SmartThermostat") && isThermostat == true){
                    System.out.println("\nThermostat already in current room");
                } else if (choice.equals("End")) {
                    loopEnd = "End";                                // Prevent user from adding anymore devices to array
                } else {
                    System.out.println("\nInvalid option, try again");
                }
            }
        }

        System.out.println("\nYour SmartHome:");
        home.printRoomNames();
        String endLoop = "";

        while (endLoop != "End") {
            System.out.println("\nChoose an action:\n\t1. Toggle Room On\n\t2. Toggle Room Off\n\t3. Print Room Status\n\t4. End");
            int action = stdin.nextInt();
            stdin.nextLine();                                       // consume next newline

            if (action == 1) {
                System.out.println("\nChoose a room to toggle all devices on...\nYour SmartHome:");
                home.printRoomNames();
                int choice = stdin.nextInt();
                System.out.println(); // for spacing

                // (choice - 1) because the list prints from [1 to n], but array of rooms and devices is [0 to (n - 1)]
                if (devices[choice - 1][0] == null) {               // check array devices[room number][first device], if null, then no devices in room
                    System.out.println("No devices found in " + rooms[choice - 1].name);
                } else if (rooms[choice - 1] != null){              // if it exists, then...
                    rooms[choice - 1].toggleOnAll(devices[choice - 1]);
                    System.out.println("\nDevices in '" + rooms[choice - 1].name + "':");
                    rooms[choice - 1].deviceStatuses(devices[choice - 1]);
                } else {
                    System.out.println("Room not found, backing out...");
                }
            } else if (action == 2) {                               // Repeat code from previous if-statement
                System.out.println("\nChoose a room to toggle all devices off...\nYour SmartHome:");
                home.printRoomNames();
                int choice = stdin.nextInt();
                System.out.println();

                if (devices[choice - 1][0] == null) {
                    System.out.println("No devices found in " + rooms[choice - 1].name);
                } else if (rooms[choice - 1] != null){
                    rooms[choice - 1].toggleOffAll(devices[choice - 1]);
                    System.out.println("\nDevices in '" + rooms[choice - 1].name + "':");
                    rooms[choice - 1].deviceStatuses(devices[choice - 1]);
                } else {
                    System.out.println("Room not found, backing out...");
                }
            } else if (action == 3) {
                System.out.println("\nYour SmartHome:");
                for (int i = 0; i < rooms.length; i++) {
                    System.out.println("Devices in " + rooms[i].name + ":");
                    rooms[i].deviceStatuses(devices[i]);
                }
            } else if (action == 4) {
                System.out.println("\nEnding program...");
                stdin.close();
                endLoop = "End";
            } else {
                System.out.println("\nInvalid action, try again");
            }
        }

        /*
                        SmartHome home; -> Room[] rooms; String name;
                                    | - printRoomNames();
                                    |
                                    v
                            Room[] room = new Room[roomCount]; <- The array of rooms in SmartHome
                                    |
                                    v
                                   room[n] -> String name; SmartDevices[] devices; <- Each specific room in array of rooms
                                    | - toggleOnAll();
                                    | - toggleOffAll();
                                    | - addDevice(devices, device) -> (e.g.: addDevice(devices[roomCount], device))
                                    | - deviceStatuses(SmartDevice[] devices);
                                    |
                                    v
                    SmartDevice[] devices = new SmartDevice[roomCount][20]; (20 device limit per room)
                                    | - toggleOn()
                                    | - toggleOff()
                                    | - printStatus()
                                    |
                          ----------|----------
                         /          |          \
                        /           |           \
                       /            |            \
                      v             v             v
               SmartLight      SmartSpeaker     SmartThermostat
         */

        stdin.close();
    }
}
