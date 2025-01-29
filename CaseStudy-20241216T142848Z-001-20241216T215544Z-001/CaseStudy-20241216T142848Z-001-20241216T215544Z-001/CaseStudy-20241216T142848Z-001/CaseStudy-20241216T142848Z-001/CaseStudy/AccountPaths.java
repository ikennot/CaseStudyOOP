package CaseStudy;
import java.time.LocalDate;

public class AccountPaths {

    private static final String ACCOUNT_NAME_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/Accountstextfiles/userAccount.txt";
    private static final String ACCOUNT_PASSWORD_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/Accountstextfiles/userpassword.txt";
    private static final String EMPLOYEE_USERNAME_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeName.txt";
    private static final String EMPLOYEE_PASSWORD_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/Employeepassword.txt";
    private static final String EMPLOYEE_NAME_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeName.txt"; 
    private static final String EMPLOYEE_ADDRESS_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeAddress.txt";
    private static final String EMPLOYEE_PHONENUM_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeePhonenum.txt";
    private static final String EMPLOYEE_EMAIL_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeAddress.txt";
    private static final String EMPLOYEE_SALARY_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeSalary.txt";
    private static final String EMPLOYEE_DEPARTMENT_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeDepartment.txt";
    private static final String EMPLOYEE_POSITION_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeePosition.txt";
    private static final String EMPLOYEE_STATUS_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeStatus.txt";
    private static final String EMPLOYEE_JOIN_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeJoin.txt";
    private static final String EMPLOYEE_ID_PATH = "CaseStudy-20241216T142848Z-001/CaseStudy/EmployeeInfos/EmployeeID.txt";
    private static final String empIn = "CaseStudy-20241216T142848Z-001/CaseStudy/Attendance/"+getDate()+"_timeIn.txt";
    private static final String empOut = "CaseStudy-20241216T142848Z-001/CaseStudy/Attendance/"+getDate()+"_timeOut.txt";
    private static final String Attendance = "CaseStudy-20241216T142848Z-001/CaseStudy/Attendance/"+getDate()+"_AttendanceName.txt";
    
    public String getAccountName() {
        return ACCOUNT_NAME_PATH;
    }

    public String getEmployeeID() {
        return EMPLOYEE_ID_PATH;
    }

    public String getAccountPassword() {
        return ACCOUNT_PASSWORD_PATH;
    }

    public String getEmployeeAccountName() {
        return EMPLOYEE_USERNAME_PATH;
    }
 
    public String getEmployeeAccountPassword() {
        return EMPLOYEE_PASSWORD_PATH;
    }

    public String getEmployeeName() { 
        return EMPLOYEE_NAME_PATH;
    }

    public String getEmployeeAddress() {
        return EMPLOYEE_ADDRESS_PATH;
    }

    public String getEmployeePhoneNum() {
        return EMPLOYEE_PHONENUM_PATH;
    }

    public String getEmployeeEmail() {
        return EMPLOYEE_EMAIL_PATH;
    }

    public String getEmployeeSalary() {
        return EMPLOYEE_SALARY_PATH;
    }

    public String getEmployeeDepartment() {
        return EMPLOYEE_DEPARTMENT_PATH;
    }

    public String getEmployeePosition() {
        return EMPLOYEE_POSITION_PATH;
    }

    public String getEmployeeStatus() {
        return EMPLOYEE_STATUS_PATH;
    }

    public String getEmployeeJoin() {
        return EMPLOYEE_JOIN_PATH;
    }

    public String getTimeIn()
    {
        return empIn;
    }

    public String getTimeOut(){
        return empOut;
    }
    public String getAttendanceName(){
        return Attendance;
    }

public static String getDate(){
 LocalDate myObj=LocalDate.now();
  String date = myObj.toString();
  return date;
}
}

