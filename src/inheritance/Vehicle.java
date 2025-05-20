package inheritance;

public abstract class Vehicle {
    int year;
    String engineType;

    Vehicle(int year, String engineType) {
        this.year = year;
        this.engineType = engineType;
    }

    // Abstraction: the process of hiding implementation details by showing essential features
    // In this example: we are basically telling the children of Make that they MUST override the displayInfo function
    abstract void displayInfo();
}
