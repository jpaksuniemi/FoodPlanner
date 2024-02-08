import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int PLAN_WEEK = 1;
    private static final int PRINT_LIST = 2;
    private static final int ADD_FOOD_TYPE = 3;
    private static final int REMOVE_FOOD_TYPE = 4;
    private static final int QUIT_PROGRAM = -1;

    private static final String FILE_PATH = "./foodtypes.txt";

    private static enum Day {
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

        while (input != QUIT_PROGRAM) {
            printUserInterface();
            input = readIntInput(scanner);

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

    private static int readIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nYour input wasn't an integer, please try again > ");
                scanner.nextLine();
            }
        }
    }

    public static void printUserInterface() {
        System.out.println("\nChoose a feature by typing the index number. (-1 quits the program)");
        System.out.println("1. Plan a week");
        System.out.println("2. Print the list of foods");
        System.out.println("3. Add a food");
        System.out.println("4. Remove a food");
        System.out.print("> ");
    }

    // TBD Scheduler for each day of the week
    public static void planWeek() {
        String[] foods = new String[7];
        getFoods(foods);
        int i = 0;
        System.out.println();
        for (Day day : Day.values()) {
            System.out.print(day + " " + foods[i] + "\n");
            i++;
        }
    }

    private static int getAmountOfEntries() {
        int lineCounter = 0;

        try (FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (null != bufferedReader.readLine()) {
                lineCounter++;
            }
        } catch (IOException e) {
            System.err.println("An error occured: " + e);
        }

        return lineCounter;
    }

    private static void getFoods(String[] listOfFoods) {
        Random random = new Random();
        int indexToGet;
        int i = 0;
        int amountOfIndexes = getAmountOfEntries();
        boolean isUnique;

        while (i < listOfFoods.length) {
            indexToGet = random.nextInt(amountOfIndexes);
            isUnique = true;

            try (FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                for (int j = 0; j < indexToGet; j++) {
                    bufferedReader.readLine();
                }
                listOfFoods[i] = bufferedReader.readLine();

                for (int k = 0; k < i; k++) {
                    if (listOfFoods[i].equals(listOfFoods[k])) {
                        isUnique = false;
                    }
                }

                if (isUnique) {
                    i++;
                }
            } catch (IOException e) {
                System.err.println("An error occured: " + e);
            }
        }
    }

    public static void printList() {
        try (FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int i = 1;
            String line;
            System.out.println();
            while ((line = bufferedReader.readLine()) != null) {
                System.out.print(i + ". ");
                System.out.println(line);
                i++;
            }
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