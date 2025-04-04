import java.util.*;

public class loginSignUp {

    // User class to store user info
    static class User {
        private final String fullName;
        private final String email;
        private final String password;

        public User(String fullName, String email, String password) {
            this.fullName = fullName;
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getFullName() {
            return fullName;
        }
    }

    // Simulate database using a list
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Welcome ====");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> signUp(scanner);
                case 2 -> logIn(scanner);
                case 3 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void signUp(Scanner scanner) {
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Check if email already exists
        if (getUserByEmail(email) != null) {
            System.out.println("Email already registered. Try logging in.");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }

        users.add(new User(fullName, email, password));
        System.out.println("Sign up successful!");
    }

    private static void logIn(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Welcome back, " + user.getFullName() + "!");
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    private static User getUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
}