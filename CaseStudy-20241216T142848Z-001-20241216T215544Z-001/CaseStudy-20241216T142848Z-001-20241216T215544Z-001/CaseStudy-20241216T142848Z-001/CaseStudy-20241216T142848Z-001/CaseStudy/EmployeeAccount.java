package CaseStudy;

public class EmployeeAccount extends AdminAccount {
    private String employeeID;
    private String department;

    public EmployeeAccount(String username, String password, String employeeID, String department) {
        super(username, password); // Call the AdminAccount constructor
        this.employeeID = employeeID;
        this.department = department;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
