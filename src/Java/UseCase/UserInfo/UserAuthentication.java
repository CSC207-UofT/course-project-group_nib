package Java.UseCase.UserInfo;

import Java.Data.UserInfoAccess;
import Entity.User.User;

public class UserAuthentication extends UserInfoManipulation{
    public UserAuthentication(String username, String password) {
        super(username, password);
    }

    public UserInfoOutput manipulate(){
        String username = getUsername();
        String password = getPassword();
        DataAccessInterface api = new UserInfoAccess();

        boolean success = api.login(username, password);
        UserInfoOutput presenter = getPresenter();
        presenter.setState(success);

        if (success){
            User user = new User(username, password);
            presenter.setUser(user.getUsername());
        }
        return presenter;
    }
}
