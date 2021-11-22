package Controller;

import UseCase.UserInfo.UserInfoOutput;

import java.util.Objects;

public class UserInfoPresenter implements UserInfoOutput {
    private String user;
    private boolean success;

    public UserInfoPresenter(){
        success = false;
    }

    public void setState(boolean success){
        this.success = success;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean returnProgress() {
        return success;
    }

    @Override
    public String returnUser() {
        return Objects.requireNonNullElse(user, "");
    }
}
