package data;

public class UserInfo {
    private TableReader user_info;
    public UserInfo(){
        user_info = new TableReader();
    }

    public boolean Login(String username, String password){
        return user_info.UserMatch(username, password);
    }

    public boolean Register(String username, String password){
        return user_info.AddNewUser(username, password);
    }
}
