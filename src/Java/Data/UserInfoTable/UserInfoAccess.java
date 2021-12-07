package Java.Data.UserInfoTable;

import Java.UseCase.UserInfo.DataAccessInterface;

/**
 * manage data passed from use case by using DataAccessInterface interface
 */
public class UserInfoAccess implements DataAccessInterface {
    private final UserTableReader user_info;

    /**
     * initialize user_info
     */
    public UserInfoAccess(){
        user_info = new UserTableReader();
    }

    /**
     * pass in username and password, then call UserMach() to mach if the password is correct
     * @param username name of user as Sting type
     * @param password password as String type
     * @return return a boolean value, true for correct password, false for incorrect password
     */
    public boolean login(String username, String password){
        return user_info.userMatch(username, password);
    }

    /**
     * pass in username and password, then call AddNewUser() to create new key and value
     * @param username name of user as Sting type
     * @param password password as String type
     * @return return a boolean value, true for successfully added, vice versa
     */
    public boolean register(String username, String password){
        return user_info.addNewUser(username, password);
    }
}
