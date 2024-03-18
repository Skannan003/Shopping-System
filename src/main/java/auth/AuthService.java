package auth;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, User> users = new HashMap<>();

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            // User authentication successful
            return true;
        }
        return false;
    }

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) { // Check if user already exists
            users.put(username, new User(username, password));
        } else {
            System.out.println("User already exists.");
        }
    }

    // Method to check if a user exists
    public boolean doesUserExist(String username) {
        return users.containsKey(username);
    }

    // Method to delete a user (if needed)
    public void deleteUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User does not exist.");
        }
    }

    // Additional methods as needed
}
