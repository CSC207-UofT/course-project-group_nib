package Java.UseCase.UserInfo;

public interface DataAccessInterface {
    public boolean login(String username, String password);
    public boolean register(String username, String password);
}
