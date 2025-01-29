package CaseStudy;

import java.util.*;

public class Main {
    public static String accountname;
    public static Scanner scanner = new Scanner(System.in);

    // Method to handle system options after login
    public static void SystemOptions(boolean isAccountExist) {
        if (!isAccountExist)
            return;

        AdminMenu menu1 = new AdminMenu();
        menu1.CrudOperatiomMenu(accountname);
    }

    // Login method for admin
    public static void LogIn() {
        String accountPassword;
        System.out.print("\t\t\t\t\tEnter account name: ");
        accountname = scanner.nextLine();
        System.out.print("\t\t\t\t\tEnter account password: ");
        accountPassword = scanner.nextLine();

        LogIn l1 = new LogIn(accountname, accountPassword);

        Displays disp = new Displays();
        disp.showLoading("Logging in");
        if (l1.isAccountExist()) {
            System.out.println("\n\t\t\t\t\tLOG IN SUCCESSFUL!");
            disp.delay();
            disp.clearScreen();
        } else {
            System.out.println("");
            System.out.println("\t\t\t\t\tFailed to Log in. Invalid account or password.");
            System.out.println("\t\t\t\t\tPlease try again or check your credentials.");
            disp.clearScreen();
            return;
        }

        SystemOptions(l1.isAccountExist());
    }

    // Main menu for navigation
    public void MainMenu() {
        Displays d1 = new Displays();
        int choice = 0;

        LogInMenu: while (true) {
            System.out.println("\t\t\t\t\t╔══════════════════════════════════════════════════════════╗");
            System.out.println("\t\t\t\t\t║               EMPLOYEE MANAGEMENT SYSTEM                 ║");
            System.out.println("\t\t\t\t\t╚══════════════════════════════════════════════════════════╝");

            System.out.println("\t\t\t\t\t[1] LOG IN AS ADMIN");
            System.out.println("\t\t\t\t\t[2] EMPLOYEE LOG IN");
            System.out.println("\t\t\t\t\t[3] Exit");
            System.out.print("\t\t\t\t\tChoose an option [1-3]: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline after reading integer input
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\tPlease enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Go to the next iteration of the loop
            }

            switch (choice) {
                case 1:
                    d1.clearScreen();
                    System.out.println("\t\t\t\t\t╔════════════════════════════════════════════════════╗");
                    System.out.println("\t\t\t\t\t║                  ADMIN LOG IN                      ║");
                    System.out.println("\t\t\t\t\t╚════════════════════════════════════════════════════╝");

                    LogIn();
                    break;
               // case 2:
                 //   createAccount();
                 //   break;
                case 2:
                    d1.clearScreen();
                    System.out.println("\t\t\t\t\t╔════════════════════════════════════════════════════╗");
                    System.out.println("\t\t\t\t\t║                  EMPLOYEE LOG IN                   ║");
                    System.out.println("\t\t\t\t\t╚════════════════════════════════════════════════════╝");
                    // Initialize EmployeeLogin and call the loginMenu() method
                    EmployeeLogin employeeLogin = new EmployeeLogin();
                    employeeLogin.loginMenu();  // Call the Employee Login Menu
                    break;
                case 3:
                    System.out.println("\t\t\t\t\tTHANK YOU!");
                    System.exit(0);
                    break LogInMenu;
                default:
                    break;
            }
        }
    }

    // Main method for starting the program
    public static void main(String[] args) {
        Main myMain = new Main();
        myMain.MainMenu();
    }
}
