package View;

import Utils.ScannerProvider;

public class ChangeEmailView {

    public static String getEmail() {
        System.out.print("Enter new email: ");
        return ScannerProvider.scanner.nextLine();
    }

    public static void displaySuccessMessage() {
        System.out.println("Email changed successfully!");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
