package Java.UseCase.UserInfo;

import Java.Entity.User.User;

public class UserAuthentication extends UserInfoManipulation{
    public UserAuthentication(UserInfoOutput presenter, DataAccessInterface api, String username, String password) {
        super(presenter, api, username, password);
    }

    public UserInfoOutput manipulate(){
        String username = getUsername();
        String password = getPassword();
        DataAccessInterface api  = getApi();

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
