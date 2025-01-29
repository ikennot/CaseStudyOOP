package CaseStudy;

import java.io.*;

public class CreateAccount {
    private String accountname;
    private String accountpassword;
    private String EmployeeName;

    // Constructor
    public CreateAccount(String EmployeeName, String accountpassword) {
        this.accountname = EmployeeName; // Account name is the same as employee name
        this.EmployeeName = EmployeeName; // Ensure they match
        this.accountpassword = accountpassword;
    }

    public String getAccountname() {
        return accountname;
    }

    public String getAccountpassword() {
        return accountpassword;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    // Method to add account details to the files
    public void addAccount() {
        AccountPaths paths = new AccountPaths();

        // Create directories if they do not exist
        File accountDir = new File("CaseStudy/Accountstextfiles/");
        if (!accountDir.exists()) {
            accountDir.mkdirs(); // Create the directory structure if it doesn't exist
        }

        try (FileWriter accountNameFile = new FileWriter(paths.getAccountName(), true);
             FileWriter accountPasswordFile = new FileWriter(paths.getAccountPassword(), true);
             FileWriter employeeNameFile = new FileWriter(paths.getEmployeeAccountName(), true)) {
             
            // Write account name, password, and employee name with new lines
            accountNameFile.write(accountname + System.lineSeparator());
            accountPasswordFile.write(accountpassword + System.lineSeparator());
            employeeNameFile.write(EmployeeName + System.lineSeparator());

            System.out.println("\t\t\t\t\tSuccessfully added account.");
        } catch (IOException e) {
            System.out.println("Failed to create account: " + e.getMessage());
        }
    }
}
