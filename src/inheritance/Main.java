package inheritance;

public class Main {
    public static void main(String[] args) {
        // Inheritance; one class inherits the attributes and methods
        //              from another class
        /*
                    Make (Grandparent)
                      |  - String brand;
                     /\
                    /  \
                   /    \
                  /      Vehicle (Parent)
                 /                |  - int year;
                /                 |  - String engineType;
        VehicleType              /\
          - String category;    /  \
                               /    \
                              |   Sedans (Child)
                              |      - static int doors = 4;
                              |      - String model;
                              |
                             Coupes (Child, sibling of Sedans)
                              - static int doors = 4;
                              - String model;
         */

        Sedans Elantra = new Sedans("Elantra", "Hyundai", 2013, "1.6 Turbo");
        Coupes GenesisCoupe = new Coupes("Genesis Coupe", "Hyundai", 2014, "2.0 Turbo Premium");

        System.out.println(Elantra); // Overridden method omits "model" attribute, because it was overridden in the Make class, which doesn't have the model attribute
        Elantra.displayInfo();
        Elantra.countDoors();

        System.out.println();
        GenesisCoupe.displayInfo();
        System.out.println(GenesisCoupe);
        GenesisCoupe.countDoors();

        VehicleType CompanyCar = new VehicleType("Company Car", 2018, "2.0 Turbo Premium");
        System.out.println();
        CompanyCar.displayInfo();

        // Polymorphism: Objects that identify as other objects;
        //               Objects can be treated as objects of a common superclass.
        Vehicle[] vehicles = {Elantra, GenesisCoupe, CompanyCar};

        System.out.println("\nPolymorphism array of Vehicles:");
        for (Vehicle vehicle : vehicles) {     // "For each vehicle in the vehicle array, have vehicle displayInfo()"
            vehicle.displayInfo();
        }

    }
}