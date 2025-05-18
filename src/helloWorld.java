import java.util.Scanner;   // "Scanner" is the class of the import

public class helloWorld {
    public static void main(String[] args){
        //System.out.print("Hello world!\n");
        System.out.println("Hello world!");     // ln -> "line new," an embedded \n

        /*
        Typing "sout" + [tab]
        Expands to "System.out.println();"
        */

        int age = 19;           // Declaration
        age = 20;               // Updating value
        System.out.println("This year, I am turning " + age);

        double currentAge;      // Declaration with no assigned value
        currentAge = 19.5;      // doubles are the equivalent of float variables
        System.out.println("Currently, I am " + currentAge + " years old");

        char currency = '$';    // char variables must be initialized w/ '', not ""
        System.out.println("I got " + currency + "" + currentAge + "0 in my bank account");

        boolean isCurrent = false;                               // Useful for conditional statements
        //System.out.println("Is that true?: " + isCurrent);    // Bool values can be printed too, not common though

        // Same anatomy & structure of if-statements when coding C
            // isCurrent  => "is isCurrent true?"
            // !isCurrent => "is isCurrent false?"
        if (isCurrent) {                            // *Redundant in this case since isCurrent is always true, just for demonstrative purposes of if-statements
            System.out.println("Dang he really do got that much money; " + isCurrent);
        } else if (!isCurrent) {
            System.out.println("Bro's lying; " + isCurrent);
        } else {                                    // Always good to have a default statement, for error-testing
            System.out.println("No assigned value; indeterminant expression");
        }

        String name = "Zayne Dockery";              // Designated string variables, unlike C
        String email = "zaynedockery@gmail.com";
        String car = "2014 Hyundai Genesis Coupe 2.0t Premium";
        System.out.println("Developed by " + name);
        System.out.println("I drive a " + car);
        System.out.println("Contact " + email + " for inquiries\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String yourName = scanner.nextLine();               // Assignment after declaration of variable
        System.out.println("Hello, " + yourName + "\n");

        System.out.print("Pick a number between [1, 3]: ");
        int yourNumber = scanner.nextInt();                 // nextInt() for integers only
        String conditionalStatement;

        // Can't do boolean expressions (e.g. 'yourNumber >= 2') in switch-cases
            // Cases can only be constant expressions: literals like int, char, String, or enum values
        switch(yourNumber) {    // In Intellij IDEA, you can restructure the switch-case statement for similar functionality and less space
            case 1:
                conditionalStatement = ". You are #1.";
                break;
            case 2:
                conditionalStatement = ". You like Tuesdays?";
                break;
            case 3:
                conditionalStatement = ". Three for good luck?";
                break;
            default:                                        // The else-statement of switch-cases
                conditionalStatement = ". That's out of proposed range.";
                break;
        }

        System.out.println("You chose: " + yourNumber + conditionalStatement);

        boolean repeat = true;
        String yesNoOperator;
        double yourGPA = 0.0;   // By default

        while (repeat) {
            System.out.println("\nWhat is your GPA?");
            yourGPA = scanner.nextDouble();             // yourGPA can't be declared here because of scope; it'd only be local to the while-loop

            System.out.println("Your GPA is " + yourGPA + "? (Y/N): ");
            yesNoOperator = scanner.next();

            repeat = switch(yesNoOperator) {
                case "Y", "y", "Yes", "yes" -> false;
                case "N", "n", "No", "no" -> true;      // By default, it's true anyway
                default -> true;                        // If not a no, re-ask
            }; // *Problem is any String outside a "yes" will give the same result as a "no," more of a logical error; code still compiles
        }

        if (yourGPA < 1.0) {
            System.out.println("Well, college isn't for everyone...");
        } else if (yourGPA >= 1.0 && yourGPA < 2.0) {
            System.out.println("Ouch, advising counselor won't like this...");
        } else {
            System.out.println("Keep up your grades!");
        }

        scanner.close();                                // Must close scanner once done using it, usually close by end of program
    }
}

// Recompiling will overwrite the previous executable
// "javac helloWorld.java" > "java helloWorld.java"
// Update javac to ver 24.0.1