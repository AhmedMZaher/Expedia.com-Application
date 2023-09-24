package Controller;

import DAO.UserDao;
import Model.User;
import Utils.Printer;
import View.ShowProfileView;
import View.UserDashboardView;

public class UserDashboardController {
    public static void run(){
        do {
            UserDashboardView.showMenu();
            int choice = Printer.getInputInRange(1, 5);
            if (choice == 1)
                ShowProfileView.displayUserProfile(User.getInstance());
            else if (choice == 2)
                AddItineraryController.run(UserDao.getId(User.getInstance()));
            else if (choice == 3)
                OrderHistoryController.run(UserDao.getId(User.getInstance()));
            else if (choice == 4){
                System.out.println("Logout successfully");
                User.logout();
            }
            else if (choice == 5)
                return;
        }while (true);
    }
}
