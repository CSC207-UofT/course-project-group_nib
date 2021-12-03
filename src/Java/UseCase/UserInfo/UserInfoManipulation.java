package Java.UseCase.UserInfo;

public abstract class UserInfoManipulation {
    private final UserInfoOutput presenter;
    private final String username;
    private final String password;
    private final DataAccessInterface api;

    public UserInfoManipulation(UserInfoOutput presenter, DataAccessInterface api, String username, String password){
        this.username = username;
        this.password = password;
        this.presenter = presenter;
        this.api = api;
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

    public DataAccessInterface getApi(){
        return api;
    }

}
