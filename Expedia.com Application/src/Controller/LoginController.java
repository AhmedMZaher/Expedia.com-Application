package Controller;

import DAO.UserDao;
import Model.User;
import View.LoginView;

public class LoginController {
    public static void userLogin(){
        String email = LoginView.getEmailInput();
        String password = LoginView.getPasswordInput();

        if(!UserDao.isEmailExist(email) || !UserDao.isPasswordMatch(email, password)){
            LoginView.displayErrorMessage("Invalid username or password.");
            return;
        }
        LoginView.displaySuccessMessage();
    }
}
