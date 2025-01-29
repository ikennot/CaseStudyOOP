package CaseStudy;

import java.util.HashMap;

public class LogIn {
    private String username;
    private String password;

    LogIn(String username,String password){
         this.username=username;
         this.password=password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    
    public boolean isAccountExist() {
    AdminData adminData = new AdminData();
    HashMap<String, String> accounts = adminData.getAccounts();

    // Check if the username exists and the corresponding password matches
    return accounts.containsKey(username) && accounts.get(username).equals(password);
}

    

}
