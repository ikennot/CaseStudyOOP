package CaseStudy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateEmployee extends CreateAccount {
    private String EmployeeID;
    private String department;
    private String position;
    private long contactnum;
    private String email;
    private String datehired;
    private String salary;
    private String status;

    public CreateEmployee(String accountname, String accountPassword, String department, String position,
                          long contactnum, String email, String datehired, String salary, String status,String EmployeeID) {
        super(accountname, accountPassword); // Super constructor to initialize account fields
        this.department = department;
        this.position = position;
        this.contactnum = contactnum;
        this.email = email;
        this.datehired = datehired;
        this.salary = salary;
        this.status = status;
        this.EmployeeID = EmployeeID;
    }

    

 
    
    @Override
    public void addAccount() {
        AccountPaths a1 = new AccountPaths();
        
        // Create directories if they do not exist
        File accountDir = new File("CaseStudy/Employeeinfos/"); // Fix directory name to match previous code
        if (!accountDir.exists()) {
            accountDir.mkdirs(); // Create the directory structure if it doesn't exist
        }

        try (FileWriter accountNameFile = new FileWriter(a1.getEmployeeAccountName(), true);
             FileWriter accountPasswordFile = new FileWriter(a1.getEmployeeAccountPassword(), true);
             FileWriter departmentFile = new FileWriter(a1.getEmployeeDepartment(), true);
             FileWriter positionFile = new FileWriter(a1.getEmployeePosition(), true);
             FileWriter contactNumFile = new FileWriter(a1.getEmployeePhoneNum(), true);
             FileWriter emailFile = new FileWriter(a1.getEmployeeEmail(), true);
             FileWriter datejoinFile = new FileWriter(a1.getEmployeeJoin(), true);
             FileWriter salaryFile = new FileWriter(a1.getEmployeeSalary(), true);
             FileWriter statusFile = new FileWriter(a1.getEmployeeStatus(), true);
             FileWriter IDfile = new FileWriter(a1.getEmployeeID(),true);
             
             ) {

            // Write account name and password with new line
            accountNameFile.write(super.getAccountname() + System.lineSeparator());
            accountPasswordFile.write(super.getAccountpassword() + System.lineSeparator());
            
            // Write other employee details
            departmentFile.write(department + System.lineSeparator());
            positionFile.write(position + System.lineSeparator());
            contactNumFile.write(String.valueOf(contactnum) + System.lineSeparator());
            emailFile.write(email + System.lineSeparator());
            datejoinFile.write(datehired+System.lineSeparator());
            salaryFile.write(String.valueOf(salary) + System.lineSeparator());
            statusFile.write(status + System.lineSeparator());
            IDfile.write(EmployeeID+System.lineSeparator());
           
        } catch (IOException e) {
            System.out.println("Failed to create account: " + e.getMessage());
        }
    }
}
