package CaseStudy;

import java.io.*;
import java.nio.file.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class EmployeeLogin {

    // Method for displaying the login menu
    public void loginMenu() {
        Displays d1 = new Displays();
        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false; // Flag to check authentication status
        String empUsername = null;

        while (!isAuthenticated) {
            System.out.print("\t\t\t\t\tEnter Username: ");
            empUsername = scanner.nextLine().trim();

            System.out.print("\t\t\t\t\tEnter Password: ");
            String empPassword = scanner.nextLine().trim();
            d1.showLoading("Logging in");
            // Validate credentials from files
            if (isEmployeeCredentialsValid(empUsername, empPassword)) {
                System.out.println("");
                System.out.println("\t\t\t\t\tEmployee login successful!");
                d1.delay();
                isAuthenticated = true; // Update flag to exit the loop
            } else {
                System.out.println("");
                System.out.println("\t\t\t\t\tInvalid Username or Password!");
                System.out.println("\t\t\t\t\tPlease try again.");
                d1.delay();
                d1.clearScreen();
                return;
             
            }
        }

        // Proceed to employee menu after successful login
        employeeMenu(empUsername);
    }

    // Method to validate the employee credentials against the files
    private boolean isEmployeeCredentialsValid(String username, String password) {
        try {
            // Read employee credentials from the files using AccountPaths
            AccountPaths accountPaths = new AccountPaths();
            List<String> usernames = Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountName()));
            List<String> passwords = Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountPassword()));

            // Check if the username and password match any entry in the files
            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).trim().equals(username) && passwords.get(i).trim().equals(password)) {
                    return true; // Credentials match
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading employee credentials: " + e.getMessage());
        }
        return false; // No match found
    }

    // Employee menu after successful login
    private void employeeMenu(String username) {
        Scanner scanner = new Scanner(System.in);
    Displays d1 = new Displays();
        while (true) {
            d1.clearScreen();
            LocalTime currentTime = LocalTime.now();
            LocalTime targetTime = LocalTime.of(17, 0); 
            LocalTime start = LocalTime.MIDNIGHT;         // 12:00 AM
            LocalTime end = LocalTime.of(6, 59);          // 6:59 AM
            System.out.println("\n\t\t\t\t\tEMPLOYEE MENU");
            System.out.println("\t\t\t\t\t[1] VIEW PROFILE");
            System.out.println("\t\t\t\t\t[2] UPDATE PROFILE");
             if(currentTime.isBefore(targetTime))
            System.out.println("\t\t\t\t\t[3] Attendance (Time in)");
             else
            System.out.println("\t\t\t\t\t[3] Attendance (Time out)");
            System.out.println("\t\t\t\t\t[4] Employment Status");
            System.out.println("\t\t\t\t\t[5] LOG OUT");
            System.out.print("\t\t\t\t\tChoose an option [1-4]: ");
            int choice=0;
            try{
            choice= scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("\t\t\t\t\tPlease enter a valid number.");
                d1.delay();
                scanner.nextLine(); // Clear the invalid input
                continue; // Go to the next iteration of the loop
            }
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                d1.clearScreen();
                    // Call a method to view profile
                    System.out.println("\t\t\t\t\t╔══════════════════════════════════════════════════════════╗");
                    System.out.println("\t\t\t\t\t║                       VIEW PROFILE                       ║");
                    System.out.println("\t\t\t\t\t╚══════════════════════════════════════════════════════════╝");
                    viewProfile(username);
                    System.out.print("\t\t\t\t\tPress any key to Exit: ");
                    char anykey = scanner.next().charAt(0);
                    break;
                case 2:
                d1.clearScreen();
                    // Call method to update profile
                    System.out.println("\t\t\t\t\t╔══════════════════════════════════════════════════════════╗");
                    System.out.println("\t\t\t\t\t║                      UPDATING DETAILS                    ║");
                    System.out.println("\t\t\t\t\t╚══════════════════════════════════════════════════════════╝");
                    username = updateProfile(username); // Update the username in case it changes
                    break;
                    case 3:
                    currentTime = LocalTime.now();
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
                String formattedTime = currentTime.format(formatter);
                if(currentTime.equals(targetTime)||currentTime.isAfter(targetTime)){
                   AttendanceData ad = new AttendanceData();
                   ad.setTimeOut(username,formattedTime);
                   d1.clearScreen();
                }else if (!currentTime.isBefore(start) && !currentTime.isAfter(end)) {
                    System.out.println("\t\t\t\t\tTiming in not available!");
                    d1.delay();
                    d1.clearScreen();
                    break;
                }
                
                else{
                    AttendanceData ad = new AttendanceData();
                    ad.addAttendance(formattedTime, username);
                }
                    break; 
                case 4:
                d1.clearScreen();
                String status;
                System.out.println("\t\t\t\t\tCHOOSE EMPLOYEMENT STATUS");
                System.out.println("\t\t\t\t\t[1]FILE A LEAVE");
                System.out.println("\t\t\t\t\t[2]SET ACTIVE STATUS");
                System.out.println("\t\t\t\t\t[3]Exit");
                System.out.print("\t\t\t\t\tCHOOSE (1-2)");
                int statuschoice= 0;
                try{
                statuschoice= scanner.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("\t\t\t\t\tInvalid Input");
                    d1.delay();
                    break;
                }
                if(statuschoice == 1){
                     status ="On leave";
                }else if(statuschoice == 2){
                    status ="Active ";

                } else if (statuschoice == 3) {
                    d1.clearScreen();
                    break;
                
                }
                else {
                    System.out.println("");
                    System.out.println("\t\t\t\t\tInvalid input!");
                    d1.delay();
                    d1.clearScreen();
                    break;
                }
                EmployeeData data = new EmployeeData();
                data.statusSet(username, status);
                d1.showLoading("Saving info");
                System.out.println("\t\t\t\t\tDone!");
                d1.delay();
                d1.clearScreen();
                break;
                case 5:
                    d1.showLoading("Logging out");
                    d1.clearScreen();
                    return; // Exit menu and log out
                default:
                    System.out.println("\t\t\t\t\tInvalid choice. Try again.");
            }
        }
    }

    // Method to display employee profile details
    private void viewProfile(String username) {
        AccountPaths accountPaths = new AccountPaths();

        try {
            // Read employee details from the files
            List<String> usernames = Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountName()));
            List<String> names = Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountName()));
            List<String> phoneNumbers = Files.readAllLines(Paths.get(accountPaths.getEmployeePhoneNum()));
            List<String> emails = Files.readAllLines(Paths.get(accountPaths.getEmployeeEmail()));
            List<String> salaries = Files.readAllLines(Paths.get(accountPaths.getEmployeeSalary()));
            List<String> departments = Files.readAllLines(Paths.get(accountPaths.getEmployeeDepartment()));
            List<String> positions = Files.readAllLines(Paths.get(accountPaths.getEmployeePosition()));
            List<String> statuses = Files.readAllLines(Paths.get(accountPaths.getEmployeeStatus()));
            List<String> joinDates = Files.readAllLines(Paths.get(accountPaths.getEmployeeJoin()));
            List<String> ids = Files.readAllLines(Paths.get(accountPaths.getEmployeeID()));

            // Loop through all employee records to find the one matching the username
            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).trim().equals(username)) {
                    // Print all details of the employee
                    System.out.println("\t\t\t\t\tName: " + names.get(i));
                    System.out.println("\t\t\t\t\tEmployee ID: " + ids.get(i));
                    System.out.println("\t\t\t\t\tPhone Number: " + phoneNumbers.get(i));
                    System.out.println("\t\t\t\t\tEmail: " + emails.get(i));
                    System.out.println("\t\t\t\t\tSalary: " + salaries.get(i));
                    System.out.println("\t\t\t\t\tDepartment: " + departments.get(i));
                    System.out.println("\t\t\t\t\tPosition: " + positions.get(i));
                    System.out.println("\t\t\t\t\tStatus: " + statuses.get(i));
                    System.out.println("\t\t\t\t\tJoin Date: " + joinDates.get(i));
                    return; // Exit after displaying the profile
                }
            }
            System.out.println("\t\t\t\t\tProfile not found.");
        } catch (IOException e) {
            System.out.println("\t\t\t\t\tError reading employee profile: " + e.getMessage());
        }
    }

    // Method to update employee profile details
    private String updateProfile(String currentUsername) {
        Scanner scanner = new Scanner(System.in);
        AccountPaths accountPaths = new AccountPaths();

        try {
            // Read employee details from the files
            List<String> usernames = new ArrayList<>(Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountName())));
            List<String> names = new ArrayList<>(Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountName())));
            List<String> phoneNumbers = new ArrayList<>(Files.readAllLines(Paths.get(accountPaths.getEmployeePhoneNum())));
            List<String> emails = new ArrayList<>(Files.readAllLines(Paths.get(accountPaths.getEmployeeEmail())));
            List<String> passwords = new ArrayList<>(Files.readAllLines(Paths.get(accountPaths.getEmployeeAccountPassword())));

            // Loop through all employee records to find the one matching the current username
            for (int i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).trim().equals(currentUsername)) {
                    boolean exit = false;

                    while (!exit) {
                        // Display menu for updating options
                        System.out.println("\n\t\t\t\t\tUpdate Profile");
                        System.out.println("\t\t\t\t\t1. Update Name");
                        System.out.println("\t\t\t\t\t2. Update Email");
                        System.out.println("\t\t\t\t\t3. Update Contact Number");
                        System.out.println("\t\t\t\t\t4. Update Password");
                        System.out.println("\t\t\t\t\t5. Exit");
                        System.out.print("\t\t\t\t\tChoose an option: ");
                        String choice = scanner.nextLine().trim();

                        switch (choice) {
                            case "1": // Update Username
                                System.out.print("\t\t\t\t\tEnter new Name: ");
                                String newUsername = scanner.nextLine().trim();
                                if (!newUsername.isEmpty()) {
                                    usernames.set(i, newUsername);
                                    Files.write(Paths.get(accountPaths.getEmployeeAccountName()), usernames);
                                    System.out.println("\t\t\t\t\tUsername updated successfully!");
                                    currentUsername = newUsername;
                                } else {
                                    System.out.println("\t\t\t\t\tNo changes made to Username.");
                                }
                                break;

                            case "2": // Update Email
                                System.out.print("\t\t\t\t\tEnter new Email: ");
                                String newEmail = scanner.nextLine().trim();
                                if (!newEmail.isEmpty()) {
                                    emails.set(i, newEmail);
                                    Files.write(Paths.get(accountPaths.getEmployeeEmail()), emails);
                                    System.out.println("\t\t\t\t\tEmail updated successfully!");
                                } else {
                                    System.out.println("\t\t\t\t\tNo changes made to Email.");
                                }
                                break;

                            case "3": // Update Contact Number
                                System.out.print("\t\t\t\t\tEnter new Contact Number: ");
                                String newContact = scanner.nextLine().trim();
                                if (!newContact.isEmpty()) {
                                    phoneNumbers.set(i, newContact);
                                    Files.write(Paths.get(accountPaths.getEmployeePhoneNum()), phoneNumbers);
                                    System.out.println("\t\t\t\t\tContact Number updated successfully!");
                                } else {
                                    System.out.println("\t\t\t\t\tNo changes made to Contact Number.");
                                }
                                break;

                            case "4": // Update Password
                                System.out.print("\t\t\t\t\tEnter new Password: ");
                                String newPassword = scanner.nextLine().trim();
                                if (!newPassword.isEmpty()) {
                                    passwords.set(i, newPassword);
                                    Files.write(Paths.get(accountPaths.getEmployeeAccountPassword()), passwords);
                                    System.out.println("\t\t\t\t\tPassword updated successfully!");
                                } else {
                                    System.out.println("\t\t\t\t\tNo changes made to Password.");
                                }
                                break;

                            case "5": // Exit the update process
                                exit = true;
                                System.out.println("\t\t\t\t\tExiting profile update...");
                                break;

                            default:
                                System.out.println("\t\t\t\t\tInvalid option! Please try again.");
                                break;
                        }
                    }
                    break; // Exit the loop after updating the profile
                }
            }
        } catch (IOException e) {
            System.out.println("\t\t\t\t\tError updating employee profile: " + e.getMessage());
        }
        return currentUsername; // Return the updated username
    }
}
