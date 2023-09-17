package View;

import Model.User;

public class ShowProfileView {
    public static void displayUserProfile(User user){
        System.out.println("User Profile: ");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }
}
