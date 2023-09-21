package Controller;

import DAO.UserDao;
import Model.User;
import View.LoginView;

public class LoginController {
    public static void userLogin(){
        do {
            String email = LoginView.getEmailInput();
            String password = LoginView.getPasswordInput();

            if (!UserDao.isEmailExist(email) || !UserDao.isPasswordMatch(email, password)) {
                LoginView.displayErrorMessage("Invalid username or password.");
            } else {
                LoginView.displaySuccessMessage();
                User.setInstance(UserDao.getName(email), email, password);
                UserDashboardController.run();
                break; // Break out of the loop if login is successful
            }
        } while (true);

    }
}
