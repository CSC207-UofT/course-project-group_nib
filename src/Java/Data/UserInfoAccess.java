package Java.Data;

import Java.Data.TableReader;
import Java.UseCase.UserInfo.DataAccessInterface;

public class UserInfoAccess implements DataAccessInterface {
    private final TableReader user_info;
    public UserInfoAccess(){
        user_info = new TableReader();
    }

    public boolean login(String username, String password){
        return user_info.UserMatch(username, password);
    }

    public boolean register(String username, String password){
        return user_info.AddNewUser(username, password);
    }
}
