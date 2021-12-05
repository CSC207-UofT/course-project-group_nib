package Test;

import Java.Controller.UserInfoPresenter;
import Java.Data.UserInfoTable.UserInfoAccess;
import Java.UseCase.UserInfo.DataAccessInterface;
import Java.UseCase.UserInfo.UserAuthentication;
import Java.UseCase.UserInfo.UserInfoOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserAuthenticationTest {

    @Test
    void testUserAuthentication() {
        UserInfoOutput test_presenter = new UserInfoPresenter();
        DataAccessInterface api = new UserInfoAccess();
        //The user already has an account stored in the UserInfoTable.csv, so he can login successfully.
        UserAuthentication u = new UserAuthentication(test_presenter, api, "zhan7289", "123456");
        test_presenter = u.manipulate();
        assertEquals(test_presenter.returnUser(), u.getUsername());

        test_presenter = new UserInfoPresenter();
        UserAuthentication c = new UserAuthentication(test_presenter, api, "Admin", "adminadmin");
        test_presenter = c.manipulate();
        assertEquals(test_presenter.returnUser(), c.getUsername());

        //The user doesn't have an account stored in the UserInfoTable.csv, or typed in the wrong username and password,
        //so he fails to log in. The UserInfoOutput contains nothing since a failed authentication would not store any
        //information.
        test_presenter = new UserInfoPresenter();
        UserAuthentication a = new UserAuthentication(test_presenter, api, "hhhh", "hhhh");
        test_presenter = a.manipulate();
        assertEquals(test_presenter.returnUser(), "");
    }
}