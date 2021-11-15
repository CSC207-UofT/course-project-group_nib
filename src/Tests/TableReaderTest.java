package Tests;

import Data.TableReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TableReaderTest {

    @org.junit.jupiter.api.Test
    void testUserMatch() {
        TableReader info = new TableReader();
        //When the username and password matches.
        assertTrue(info.UserMatch("zhan7289", "123456"));

        //When the username and password doesn't match.
        assertFalse(info.UserMatch("zhan7289", "wrongPassword"));

        //When the username doesn't even exist in the csv file.
        assertFalse(info.UserMatch("NotExisting", "123456"));
    }

    @org.junit.jupiter.api.Test
    void addNewUser() {
        TableReader info = new TableReader();
        //When the username already exists in the csv file.
        assertFalse(info.AddNewUser("zhan7289", "123456"));

        //When the username is new, this method should add the new user to the csv file. But in order not to affect
        //our data, the tested information will be removed.
        assertTrue(info.AddNewUser("newUser", "newPassword123"));
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/data/UserInfoTable.csv"));
            String line = "newUser,newPassword123";
            String l = reader.readLine();
            List<String[]> elements = new ArrayList<String[]>();
            while(!Objects.equals(l, line)){
                elements.add(l.split(","));
                l = reader.readLine();
            }
            WriteAll(elements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //A helper function below.
    static void WriteAll(List<String[]> elements) throws IOException {
        FileWriter sw = new FileWriter("src/data/UserInfoTable.csv");
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