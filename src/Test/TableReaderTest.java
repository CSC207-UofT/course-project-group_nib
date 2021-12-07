package Test;

import Java.Data.UserInfoTable.UserTableReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TableReaderTest {

    @org.junit.jupiter.api.Test
    void testUserMatch() {
        UserTableReader info = new UserTableReader("src/Java/Data/TestOnly.csv");
        //When the username and password matches.
        assertTrue(info.userMatch("admin", "admin123"));

        //When the username and password doesn't match.
        assertFalse(info.userMatch("admin", "wrongPassword"));

        //When the username doesn't even exist in the csv file.
        assertFalse(info.userMatch("NotExisting", "123456"));
    }

    @org.junit.jupiter.api.Test
    void testAddNewUser() { //TODO: This one shows NullPointerException after running the code.
        UserTableReader info = new UserTableReader("src/Java/Data/TestOnly.csv");
        //When the username already exists in the csv file.
        assertFalse(info.addNewUser("zhan666", "zhan999", info));

        //When the username is new, this method should add the new user to the csv file. But in order not to affect
        //our data, the tested information will be removed.
        assertTrue(info.addNewUser("newUser", "newPassword123", info));
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Java/Data/TestOnly.csv"));
            String line = "newUser, newPassword123";
            String l = reader.readLine();
            List<String[]> elements = new ArrayList<>();
            while(!Objects.equals(l, line)){
                elements.add(l.split(","));
                l = reader.readLine();
            }
            WriteAll(elements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @org.junit.jupiter.api.Test
    void testUpdateTable(){
        UserTableReader info = new UserTableReader("src/Java/Data/TestOnly.csv");
        info.updateTable("testUpdate", "testUpdate", "src/Java/Data/TestOnly.csv");
    }

    //A helper function below.
    static void WriteAll(List<String[]> elements) throws IOException {
        FileWriter sw = new FileWriter("src/Java/Data/TestOnly.csv");
        BufferedWriter writer = new BufferedWriter(sw);
        for (int a = 0; a < elements.size() - 1; a++){
            writer.append(elements.get(a)[0]);
            writer.append(",");
            writer.append(elements.get(a)[1]);
            writer.append("\n");
        }
        writer.append(elements.get(elements.size() - 1)[0]);
        writer.append(",");
        writer.append(elements.get(elements.size() - 1)[1]);
        writer.close();
    }
}
