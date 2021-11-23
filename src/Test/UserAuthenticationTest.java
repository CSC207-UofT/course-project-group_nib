package Test;

import Java.UseCase.UserInfo.UserAuthentication;
import Java.UseCase.UserInfo.UserInfoOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserAuthenticationTest {

    @Test
    void testUserAuthentication() {
        //The user already has an account stored in the UserInfoTable.csv, so he can login successfully.
        UserAuthentication u = new UserAuthentication("zhan7289", "123456");
        UserInfoOutput us = u.manipulate();
        assertEquals(us.returnUser(), u.getUsername());

        UserAuthentication c = new UserAuthentication("Admin", "adminadmin");
        UserInfoOutput d = c.manipulate();
        assertEquals(d.returnUser(), c.getUsername());

        //The user doesn't have an account stored in the UserInfoTable.csv, or typed in the wrong username and password,
        //so he fails to log in. The UserInfoOutput contains nothing since a failed authentication would not store any
        //information.
        UserAuthentication a = new UserAuthentication("hhhh", "hhhh");
        UserInfoOutput ab = a.manipulate();
        assertEquals(ab.returnUser(), "");
    }
}