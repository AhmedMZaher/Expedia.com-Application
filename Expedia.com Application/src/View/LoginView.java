package View;

import Model.ScannerProvider;

public class LoginView {
    public static String getEmailInput() {
        System.out.print("Enter email: ");
        return ScannerProvider.scanner.nextLine();
    }

    public static String getPasswordInput() {
        System.out.print("Enter password: ");
        return ScannerProvider.scanner.nextLine();
    }
    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    public static void displaySuccessMessage() {
        System.out.println("Login successful!");
    }
}
