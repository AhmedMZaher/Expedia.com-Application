package Controller;

import DAO.UserDao;
import Model.User;
import Utils.Validator;
import View.ChangeEmailView;

public class ChangeEmailController {
    public static void changeEmail(String oldEmail){
        String email = ChangeEmailView.getEmail();

        if(!Validator.passwordValidator(email)){
            ChangeEmailView.displayErrorMessage("Invalid email format");
            return;
        }
        if(!UserDao.changeEmail(oldEmail, email)){
            ChangeEmailView.displayErrorMessage("Something went wrong, please try again");
            return;
        }
        ChangeEmailView.displaySuccessMessage();
    }
}
