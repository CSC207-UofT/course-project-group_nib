package Java.UseCase.UserInfo;

import Entity.User.User;

public interface UserInfoOutput {
    void setState(boolean registered);
    void setUser(String user);
    boolean returnProgress();
    String returnUser();
}
