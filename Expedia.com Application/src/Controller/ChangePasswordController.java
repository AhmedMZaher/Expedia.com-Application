package Controller;

import DAO.UserDao;
import Model.User;
import Utils.Validator;
import View.ChangePasswordView;

public class ChangePasswordController {
    public static void changePassword(String oldEmail){
        String password = ChangePasswordView.getPassword();

        if(!Validator.passwordValidator(password)){
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
