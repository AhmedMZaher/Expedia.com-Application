package View;

import Model.User;

public class ShowProfileView {
    public static void displayUserProfile(String name, String email){
        System.out.println("User Profile: ");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
