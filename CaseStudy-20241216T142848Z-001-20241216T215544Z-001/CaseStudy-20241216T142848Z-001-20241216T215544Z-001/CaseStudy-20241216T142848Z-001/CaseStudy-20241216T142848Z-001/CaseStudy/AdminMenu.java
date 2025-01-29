package CaseStudy;

import java.time.LocalDate;
import java.util.*;

public class AdminMenu {

    // Menu options for CRUD operations
    public void MenuOptions() {
        System.out.println("[1] ADD EMPLOYEE");
        System.out.println("[2] UPDATE EMPLOYEE");
        System.out.println("[3] DELETE EMPLOYEE");
        System.out.println("[4] View Attendace");
        System.out.println("[5] LOG OUT");
        System.out.print("Choose an option [1-4]: ");
    }

    // Department options
    public static void departmentOptions() {
        System.out.println("\t\t\t\t\tCHOOSE DEPARTMENT");
        System.out.println("\t\t\t\t\t[1] Human Resources");
        System.out.println("\t\t\t\t\t[2] Finance and Accounting");
        System.out.println("\t\t\t\t\t[3] Operations");
        System.out.println("\t\t\t\t\t[4] Sales and Marketing");
        System.out.println("\t\t\t\t\t[5] Information Technology (IT)");
        System.out.print("\t\t\t\t\tCHOOSE [1-5]: ");
    }

    // Get department code based on department name
    public static String getDepartmentCode(String department) {
        switch (department) {
            case "Human Resources": return "HR";
            case "Finance and Accounting": return "FIN";
            case "Operations": return "OPS";
            case "Sales and Marketing": return "MKT";
            case "Information Technology": return "IT";
            default: return "GEN";
        }
    }


    // CRUD operation menu
    public void CrudOperatiomMenu(String accountname) {
        Displays disp2 = new Displays();
        EmployeeData emp1 = new EmployeeData();
        Scanner scanner = new Scanner(System.in);

        crudMenu: while (true) {
            String department;
            int choose;
            emp1.displayEmployeeInfo();
            System.out.println("Welcome! " + accountname);
            MenuOptions();
            try{
            choose = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("\t\t\t\t\tPlease enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                disp2.delay();
                disp2.clearScreen();
                continue; // Go to the next iteration of the loop
            }

            switch (choose) {
                case 1:
                    disp2.clearScreen();
                    System.out.print("\t\t\t\t\tEnter New Employee Name: ");
                    String name = scanner.nextLine();
                    name=scanner.nextLine();
                    System.out.print("\t\t\t\t\tEnter New Employee Password: ");
                    String password = scanner.nextLine();
        

                    department: while (true) {
                        departmentOptions();
                        int choosedept = scanner.nextInt();
                        switch (choosedept) {
                            case 1: department = "Human Resources"; break department;
                            case 2: department = "Finance and Accounting"; break department;
                            case 3: department = "Operations"; break department;
                            case 4: department = "Sales and Marketing"; break department;
                            case 5: department = "Information Technology"; break department;
                            default: System.out.println("\t\t\t\t\tInvalid department"); break;
                        }
                    }

                    Random rand = new Random();
                    int uniquenum = rand.nextInt(10000);
                    String employeeID = String.format("%s%04d", getDepartmentCode(department), uniquenum);

                    scanner.nextLine();
                    System.out.print("\t\t\t\t\tEnter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("\t\t\t\t\tEnter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("\t\t\t\t\tEnter Salary: ");
                    String salary = scanner.nextLine();
                    System.out.print("\t\t\t\t\tEnter Contact Number (11-digits): ");
                    long contactnum = Long.parseLong(scanner.nextLine());

                    LocalDate myObj = LocalDate.now();
                    String dateString = myObj.toString();
                    String status = "Active";
                    CreateEmployee em1 = new CreateEmployee(name, password, department, position, contactnum, email, dateString, salary, status, employeeID);
                    em1.addAccount();

                    disp2.showLoading("SAVING INFO");
                    System.out.println("");
                    System.out.println("\t\t\t\t\tEMPLOYEE SUCCESSFULLY ADDED!");
                    Displays.delay();
                    disp2.clearScreen();
                    CrudOperatiomMenu(accountname);
                    break;

                case 2:
                    disp2.clearScreen();
                    emp1.displayEmployeeInfo();
                    System.out.print("Enter the number of Employee do you want to update: ");
                    int employeenum = scanner.nextInt();
                    updateOptions();
                    int updatenum = scanner.nextInt();

                    System.out.print("Enter new Info: ");
                    String updateInfo = scanner.nextLine();
                    updateInfo = scanner.nextLine();
                    emp1.updateEmployeeInfo(employeenum, updatenum, updateInfo);
                    disp2.showLoading("UPDATING INFO");
                    System.out.println("");
                    System.out.println("EMPLOYEE SUCCESSFULLY UPDATED!");
                    Displays.delay();
                    disp2.clearScreen();
                    break;

                case 3:
                    disp2.clearScreen();
                    emp1.displayEmployeeInfo();
                    System.out.print("Choose a number do you want to delete: ");
                    int choodeDelete = scanner.nextInt();
                    emp1.deleteEmployee(choodeDelete);
                    disp2.showLoading("Deleting info");
                    System.out.println("");
                    System.out.println("Successfully deleted!");
                    disp2.delay();
                    disp2.clearScreen();
                    break;
                 
                case 4:
                
                    AttendanceData ad = new AttendanceData();

                    ad.displayAttendanceGrid();

                    System.out.print("Press any key to exit: ");
                    char key = scanner.next().charAt(0);
                    disp2.clearScreen();
                    
                    break;
                
                case 5:
                    disp2.showLoading("Logging out");
                    disp2.clearScreen();
                    Main myMain = new Main();
                    myMain.MainMenu();
                    break crudMenu;

                default:
                    System.out.println("INVALID INPUT!");
                    disp2.delay();
                    disp2.clearScreen();
                    break;
            }
        }
    }

    // Update options menu
    public void updateOptions() {
        System.out.println("[1] UPDATE EMPLOYEE NAME");
        System.out.println("[2] UPDATE EMPLOYEE PASSWORD");
        System.out.println("[3] UPDATE EMPLOYEE EMAIL");
        System.out.println("[4] DELETE EMPLOYEE PHONE NUMBER");
        System.out.println("[5] UPDATE EMPLOYEE POSITION");
        System.out.println("[6] UPDATE EMPLOYEE SALARY");
        System.out.print("Choose an option [1-6]: ");
    }
}
