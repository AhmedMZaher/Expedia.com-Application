package Model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class User {
    private String name;
    private String email;
    private String password;
    // Singleton instance for logged in user
    private static User instance;

    public static User getInstance() {
        return instance;
    }

    public static void setInstance(String name, String username, String email) {
        instance = new User(name, username, email);
    }
    public static void logout() {
        instance = null;
    }

    public static boolean isLoggedIn() {
        if (instance == null)
            return false;
        return true;
    }



    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
