package Test;

import Java.Controller.UserInfoPresenter;
import Java.Data.UserInfoTable.UserInfoAccess;
import Java.UseCase.UserInfo.DataAccessInterface;
import Java.UseCase.UserInfo.UserCreation;
import Java.UseCase.UserInfo.UserInfoOutput;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserCreationTest {

    @Test
    void testSuccessfulCreation() {
        //The username and password are new and aren't stored in the UserInfoTable.csv yet. The tested information will
        //then be removed from csv so that it won't affect the file.
        DataAccessInterface api = new UserInfoAccess();
        UserInfoOutput test_presenter = new UserInfoPresenter();
        UserCreation u = new UserCreation(test_presenter, api, "newUser", "newPassword123");
        test_presenter = u.manipulate();
        assertEquals(test_presenter.returnUser(), u.getUsername());
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
        DataAccessInterface api = new UserInfoAccess();
        UserInfoOutput test_presenter = new UserInfoPresenter();
        UserCreation u = new UserCreation(test_presenter, api, "zhan7289", "123456");
        test_presenter = u.manipulate();
        assertEquals(test_presenter.returnUser(), "");
    }
}