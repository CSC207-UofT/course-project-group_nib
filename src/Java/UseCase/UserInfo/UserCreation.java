package Java.UseCase.UserInfo;

import Java.Data.UserInfoAccess;
import Entity.User.User;

public class UserCreation extends UserInfoManipulation {
    public UserCreation(String username, String password) {
        super(username, password);
    }

    public UserInfoOutput manipulate(){
        String username = getUsername();
        String password = getPassword();
        DataAccessInterface api = new UserInfoAccess();

        boolean registered = api.register(username, password);
        UserInfoOutput presenter = getPresenter();
        presenter.setState(registered);

        if (registered){
            User user = new User(username, password);
            presenter.setUser(user.getUsername());
        }
        return presenter;
    }
}
