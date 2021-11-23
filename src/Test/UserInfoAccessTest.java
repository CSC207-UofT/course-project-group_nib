package Test;

import Java.Data.UserInfoAccess;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoAccessTest {

    @Test
    void testLogin() {
        UserInfoAccess u = new UserInfoAccess();
        assertTrue(u.login("zhan7289", "123456"));//Successful login
        assertFalse(u.login("zhan7289", "wrongPassword"));//Wrong password
        assertFalse(u.login("notexist", "456456"));//User does not exist.
    }

    @Test
    void testRegister() {
        UserInfoAccess u = new UserInfoAccess();
        assertFalse(u.register("zhan7289", "123456"));//The user already exists, can't register twice.
        assertTrue(u.register("newUser", "newPassword123"));//A new user is registered successfully.
        //In order not to affect the original data, the tested information will be removed.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/data/UserInfoTable.csv"));
            String line = "newUser,newPassword123";
            String l = reader.readLine();
            List<String[]> elements = new ArrayList<String[]>();
            while(!Objects.equals(l, line)){
                elements.add(l.split(","));
                l = reader.readLine();
            }
            TableReaderTest.WriteAll(elements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}