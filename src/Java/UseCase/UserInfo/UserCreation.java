package Java.UseCase.UserInfo;

import Java.Entity.User.User;

/**
 * create user
 */
public class UserCreation extends UserInfoManipulation {
    /**
     * calling super constructor
     * @param presenter contains the states and information for creating user
     * @param api application programing interface
     * @param username the name of user as String
     * @param password the password for user as String
     */
    public UserCreation(UserInfoOutput presenter, DataAccessInterface api, String username, String password) {
        super(presenter, api, username, password);
    }

    /**
     * register and report present state
     * @return return presenter to report present state and username
     */
    public UserInfoOutput manipulate(){
        String username = getUsername();
        String password = getPassword();
        DataAccessInterface api  = getApi();

        boolean registered = api.register(username, password);
        UserInfoOutput presenter = getPresenter();
        presenter.setState(registered);

        if (registered){
            User user = new User(username);
            presenter.setUser(user.getUsername());
        }
        return presenter;
    }
}
