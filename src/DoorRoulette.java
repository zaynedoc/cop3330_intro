import java.util.Scanner;
import java.util.Random;

public class DoorRoulette {
    public static void main(String[] args){
        Random random = new Random();                // Random seed; instance "random = new Random()" for a new seed
        Scanner actioner = new Scanner(System.in);   // Start scanner for program to take user input


        int[] doors = new int[6];           // Six elements, indices 0 through 5
        int[] explored = new int[6];        // Copy array, prevents the user from re-exploring previously entered doors
        int trapsCount;                     // Random number between 1 and 5
        int trapsFound;                     // Traps found by the user
        int traps;                          // Randomly selects the indices in doors array for door to become a trap, keeps re-selecting until it finds a non-trap door
        int safeDoorsFound;
        int trapsCounter;
        int HP;                             // End game when (HP<0), if trapsCount=1: HP=0, if trapsCount>1: HP=1

        int gameLoop = 1;
        int doorLoop;
        int action = 999;

        while (action != 4){                // "Condition 'action != 4' is always true" until user selects 4, code still compiles without errors
            if (action == 1) {
                while (gameLoop == 1) {     // ^ Same for this
                    // Game startup/reset
                    random = new Random();
                    trapsCount = random.nextInt(1, 5);
                    trapsCounter = 0;
                    safeDoorsFound = 0;
                    doorLoop = 0;
                    trapsFound = 0;

                    // Initialize all doors as safe and unexplored
                    for (int i = 0; i < 6; i++){
                        doors[i] = 0;
                        explored[i] = 0;
                    }

                    do {
                        random = new Random();
                        traps = random.nextInt(1, 5);

                        if (doors[traps] != 1) {
                            doors[traps] = 1;
                            //System.out.println("Allocated trap...");  For debugging
                            trapsCounter++;
                        }
                    } while(trapsCounter != trapsCount);    // Loop until all traps are allocated


                    if (trapsCount == 1) {
                        HP = 0;
                    } else {
                        HP = 1;
                    }

                    System.out.println("\n╔════════════" +              "════════════════════════╗");
                    System.out.println(  "║ There are [" + trapsCount + "] trap(s) ahead        ║");
                    System.out.println(  "║ Therefore, [" + (6- trapsCount) + "] safe door(s) remain ║");
                    System.out.println(  "║ Choose your next door wisely...    ║");
                    System.out.println(  "╚═════════════" +                   "═══════════════════════╝\n");

                    // Core game loop
                    while (HP >= 0 && safeDoorsFound != (6- trapsCount)) {  // If user is still alive, and not all doors were found, continue
                        for (int i = 0; i < 6; i++) {
                            if (explored[i] == 0) {
                                System.out.println("Door [" + (i + 1) + "]");
                            }
                        }

                        doorLoop = 1;

                        while (doorLoop == 1) {
                            System.out.println("\nWhich door will you take?");
                            action = actioner.nextInt();

                            if (action < 1 || action > 6) {
                                System.out.println("Door [" + action + "] doesn't exist, try again");
                            } else if (doors[action - 1] == 1 && explored[action - 1] == 0) {   //doors[0-5], hence doors[action - 1]
                                System.out.println("\n>>> Unfortunately, Door [" + action + "] had a trap...");

                                HP--;
                                if (HP == 0) {
                                    System.out.println(">>> You have one more HP left");
                                } else if (HP <= 0) {
                                    System.out.println(">>> You ran out of HPs...");
                                }

                                explored[action - 1] = 1;       // Toggle door as in-explorable
                                doors[action - 1] = 0;          // De-trapped the door
                                trapsFound++;
                                doorLoop = 0;                   // Escape loop
                            } else if (doors[action - 1] == 0 && explored[action - 1] == 0) {    // Safe door & unexplored
                                System.out.println("\n>>> Door [" + action + "] is safe!");

                                explored[action - 1] = 1;
                                safeDoorsFound++;
                                doorLoop = 0;

                                if (safeDoorsFound == (6 - trapsCount)) {
                                    System.out.println("You found all the safe doors!\nRound complete!");
                                }
                            } else if (doors[action - 1] == 0 && explored[action - 1] == 1) {   //  Re-explored door
                                System.out.println("\nYou already tried door [" + action + "], try again");
                            }
                        }

                        if (HP >= 0 && safeDoorsFound != (6- trapsCount)) {
                            System.out.println("\n╔════════════" +              "════════════════════════╗");
                            System.out.println(  "║ There are [" + (trapsCount - trapsFound) + "] trap(s) left         ║");
                            System.out.println(  "║ Therefore, [" + (6 - trapsCount - safeDoorsFound) + "] safe doors remain   ║");
                            System.out.println(  "║ Choose your next door wisely...    ║");
                            System.out.println(  "╚═════════════" +                   "═══════════════════════╝\n");
                        }
                    }

                    System.out.println("\nRestart game?\n1: No\n2: Yes");
                    gameLoop = actioner.nextInt();
                    gameLoop--;
                }

                action = 999;
            }

            System.out.println("\n   ┳┓        ┳┓    ┓┓     \n" +
                                 "   ┃┃┏┓┏┓┏┓  ┣┫┏┓┓┏┃┃┏┓╋┏┓\n" +
                                 "   ┻┛┗┛┗┛┛   ┛┗┗┛┗┻┗┗┗┓┗┗┓");
            System.out.println("\n1: Start\n2: Instructions\n3: Credits\n4: End Program");
            action = actioner.nextInt();

            // Title Screen
            while (action != 1) {
                switch (action) {
                    case 2: // Instructions
                        System.out.println("\nInstructions:\n" +
                                "1. Start game\n" +
                                "2. You will be provided 6 doors to choose from\n" +
                                "3. Each round, as much as 5 doors can be a trap\n" +
                                " * If you open a non-trap door, you will be notified\n" +
                                "4. If you open a trap, you will lose 1HP (2HP/game)\n" +
                                "5. If you open all non-trap doors, you win the game");
                        break;
                    case 3: // Credits
                        System.out.println("\nCreated by Zayne Dockery\nzayne.doc on GitHub\nIDE: Intellij IDEA\nUCF Co' 2028");
                        break;
                    case 4: // End Program
                        actioner.close();   // Before ending program, must always close Scanner
                        return;             // Escapes while loop and ends program abruptly
                    case 999:  // Naturally occurs at the end of each game, no visible output
                        break;
                    default:
                        System.out.println("\nInvalid input");
                        break;
                }
                System.out.println("\n1: Start\n2: Instructions\n3: Credits\n4: End Program");
                action = actioner.nextInt();
            }

            gameLoop = 1;
        }

        actioner.close();
    }
}