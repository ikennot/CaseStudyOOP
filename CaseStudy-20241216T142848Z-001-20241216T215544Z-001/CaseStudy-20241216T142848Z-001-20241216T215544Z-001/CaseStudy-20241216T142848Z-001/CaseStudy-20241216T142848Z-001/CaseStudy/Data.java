package CaseStudy;

import java.util.ArrayList;

abstract class Data {
     
    
    protected abstract ArrayList<String> readFile(String data);
    protected abstract void loadAllData();
    protected abstract void saveAllData();
   protected abstract void writeFile(String path, ArrayList<String> data);

}

