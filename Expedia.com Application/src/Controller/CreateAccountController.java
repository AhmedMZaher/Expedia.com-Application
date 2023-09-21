package Controller;

import DAO.UserDao;
import Model.User;
import Utils.Validator;
import View.CreateAccountView;
import View.ShowProfileView;

public class CreateAccountController {
    public static void createAccount(){
        do {
            User user = CreateAccountView.getUserInput();

            // Perform Validations
            if (!Validator.emailValidator(user.getEmail())) {
                CreateAccountView.displayErrorMessage("Invalid email format");
            } else if (!Validator.passwordValidator(user.getPassword())) {
                CreateAccountView.displayErrorMessage("Invalid password format");
            } else if (UserDao.isNameExist(user.getName())) {
                CreateAccountView.displayErrorMessage("Name already exists!");
            } else if (UserDao.isEmailExist(user.getEmail())) {
                CreateAccountView.displayErrorMessage("Email already exists!");
            } else {
                UserDao.saveUser(user.getName(), user.getEmail(), user.getPassword());
                ShowProfileView.displayUserProfile(user);
                break; // Break out of the loop if account creation is successful
            }
        } while (true);

    }
}
