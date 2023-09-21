package Utils;

public class Printer {
    public static void displayErrorMessage() {
        displayErrorMessage("Please enter valid input");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    private static int getInput(int min, int max) {
        int input;

        try {
            System.out.print("Enter a number between " + min + " and " + max + ": ");
            input = Integer.parseInt(ScannerProvider.scanner.nextLine());

            if (input < min || input > max) {
                return -1;
            }
            return input;

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int getInputInRange(int min, int max) {
        int choice = getInput(min, max);
        while (choice == -1){
            displayErrorMessage();
            choice = getInput(min, max);
        }
        return choice;
    }
    public static void displaySuccessMessage() {
        System.out.println("Flight Added successfully!");
    }
}
