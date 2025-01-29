package CaseStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceData extends Data{
   // private String Datenow;
   // private String EmployeeName;
     private ArrayList<String> name;
     private ArrayList<String> timeIn;
     private ArrayList<String> timeOut;

/*
 * public AttendanceData(String Datenow,String EmployeeName){
          loadAllData();
          this.Datenow = Datenow;
          this.EmployeeName= EmployeeName;
    }
 * 
 * 
 */
       

    public AttendanceData(){
     loadAllData();

}


public void addAttendance(String Datenow, String EmployeeName) {
  // I-load muna ang data para ma-check kung may existing time in na
  AccountPaths a = new AccountPaths();
  Displays d1 = new Displays();
  
  // I-check kung ang empleado ay may existing time in na sa araw na ito
  boolean alreadyTimedIn = false;
  for (int i = 0; i < name.size(); i++) {
      if (EmployeeName.equals(name.get(i)) && 
          timeOut.get(i).equals("_")) {
          alreadyTimedIn = true;
          break;
      }
  }
  
  // Kung hindi pa naka-time in sa araw na ito, magpatuloy sa pag-time in
  if (!alreadyTimedIn) {
      try (
          FileWriter accountNameFile = new FileWriter(a.getAttendanceName(), true);
          FileWriter timeInFile = new FileWriter(a.getTimeIn(), true);
          FileWriter TimeOutFile = new FileWriter(a.getTimeOut(), true);
      ) {
          accountNameFile.write(EmployeeName + System.lineSeparator());
          timeInFile.write(Datenow + System.lineSeparator());
          TimeOutFile.write("_" + System.lineSeparator());
          d1.showLoading("Saving");
          System.out.println("");
          System.out.println("\t\t\t\t\tAttendance saved!");
          d1.delay();
          d1.clearScreen();
          System.out.println("Time in successful.");
      } catch (Exception e) {
          System.out.println("Failed to time in: " + e.getMessage());
      }
  } else {
      System.out.println("You have already timed in for today.");
      d1.delay();
      d1.clearScreen();
  }
}
    public void setTimeOut(String username,String Date){
      Displays d1 = new Displays();
      for(int i = 0; i < name.size();i++){
        if(username.equals(name.get(i))){
        timeOut.set(i, Date);
        saveAllData();
        d1.showLoading("Saving");
          System.out.println("");
          System.out.println("\t\t\t\t\tAttendance saved!");
          d1.delay();
          return;
        }
      }
      System.out.println("\t\t\t\t\tYou didnt time in!");
      d1.delay();
    }


      @Override
      protected ArrayList<String> readFile(String path) {
        Displays d1 = new Displays();
       ArrayList<String> fileData = new ArrayList<>();
    try {
        File file = new File(path); // Gamitin ang parameter na 'path'
        Scanner readfile = new Scanner(file);
        while (readfile.hasNextLine()) {
            fileData.add(readfile.nextLine());
        }
        readfile.close();
        d1.clearScreen();
    } catch (FileNotFoundException e) {
      d1.clearScreen();
    }
    return fileData;
      }

      public void displayAttendanceGrid() {
        loadAllData(); // Load all the data first
    
        // Find the maximum width for each column dynamically
        int maxNameLength = "Employee Name".length();
        int maxTimeInLength = "Time In".length();
        int maxTimeOutLength = "Time Out".length();
    
        for (String employee : name) {
            maxNameLength = Math.max(maxNameLength, employee.length());
        }
    
        for (String inTime : timeIn) {
            maxTimeInLength = Math.max(maxTimeInLength, inTime.length());
        }
    
        for (String outTime : timeOut) {
            maxTimeOutLength = Math.max(maxTimeOutLength, outTime.length());
        }
    
        // Add some padding
        maxNameLength += 2;
        maxTimeInLength += 2;
        maxTimeOutLength += 2;
    
        // Print the header with dynamic width
        System.out.printf("%-" + maxNameLength + "s%-" + maxTimeInLength + "s%-" + maxTimeOutLength + "s%n", "Employee Name", "Time In", "Time Out");
        System.out.println("-".repeat(maxNameLength + maxTimeInLength + maxTimeOutLength));
    
        // Print each row of data
        for (int i = 0; i < name.size(); i++) {
            String employee = name.get(i);
            String inTime = (i < timeIn.size()) ? timeIn.get(i) : "N/A";
            String outTime = (i < timeOut.size()) ? timeOut.get(i) : "N/A";
    
            System.out.printf("%-" + maxNameLength + "s%-" + maxTimeInLength + "s%-" + maxTimeOutLength + "s%n", employee, inTime, outTime);
        }
    }
    
    
      @Override
      protected void loadAllData() {
        AccountPaths a = new AccountPaths();
        name = readFile(a.getAttendanceName());
        timeIn = readFile(a.getTimeIn());
        timeOut = readFile(a.getTimeOut());
      }

      @Override
      protected void saveAllData() {
        AccountPaths a = new AccountPaths();
         writeFile(a.getAttendanceName(), name);
         writeFile(a.getTimeIn(), timeIn);
         writeFile(a.getTimeOut(), timeOut);
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
