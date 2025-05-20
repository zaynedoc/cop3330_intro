package inheritance;

public class VehicleType extends Vehicle{
    String category;    // Commercial, business, or personal use

    VehicleType(String category, int year, String engineType){
        super(year, engineType);
        this.category = category;
    }

    @Override
    void displayInfo() {
        System.out.println("This " + category + " was made in " + year + " with a " + engineType + " engine");
    }
}
