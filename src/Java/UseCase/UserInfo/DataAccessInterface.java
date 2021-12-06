package Java.UseCase.UserInfo;

/**
 * interface implemented by UserInfoAccess for updating csv
 */
public interface DataAccessInterface {
    boolean login(String username, String password);
    boolean register(String username, String password);
}
