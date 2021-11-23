package Java.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TableReader {
    Map<String ,String> user_info_map;

    public TableReader(){
        user_info_map = new HashMap<String,String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/data/UserInfoTable.csv")); // filename here
            reader.readLine(); //Ignore line 1
            String line = null;
            while((line=reader.readLine())!=null){
                String[] item = line.split(","); //split the items by comma

                user_info_map.put(item[0], item[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean UserMatch(String user, String password){
        if(user_info_map.containsKey(user)) {
            return user_info_map.get(user).equals(password);
        }else {
            return false;
        }
    }

    public boolean AddNewUser(String user, String password){
        boolean duplicated = user_info_map.containsKey(user);
        if (!duplicated) {
            user_info_map.put(user, password);
            UpdateTable(user, password);
            return true;
        }else{
            return false;
        }
    }

    public void UpdateTable(String user, String password){
        try {
            File csv = new File("src/data/UserInfoTable.csv");

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.newLine();
            bw.write(user + "," + password);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Simple testing
        TableReader info = new TableReader();
//        System.out.println(info.UserMatch("Admin", "adminadmin"));
        info.AddNewUser("a", "12345678");
//        System.out.println(info.UserMatch("a", "12345678"));
        System.out.println(info.AddNewUser("a", "12345678"));
        System.out.println(info.UserMatch("b", "a"));

    }

}
