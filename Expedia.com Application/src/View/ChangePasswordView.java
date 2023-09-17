package View;

import Utils.ScannerProvider;

public class ChangePasswordView {
    public static String getPassword(){
        System.out.println("Enter new password: ");
        return ScannerProvider.scanner.nextLine();
    }
    public static void displaySuccessMessage() {
        System.out.println("Password changed successfully!");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
