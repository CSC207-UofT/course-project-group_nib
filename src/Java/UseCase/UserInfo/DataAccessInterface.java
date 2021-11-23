package Java.UseCase.UserInfo;

public interface DataAccessInterface {
    boolean login(String username, String password);
    boolean register(String username, String password);
}
