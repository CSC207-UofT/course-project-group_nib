package Tests;

import UseCase.UserInfo.UserCreation;
import UseCase.UserInfo.UserInfoOutput;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserCreationTest {

    @Test
    void testSuccessfulCreation() {
        //The username and password are new and aren't stored in the UserInfoTable.csv yet. The tested information will
        //then be removed from csv so that it won't affect the file.
        UserCreation u = new UserCreation("newUser", "newPassword123");
        UserInfoOutput us = u.manipulate();
        assertEquals(us.returnUser(), u.getUsername());
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/data/UserInfoTable.csv"));
            String line = "newUser,newPassword123";
            int i = 0;
            String l = reader.readLine();
            List<String[]> elements = new ArrayList<String[]>();
            while(!Objects.equals(l, line)){
                i++;
                elements.add(l.split(","));
                l = reader.readLine();
            }
            TableReaderTest.WriteAll(elements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFailedCreation(){
        //The account already exists, so UserCreation with the existing username and password won't work.
        UserCreation u = new UserCreation("zhan7289", "123456");
        UserInfoOutput us = u.manipulate();
        assertEquals(us.returnUser(), "");
    }
}