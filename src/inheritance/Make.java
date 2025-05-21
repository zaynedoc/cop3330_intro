package inheritance;

public abstract class Make extends Vehicle {
    String brand;

    // We have to implement the attributes from the parent/"superclass" (which is Vehicle) of this class/child/"subclass"
    // Therefore, embed ```int year, String engine``` into the constructing function
    Make(String brand, int year, String engine) {
        super(year, engine);    // "Bring in the previous attributes from parent class"
        this.brand = brand;
    }

    @Override
    void displayInfo() {
        System.out.println("a");
    }

    @Override   // Override of the ```System.out.println(Object)``` function
    public String toString() {
        return "This vehicle is made by " + brand + " in " + year + " with a " + engine.type + " engine";
        // Without this override, doing ```System.out.println(Vehicle)``` would return the hash code of the vehicle
        // Instead, we overrode the function to make it return a readable string!
    }
}