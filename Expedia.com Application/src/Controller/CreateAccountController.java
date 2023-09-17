package Controller;

import DAO.UserDao;
import Model.User;
import Utils.Validator;
import View.CreateAccountView;
import View.ShowProfileView;

public class CreateAccountController {
    public static void createAccount(){
        // Get user input from view
        User user = CreateAccountView.getUserInput();

        // Perform Validations
        if(!Validator.emailValidator(user.getEmail())){
            CreateAccountView.displayErrorMessage("Invalid email format");
            return;
        }

        if(!Validator.passwordValidator(user.getPassword())){
            CreateAccountView.displayErrorMessage("Invalid password format");
            return;
        }

        if(UserDao.isNameExist(user.getName())){
            CreateAccountView.displayErrorMessage("Name already exist!");
            return;
        }
        if(UserDao.isEmailExist(user.getEmail())){
            CreateAccountView.displayErrorMessage("Email already exist!");
            return;
        }

        UserDao.saveUser(user.getName(), user.getEmail(), user.getPassword());
        ShowProfileView.displayUserProfile(user);
    }
}
