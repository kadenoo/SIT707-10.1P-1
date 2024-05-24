public class RegistrationService {

    public static boolean register(String fName, String lName, String email, String dob) {
        // Perform registration logic
        
        System.out.println("Registration successful for:");
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("Date of Birth: " + dob);
        
        return true;
    }
}
