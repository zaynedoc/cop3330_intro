package inheritance;

public class Dealership {
    int carCount;
    String name;
    Vehicle[] vehicles; // Vehicles at the dealership

    Dealership(int carCount, String name, Vehicle[] vehicles) {
        this.carCount = carCount;
        this.name = name;
        this.vehicles = vehicles;
    }

    void printCars() {
        System.out.println(this.name + " dealership car inventory:");
        for (Vehicle vehicle : vehicles) {     // "For each vehicle in the vehicle array, have vehicle displayInfo()"
            vehicle.displayInfo();
        }
    }
}