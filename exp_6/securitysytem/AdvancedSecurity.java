// AdvancedSecurity.java (Will result in a compilation error)
public class AdvancedSecurity extends SecuritySystem {
    // Attempt to override authenticateUser()
    @Override
    public boolean authenticateUser(String username, String password) {
        // Some modified authentication logic here
        return true; // For demonstration purposes
    }
}
