package Java.Controller;

import Java.UseCase.UserInfo.UserInfoOutput;

import java.util.Objects;

/**
 *  present the current state after operate user account
 */
public class UserInfoPresenter implements UserInfoOutput {
    private String user;
    private boolean success;

    /**
     * initialize success as false for default
     */
    public UserInfoPresenter(){
        success = false;
    }

    /**
     * set current state
     * @param success return current state as boolean type, true for success, false for fail
     */
    public void setState(boolean success){
        this.success = success;
    }

    /**
     * set the user
     * @param user the user as String type
     */
    @Override
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * current state for progress
     * @return return current progress as boolean type, true for success, false for fail
     */
    @Override
    public boolean returnProgress() {
        return success;
    }

    /**
     * return user
     * @return the user as String type
     */
    @Override
    public String returnUser() {
        return Objects.requireNonNullElse(user, "");
    }
}
