package Test;

import Java.Data.TableReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TableReaderTest {

    @org.junit.jupiter.api.Test
    void testUserMatch() {
        TableReader info = new TableReader("src/Java/Data/TestOnly.csv");
        //When the username and password matches.
        assertTrue(info.UserMatch("admin", "admin123"));

        //When the username and password doesn't match.
        assertFalse(info.UserMatch("admin", "wrongPassword"));

        //When the username doesn't even exist in the csv file.
        assertFalse(info.UserMatch("NotExisting", "123456"));
    }

    @org.junit.jupiter.api.Test
    void testAddNewUser() { //Need to be fixed.
        TableReader info = new TableReader("src/Java/Data/TestOnly.csv");
        //When the username already exists in the csv file.
        assertFalse(info.AddNewUser("zhan666", "zhan999", info));

        //When the username is new, this method should add the new user to the csv file. But in order not to affect
        //our data, the tested information will be removed.
        assertTrue(info.AddNewUser("newUser", "newPassword123", info));
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
        TableReader info = new TableReader("src/Java/Data/TestOnly.csv");
        info.UpdateTable("zhan666", "zhan999", "src/Java/Data/TestOnly.csv");
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
