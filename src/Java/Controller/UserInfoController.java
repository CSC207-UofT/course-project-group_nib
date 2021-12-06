package Java.Controller;

import Java.Data.UserInfoTable.UserInfoAccess;
import Java.UseCase.UserInfo.UserAuthentication;
import Java.UseCase.UserInfo.UserCreation;
import Java.UseCase.UserInfo.UserInfoManipulation;

public class UserInfoController{
    private final boolean is_login;
    private final String username;
    private final String password;
    private final UserInfoPresenter presenter;
    private final UserInfoAccess api;

    public UserInfoController(boolean is_login, String username, String password) {
        this.username = username;
        this.password = password;
        this.is_login = is_login;
        presenter = new UserInfoPresenter();
        api = new UserInfoAccess();
    }

    public UserInfoPresenter decode(){
        if (is_login){
            return loginUser(this.username, this.password);
        }else {
            return registerUser(this.username, this.password);
        }
    }

    public UserInfoPresenter registerUser(String username, String password) {
        UserInfoManipulation register = new UserCreation(presenter, api, username, password);
        register.manipulate();
        return presenter;
    }

    public UserInfoPresenter loginUser(String username, String password) {
        UserInfoManipulation login = new UserAuthentication(presenter, api, username, password);
        login.manipulate();
        return presenter;

    }
}