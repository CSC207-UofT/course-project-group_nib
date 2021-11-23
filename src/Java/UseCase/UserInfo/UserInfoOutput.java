package Java.UseCase.UserInfo;

import Entity.User.User;

public interface UserInfoOutput {
    public void setState(boolean registered);
    public void setUser(String user);
    public boolean returnProgress();
    public String returnUser();
}
