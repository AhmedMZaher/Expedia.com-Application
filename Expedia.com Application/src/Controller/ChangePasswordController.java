package Controller;

import DAO.UserDao;
import Model.User;
import View.ChangePasswordView;

public class ChangePasswordController {
    public static void changePassword(String oldEmail){
        String password = ChangePasswordView.getPassword();

        if(!User.isValidPassword(password)){
            ChangePasswordView.displayErrorMessage("Invalid password format");
            return;
        }
        if(!UserDao.changePassword(oldEmail, password)){
            ChangePasswordView.displayErrorMessage("Something went wrong, please try again");
            return;
        }
        ChangePasswordView.displaySuccessMessage();
    }
}
