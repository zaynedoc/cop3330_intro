package inheritance;

public class Coupes extends Make {
    static int doors = 2;
    String model;

    // We have to implement the attributes from the parent/"superclass" (which is Vehicle) of this class/child/"subclass"
    // Therefore, embed ```int year, String engine``` into the constructing function
    Coupes(String model, String brand, int year, String engine) {
        super(brand, year, engine); // "Bring in the previous attributes from parent class"
        this.model = model;
    }

    void countDoors() {
        System.out.println("This " + this.model + " has " + doors + " doors");
    }

    @Override   // Method overriding: child inherits a function from parent and makes some modifications
    void displayInfo() {
        System.out.println("Sedan: " + year + " " + brand + " " + model + " with a " + engine.type + " engine");
    }
}
