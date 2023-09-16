package Controller;

import DAO.UserDao;
import Model.User;
import View.ChangeEmailView;

public class ChangeEmailController {
    public static void changeEmail(String oldEmail){
        String email = ChangeEmailView.getEmail();

        if(!User.isValidEmail(email)){
            ChangeEmailView.displayErrorMessage();
            return;
        }
        UserDao.changeEmail(oldEmail, email);
        ChangeEmailView.displaySuccessMessage();
    }
}
