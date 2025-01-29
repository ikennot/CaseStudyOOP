package CaseStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeData extends Data{
  private ArrayList<String> name;
  private ArrayList<String> address;
  private ArrayList<String> department;
  private ArrayList<String> position;
  private ArrayList<String> salary;
  private ArrayList<String> join;
  private ArrayList<String> status;
  private ArrayList<String> phone;
  private ArrayList<String> id;
  private ArrayList<String> password;
    
  public EmployeeData() {
    loadAllData();
}
@Override
protected ArrayList<String> readFile(String path) {
    ArrayList<String> fileData = new ArrayList<>();
    try {
        File file = new File(path); // Gamitin ang parameter na 'path'
        Scanner readfile = new Scanner(file);
        while (readfile.hasNextLine()) {
            fileData.add(readfile.nextLine());
        }
        readfile.close();
    } catch (FileNotFoundException e) {
        System.out.println("\t\t\t\t\tFailed to find file: " + path);
    }
    return fileData;
}
public void updateEmployeeInfo(int Employeenum,int updatenum,String update){
    if(Employeenum>id.size() || Employeenum <0)
    {
      System.out.print("Invalid number to update: ");
      return;
    }
   switch(updatenum){
      case 1://update account name
       name.set(Employeenum-1, update);
      break;
      case 2:// update account password
      password.set(Employeenum-1, update);
      break;
      case 3://update Employee email
      address.set(Employeenum-1, update);
      break;
      case 4:// update phonenum
      phone.set(Employeenum-1, update);
      break;
    case 5://update position
    position.set(Employeenum-1, update);
    break;
     case 6://update salary
     salary.set(Employeenum-1, update);
     break;
   }
   saveAllData();
}

public void statusSet(String username,String set){
   for(int i = 0; i < name.size();i++){
    if(name.get(i).equals(username))
      status.set(i, set);saveAllData();
   }
}

  @Override
  protected  void loadAllData() {
  AccountPaths a = new AccountPaths();
  name = readFile(a.getEmployeeAccountName());
  address = readFile(a.getEmployeeAddress());
  department = readFile(a.getEmployeeDepartment());
  position = readFile(a.getEmployeePosition());
  salary = readFile(a.getEmployeeSalary());
  join = readFile(a.getEmployeeJoin());
  status = readFile(a.getEmployeeStatus());
  phone = readFile(a.getEmployeePhoneNum());
  id = readFile(a.getEmployeeID());
  password = readFile(a.getEmployeeAccountPassword());
}
    public void displayEmployeeInfo() {
    
      // Dynamic length computation for each field
      int idWidth = getMaxWidth(id, "ID");
      int nameWidth = getMaxWidth(name, "Name");
      int addressWidth = getMaxWidth(address, "Address");
      int phoneWidth = getMaxWidth(phone, "Phone");
      int departmentWidth = getMaxWidth(department, "Department");
      int positionWidth = getMaxWidth(position, "Position");
      int salaryWidth = getMaxWidth(salary, "Salary");
      int joinWidth = getMaxWidth(join, "Join Date");
      int statusWidth = getMaxWidth(status, "Status");
  
      // Header ng grid na may numbering at Employee ID
      String format = String.format("%%-5s %%-%ds %%-%ds %%-%ds %%-%ds %%-%ds %%-%ds %%-%ds %%-%ds %%-%ds%%n",
                                    idWidth, nameWidth, addressWidth, phoneWidth, departmentWidth,
                                    positionWidth, salaryWidth, joinWidth, statusWidth);
  
      System.out.printf(format, "No.", "ID", "Name", "Address", "Phone", "Department", "Position", "Salary", "Join Date", "Status");
      System.out.println("-".repeat(idWidth + nameWidth + addressWidth + phoneWidth + departmentWidth + positionWidth + salaryWidth + joinWidth + statusWidth + 35));
  
      // Pag-display ng data sa grid na may numbering
      for (int i = 0; i < name.size(); i++) {
          System.out.printf(format, 
                            i + 1, id.get(i), name.get(i), address.get(i), phone.get(i),
                            department.get(i), position.get(i), salary.get(i), join.get(i), status.get(i));
      }
  }
  
  // Method para kunin ang maximum width ng data sa isang field
  private int getMaxWidth(ArrayList<String> list, String header) {
      int max = header.length();
      for (String item : list) {
          if (item.length() > max) {
              max = item.length();
          }
      }
      return max + 2; // dagdagan ng padding para hindi dikit-dikit
  }

 
public void deleteEmployee(int num)
{
if(num>id.size() || num <0)
{
  System.out.print("Invalid number to delete: ");
  return;
}
id.remove(num-1);
name.remove(num-1);
address.remove(num-1);
department.remove(num-1);
position.remove(num-1);
salary.remove(num-1);
join.remove(num-1);
status.remove(num-1);
phone.remove(num-1);
password.remove(num-1);
saveAllData();


}
@Override
protected void saveAllData() {
 AccountPaths a = new AccountPaths();
 writeFile(a.getEmployeeAddress(), address);
 writeFile(a.getEmployeeDepartment(), department);
 writeFile(a.getEmployeePosition(), position);
 writeFile(a.getEmployeeSalary(), salary);
 writeFile(a.getEmployeeJoin(), join);
 writeFile(a.getEmployeeStatus(), status);
 writeFile(a.getEmployeePhoneNum(), phone);
 writeFile(a.getEmployeeID(), id);
 writeFile(a.getEmployeeAccountPassword(),password);
 writeFile(a.getEmployeeAccountName(), name);
}

@Override
protected void writeFile(String path, ArrayList<String> data) {
    try (PrintWriter writer = new PrintWriter(path)) {
        for (String line : data) {
            writer.println(line);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Failed to save file: " + path);
    }
}

    
}
