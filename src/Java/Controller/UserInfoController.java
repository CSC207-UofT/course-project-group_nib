package Java.Controller;

import Java.Data.UserInfoTable.UserInfoAccess;
import Java.UseCase.UserInfo.UserAuthentication;
import Java.UseCase.UserInfo.UserCreation;
import Java.UseCase.UserInfo.UserInfoManipulation;

/**
 * controlling user info from user input to use case
 */
public class UserInfoController{
    private final boolean is_login;
    private final String username;
    private final String password;
    private final UserInfoPresenter presenter;
    private final UserInfoAccess api;

    /**
     * initialize is_login, username and password
     * @param is_login login or not
     * @param username name of user as String type
     * @param password the password set by user as String type
     */
    public UserInfoController(boolean is_login, String username, String password) {
        this.username = username;
        this.password = password;
        this.is_login = is_login;
        presenter = new UserInfoPresenter();
        api = new UserInfoAccess();
    }

    /**
     * login or register
     * @return the result of calling two methods
     */
    public UserInfoPresenter decode(){
        if (is_login){
            return loginUser(this.username, this.password);
        }else {
            return registerUser(this.username, this.password);
        }
    }

    /**
     * create a new instance of UserInfoManipulation and return presenter for register user
     * @param username name of user as String type
     * @param password password set by user as String type
     * @return return UserInfoPresenter
     */
    public UserInfoPresenter registerUser(String username, String password) {
        UserInfoManipulation register = new UserCreation(presenter, api, username, password);
        register.manipulate();
        return presenter;
    }

    /**
     * create a new instance of UserInfoManipulation and return presenter for login user
     * @param username name of user as String type
     * @param password password set by user as String type
     * @return return UserInfoPresenter
     */
    public UserInfoPresenter loginUser(String username, String password) {
        UserInfoManipulation login = new UserAuthentication(presenter, api, username, password);
        login.manipulate();
        return presenter;

    }
}