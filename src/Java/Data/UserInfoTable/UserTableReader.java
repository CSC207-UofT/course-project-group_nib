package Java.Data.UserInfoTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * access the database
 */
public class UserTableReader {
    Map<String ,String> user_info_map;

    /**
     * read the csv file and split the item by comma
     */
    public UserTableReader(){
        user_info_map = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Java/Data/UserInfoTable/UserInfoTable.csv")); // filename here
            reader.readLine(); //Ignore line 1
            String line;
            while((line=reader.readLine())!=null){
                String[] item = line.split(","); //split the items by comma

                user_info_map.put(item[0], item[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Polymorphism on Constructor for testing methods without affecting the UerInfoTable.csv

    /**
     * read the csv file with given filename and split the item by comma
     * @param filename the name of file as String type
     */
    public UserTableReader(String filename){
        user_info_map = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); // filename here
            reader.readLine(); //Ignore line 1
            String line;
            while((line=reader.readLine())!=null){
                String[] item = line.split(","); //split the items by comma

                user_info_map.put(item[0], item[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * compare the user's password and the password inputted
     * @param user user as String type
     * @param password password as String type
     * @return return a boolean value, true if password match, false if not match
     */
    public boolean UserMatch(String user, String password){
        if(user_info_map.containsKey(user)) {
            return user_info_map.get(user).equals(password);
        }else {
            return false;
        }
    }

    /**
     * add a new user
     * @param user user as String type
     * @param password password as String type
     * @return return a boolean value, true if user added, false if not added
     */
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

    //Overloading this method with a specified testing TableReader for testing.

    /**
     * Overloading this method with a specified testing TableReader for testing.
     */
    public boolean AddNewUser(String user, String password, UserTableReader tr){
        boolean duplicated = tr.user_info_map.containsKey(user);
        if (!duplicated) {
            tr.user_info_map.put(user, password);
            UpdateTable(user, password,"src/Java/Data/TestOnly.csv");
            return true;
        }else{
            return false;
        }
    }

    /**
     * update the database
     * @param user user as String type
     * @param password password as String type
     */
    public void UpdateTable(String user, String password){
        try {
            File csv = new File("src/Java/Data/UserInfoTable/UserInfoTable.csv");

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.newLine();
            bw.write(user + "," + password);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//Overloading UpdateTable method just for testing.
    /**
     * Overloading UpdateTable method just for testing.
     */
    public void UpdateTable(String user, String password, String filename){
        try {
            File csv = new File(filename);

            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.newLine();
            bw.write(user + "," + password);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The TestOnly.csv has been updated.");
    }

    /**
     * main method
     */
    public static void main(String[] args) {
        // Simple testing
        UserTableReader info = new UserTableReader();
//        System.out.println(info.UserMatch("Admin", "adminadmin"));
        info.AddNewUser("a", "12345678");
//        System.out.println(info.UserMatch("a", "12345678"));
        System.out.println(info.AddNewUser("a", "12345678"));
        System.out.println(info.UserMatch("b", "a"));

    }

}
