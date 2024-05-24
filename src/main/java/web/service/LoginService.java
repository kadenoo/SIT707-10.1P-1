import java.util.HashMap;

public class LoginService {

    // Simulating a database of user credentials
    private static HashMap<String, String> userCredentials = new HashMap<>();

    // Static block to initialize some sample user credentials
    static {
        userCredentials.put("Rachel_Moraa", "password123");
        userCredentials.put("jane_Moraa", "Moraa123#");
    }

    public static boolean login(String username, String password, String dob) {
        // Check if the username exists in the database
        if (userCredentials.containsKey(username)) {
            // Check if the password matches the stored password for the username
            if (userCredentials.get(username).equals(password)) {
                // Additional check for date of birth can be added here if needed
                // For simplicity, we assume any date of birth is valid for now
                return true; // Return true if login is successful
            }
        }
        return false; // Return false if login fails
    }
}
