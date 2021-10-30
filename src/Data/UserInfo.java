package Data;

import Data.TableReader;

public class UserInfo {
    private final TableReader user_info;
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
