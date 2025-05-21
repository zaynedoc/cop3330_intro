package inheritance;

public class Sedans extends Make {
    static int doors = 4;
    String model;

    Sedans(String model, String brand, int year, String type) {
        super(brand, year, type);
        this.model = model;
    }

    void countDoors() {
        System.out.println("This " + this.model + " has " + doors + " doors");
    }

    @Override
    void displayInfo() {
        System.out.println("Coupe: " + year + " " + brand + " " + model + " with a " + engine.type + " engine");
    }
}
