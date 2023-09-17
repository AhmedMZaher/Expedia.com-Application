package View;

import Model.User;
import Utils.ScannerProvider;

public class CreateAccountView {


    private static String getName() {
        System.out.print("Enter name: ");
        return ScannerProvider.scanner.nextLine();
    }

    private static String getEmail() {
        System.out.print("Enter email: ");
        return ScannerProvider.scanner.nextLine();
    }

    private static String getPassword() {
        System.out.print("Enter password: ");
        return ScannerProvider.scanner.nextLine();
    }

    public static User getUserInput() {
        String name = getName();
        String email = getEmail();
        String password = getPassword();

        User user = new User(name, email, password);

        return user;
    }

    public static void displaySuccessMessage() {
        System.out.println("Account created successfully!");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}