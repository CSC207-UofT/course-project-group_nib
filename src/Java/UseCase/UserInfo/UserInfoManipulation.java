package Java.UseCase.UserInfo;

import Java.Controller.UserInfoPresenter;

public abstract class UserInfoManipulation {
    private UserInfoOutput presenter;
    private final String username;
    private final String password;

    public UserInfoManipulation(String username, String password){
        this.username = username;
        this.password = password;
        presenter = new UserInfoPresenter();
    }

    public UserInfoOutput manipulate(){
        return presenter;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public UserInfoOutput getPresenter(){
        return presenter;
    }

}
