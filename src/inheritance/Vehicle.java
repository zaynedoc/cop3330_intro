package inheritance;

public abstract class Vehicle {
    int year;
    Engine engine;

    Vehicle(int year, String engine) {
        this.year = year;
        this.engine = new Engine(engine);
    }

    // Abstraction: the process of hiding implementation details by showing essential features
    // In this example: we are basically telling the children of Make that they MUST override the displayInfo function
    abstract void displayInfo();
}
