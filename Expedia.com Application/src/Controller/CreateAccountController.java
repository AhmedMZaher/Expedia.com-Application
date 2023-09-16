package Controller;

import DAO.UserDao;
import Model.User;
import View.CreateAccountView;
import View.ShowProfileView;

public class CreateAccountController {
    public static void createAccount(){
        // Get user input from view
        String name = CreateAccountView.getName();
        String email = CreateAccountView.getEmail();
        String password = CreateAccountView.getPassword();

        // Perform Validations
        if(!User.isValidEmail(email)){
            CreateAccountView.displayErrorMessage("Invalid email format");
            return;
        }

        if(!User.isValidPassword(password)){
            CreateAccountView.displayErrorMessage("Invalid password format");
            return;
        }

        if(UserDao.isNameExist(name)){
            CreateAccountView.displayErrorMessage("Name already exist!");
            return;
        }
        if(UserDao.isEmailExist(email)){
            CreateAccountView.displayErrorMessage("Email already exist!");
            return;
        }

        UserDao.saveUser(name, email, password);
        ShowProfileView.displayUserProfile(name, email);
    }
}
