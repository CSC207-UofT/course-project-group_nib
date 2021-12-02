package Java.UseCase.UserInfo;

import Java.Entity.User.User;

public class UserCreation extends UserInfoManipulation {
    public UserCreation(UserInfoOutput presenter, DataAccessInterface api, String username, String password) {
        super(presenter, api, username, password);
    }

    public UserInfoOutput manipulate(){
        String username = getUsername();
        String password = getPassword();
        DataAccessInterface api  = getApi();

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
