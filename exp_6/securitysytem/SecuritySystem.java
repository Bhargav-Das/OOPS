// SecuritySystem.java
public final class SecuritySystem {
    private String[] validUsers = {"admin", "user1", "user2"};
    private String[] validPasswords = {"password1", "password2", "password3"};

    // Method to authenticate a user
    public boolean authenticateUser(String username, String password) {
        for (int i = 0; i < validUsers.length; i++) {
            if (validUsers[i].equals(username) && validPasswords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

