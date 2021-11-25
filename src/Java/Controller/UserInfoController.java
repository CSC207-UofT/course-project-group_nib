package Java.Controller;

import Java.UseCase.UserInfo.UserAuthentication;
import Java.UseCase.UserInfo.UserCreation;
import Java.UseCase.UserInfo.UserInfoManipulation;

public class UserInfoController{
    private final boolean is_login;
    private final String username;
    private final String password;
    public UserInfoController(boolean is_login, String username, String password) {
        this.username = username;
        this.password = password;
        this.is_login = is_login;
    }

    public UserInfoPresenter decode(){
        if (is_login){
            return loginUser(this.username, this.password);
        }else {
            return registerUser(this.username, this.password);
        }
    }

    public UserInfoPresenter registerUser(String username, String password) {
        UserInfoManipulation register = new UserCreation(username, password);
        return (UserInfoPresenter) register.manipulate();
    }

    public UserInfoPresenter loginUser(String username, String password) {
        UserInfoManipulation login = new UserAuthentication(username, password);
        return (UserInfoPresenter) login.manipulate();

    }
}