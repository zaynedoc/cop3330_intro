import java.util.Random;

public class MethodArr {
    public static void main(String [] args) {
        Random seed = new Random();
        int random = seed.nextInt(0, 9);

        System.out.println("Three Row Arrays:");
        int[] row1 = new int[3];
        int[] row2 = new int[3];
        int[] row3 = new int[3];

        for (int i = 0; i < 3; i++) {
            row1[i] = random;
            random = seed.nextInt(0, 9);
            row2[i] = random;
            random = seed.nextInt(0, 9);
            row3[i] = random;
            random = seed.nextInt(0, 9);

            System.out.printf("Row %d: %d %d %d\n", i + 1, row1[i], row2[i], row3[i]);
        }


        System.out.println("\nInitialized 2D array:");
        int[][] grid = new int[3][3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Row %d: ", i + 1);
            for (int j = 0; j < 3; j++) {
                random = seed.nextInt(0, 9);
                grid[i][j] = random;

                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }


        System.out.println("\nInitialized 2D array w/ values:");
        char[][] initializedGrid = {{'1', '2', '3'},    // It's char and not int, because int would store the ASCII value of n
                                   {'4', '5', '6'},
                                   {'7', '8', '9'}};

        for (int i = 0; i < 3; i++) {
            System.out.printf("Row %d: ", i + 1);
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", initializedGrid[i][j]);
            }
            System.out.println();
        }


        String name = "Zayne";
        int age = 19;

        // Birthday song
        System.out.println("\nMain call:");
        System.out.println("Happy birthday to you!");
        System.out.printf("You're turning %d!\n", age);     // The printf function from C coding
        System.out.println("Happy birthday, dear " + name); // Can't do "%d" or "%s" in println()
        System.out.println("Happy birthday to you!\n");

        happyBirthday(name, age);
    }

    // Because you're calling happyBirthday in a static function (main)
        // Method must also be static
    static void happyBirthday(String name, int age) {
        System.out.println("Method call:");
        System.out.println("Happy birthday to you!");
        System.out.printf("You're turning %d!\n", age);
        System.out.println("Happy birthday, dear " + name);
        System.out.println("Happy birthday to you!\n");
    }
}