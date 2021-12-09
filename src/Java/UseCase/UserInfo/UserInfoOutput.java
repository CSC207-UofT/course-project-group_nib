package Java.UseCase.UserInfo;

/**
 * interface implemented by UserInfoPresenter for passing states to controller layer
 */
public interface UserInfoOutput {
    void setState(boolean registered);
    void setUser(String user);

    String returnUser();
}
