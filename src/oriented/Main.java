package oriented;
import java.util.Scanner;
import java.util.Random;
import static oriented.Car.carsInSystem;

public class Main {
    public static void main(String[] args){
        // Object-oriented programming; similar to using headers in C
        // The are examples, hence why we import them
        Random seed = new Random();
        Scanner stdin = new Scanner(System.in);

        String yourMake;
        String yourModel;
        int yourYear;
        double yourPrice;
        int yourMileage;
        boolean yourEngineLight;

        Car genny = new Car("Hyundai",
                            "Genesis Coupe",
                            2014,
                            10000.99,
                            109950,
                            false);

        Car sampleCar = new Car("Scion",
                                "FRS",
                                2013,
                                8500.99,
                                95700,
                                true);
        carsInSystem();

        System.out.println("Enter in your car details...");
        System.out.println("Make: ");
        yourMake = stdin.next();
        System.out.println("Model: ");
        yourModel = stdin.next();
        System.out.println("Year: ");
        yourYear = stdin.nextInt();
        System.out.println("Price: ");
        yourPrice = stdin.nextDouble();
        System.out.println("Mileage: ");
        yourMileage = stdin.nextInt();
        System.out.println("Check engine light?: (true/false)");
        yourEngineLight = stdin.nextBoolean();

        Car yourCar = new Car(yourMake, yourModel, yourYear, yourPrice, yourMileage, yourEngineLight);

        Car[] listings = {genny, yourCar, sampleCar};

        for (Car listing : listings) {
            System.out.println("Listing: " +
                                listing.year + " " +
                                listing.make + " " +
                                listing.model +
                                " at $" + listing.price +
                                " with " + listing.mileage + " miles on it");
        }

        carsInSystem();

        int engine = seed.nextInt(1, 5);

        if (engine == 1) {  // How it feels  to own a car sometimes
            yourCar.rodKnock();
        } else {
            yourCar.newEngine();
        }

        if (yourCar.engineLight) {
            System.out.println("Your car is sick :(");
        } else if (!yourCar.engineLight) {
            System.out.println("Don't forget to change the oil!");
        }
    }
}