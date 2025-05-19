package oriented;

public class Car {      // Below are the example of attributes of the Car class
    String make;
    String model;
    int year;
    double price;
    int mileage;
    boolean engineLight;
    static int totalCars = 0;

    Car(String make, String model, int year, double price, int mileage, boolean engineLight) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.engineLight = engineLight;
        totalCars++;
    }

    // Methods specific to class
    void rodKnock() {
        engineLight = true;
    }

    void newEngine() {
        engineLight = false;
    }

    static void carsInSystem() {
        System.out.println("Total cars in system: " + Car.totalCars);
        // Could technically do this/car.totalCars,
        // but that's redundant if it's static -> shared across all cars in class
    }
}