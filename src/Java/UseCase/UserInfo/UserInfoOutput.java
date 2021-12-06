package Java.UseCase.UserInfo;

import Java.Entity.User.User;

/**
 * interface implemented by UserInfoPresenter for passing states to controller layer
 */
public interface UserInfoOutput {
    void setState(boolean registered);
    void setUser(String user);
    boolean returnProgress();
    String returnUser();
}
