import java.util.Scanner;

public class LoginSystem {

    
    static String[][] users = new String[100][2]; 
    static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    
    private static void displayMenu() {
        System.out.println("==== LOGIN SYSTEM ====");
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        System.out.println("[3] Exit");
        System.out.print("Enter your choice: o ");
    }

    
    private static int getChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                return choice;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    
    private static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        
        boolean usernameExists = false;
        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(username)) {
                usernameExists = true;
                break;
            }
        }

        if (usernameExists) {
            System.out.println("Username already exists. Please try a different one.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Registration failed.");
            return;
        }

        
        users[userCount][0] = username;
        users[userCount][1] = password;
        userCount++;

        System.out.println("Registration successful!");
    }

    
    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

       
        boolean userFound = false;
        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                userFound = true;
                break;
            }
        }

        if (userFound) {
            System.out.println("Hello, " + username + "!");
        } else {
            System.out.println("Invalid username or password!");
        }
    }
}

		
	