package Controller;

import DAO.UserDao;
import Model.User;
import View.CreateAccountView;

public class CreateAccountController {
    public static void createAccount(){
        // Get user input from view
        User user = CreateAccountView.getUserInput();

        // Perform Validations
        if(!user.isValidEmail()){
            CreateAccountView.displayErrorMessage("Invalid email format");
            return;
        }

        if(!user.isValidEmail()){
            CreateAccountView.displayErrorMessage("Invalid email format");
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

        UserDao.saveUser(user);
    }
}
