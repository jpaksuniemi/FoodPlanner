import java.util.Scanner;

public class Main {
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

        while (input != -1) {
            printUserInterface();
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    planWeek();
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    addFoodType();
                    break;
                case 4:
                    removeFoodType();
                    break;
                case -1:
                    System.out.println("Quitting the program...");
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
    }

    static void printUserInterface() {
        System.out.println("\nChoose a feature by typing the index number. (-1 quits the program)\n");
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
        System.out.println("This feature isn't ready");
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