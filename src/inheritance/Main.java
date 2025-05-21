package inheritance;

import java.util.Scanner;

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
                  /      Vehicle (Parent)   <--------------------------------------------- Dealership
                 /                |  - int year;                                              - int carCount;
                /                 |  - String engine;   <-- String engine.type; Composition   - String name;
        VehicleType              /\                                                           - Vehicle[] cars; Aggregation
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

        Scanner stdin = new Scanner(System.in);

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

        // Aggregation: two separate classes of objects can still exist
        //              as separate objects, but also connected
        // Example: cars and dealerships

        Dealership Hyundai = new Dealership(vehicles.length, "Hyundai", vehicles);
        System.out.println();
        Hyundai.printCars();

        Make userCar;
        // Runtime polymorphism: an object is defined during
        //                       the program's runtime

        System.out.println("\nInput your car details...\nMake:");
        String userMake = stdin.nextLine();

        System.out.println("Model:");
        String userModel = stdin.nextLine();

        System.out.println("Year:");
        int userYear = stdin.nextInt();
        stdin.nextLine();   // Consumes leftover newline from nextInt

        System.out.println("Engine Type:");
        String userEngineType = stdin.nextLine();

        System.out.println("\nIs your car a coupe (1) or a sedan (2)?");
        int userDecision = 0;

        while (userDecision == 0) {
            userDecision = stdin.nextInt();

            switch (userDecision) {
                case 1:
                    userCar = new Coupes(userModel, userMake, userYear, userEngineType);
                    System.out.println(userCar);
                    break;
                case 2:
                    userCar = new Sedans(userModel, userMake, userYear, userEngineType);
                    System.out.println(userCar);
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    userDecision = stdin.nextInt();
                    break;
            }
        }

        stdin.close();
    }
}