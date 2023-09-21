package Controller;

import Utils.Printer;
import View.MainMenuView;

public class MainMenuController {
    public static void run() {
        do {
            MainMenuView.showMenu();
            int choice = Printer.getInputInRange(1, 2);
            if (choice == 1)
                LoginController.userLogin();
            else if (choice == 2)
                CreateAccountController.createAccount();
            else if (choice == 3)
                return;
        } while (true);

    }
}
