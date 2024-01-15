import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final int PLAN_WEEK = 1;
    private static final int PRINT_LIST = 2;
    private static final int ADD_FOOD_TYPE = 3;
    private static final int REMOVE_FOOD_TYPE = 4;
    private static final int QUIT_PROGRAM = -1;

    private static final String filePath = "./src/foodtypes.txt";

    enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        int input = 0;
        System.out.println("Thank you for using Food Planner!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        while (input != QUIT_PROGRAM) {
            printUserInterface();
            input = scanner.nextInt();

            switch (input) {
                case PLAN_WEEK:
                    planWeek();
                    break;
                case PRINT_LIST:
                    printList();
                    break;
                case ADD_FOOD_TYPE:
                    addFoodType();
                    break;
                case REMOVE_FOOD_TYPE:
                    removeFoodType();
                    break;
                case QUIT_PROGRAM:
                    System.out.println("Quitting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
    }

    static void printUserInterface() {
        System.out.println("\nChoose a feature by typing the index number. (-1 quits the program)");
        System.out.println("1. Plan a week");
        System.out.println("2. Print the list of foods");
        System.out.println("3. Add a food");
        System.out.println("4. Remove a food");
        System.out.print("> ");
    }

    // TBD Scheduler for each day of the week
    static void planWeek() {
        System.out.println("This feature isn't ready");
    }


    // TBD Print method for food types saved in a file
    static void printList() {
        try (FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            System.out.print("\n");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("An error occured: " + e);
        }
    }

    // TBD Method for adding a food type to a file
    static void addFoodType() {
        System.out.println("This feature isn't ready");
    }

    // TBD Method for removing a food type from a file
    static void removeFoodType() {
        System.out.println("This feature isn't ready");
    }
}