package View;

import Model.ScannerProvider;

public class ChangeEmailView {

    public static String getEmail() {
        System.out.print("Enter new email: ");
        return ScannerProvider.scanner.nextLine();
    }

    public static void displaySuccessMessage() {
        System.out.println("Email changed successfully!");
    }

    public static void displayErrorMessage() {
        System.out.println("Invalid Email Format");
    }
}
