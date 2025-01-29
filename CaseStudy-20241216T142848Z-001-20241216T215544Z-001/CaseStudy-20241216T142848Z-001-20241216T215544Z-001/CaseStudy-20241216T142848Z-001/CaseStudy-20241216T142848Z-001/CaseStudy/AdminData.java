package CaseStudy;
import java.io.*;
import java.util.*;
public class AdminData extends Data {
  private HashMap<String, String> accounts;


public AdminData(){
loadAllData();
}
  
@Override
protected void loadAllData(){
  AccountPaths a = new AccountPaths();
  ArrayList<String>accname=readFile(a.getAccountName());
  ArrayList<String>accPassword=readFile(a.getAccountPassword());
  accounts = new HashMap<>();

  for(int i = 0; i < accname.size();i++){
    accounts.put(accname.get(i), accPassword.get(i));
  }
}
public HashMap<String, String> getAccounts() {
  return accounts;
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

    @Override
    protected void saveAllData() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'saveAllData'");
    }

    @Override
    protected void writeFile(String path, ArrayList<String> data) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'writeFile'");
    }

   
    }
   




