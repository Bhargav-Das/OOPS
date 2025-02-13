public class Securities {
    public static void main(String[] args) {
        SecuritySystem security = new SecuritySystem();

        // Attempt to authenticate a user
        boolean isAuthenticated = security.authenticateUser("admin", "password1");

        if (isAuthenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
