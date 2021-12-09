package Java.UseCase.UserInfo;

import Java.Entity.User.User;

/**
 * verify user
 */
public class UserAuthentication extends UserInfoManipulation{
    /**
     * using super constructor
     * @param presenter contains the states and information for creating user
     * @param api application programing interface
     * @param username the name of user as String
     * @param password the password for user as String
     */
    public UserAuthentication(UserInfoOutput presenter, DataAccessInterface api, String username, String password) {
        super(presenter, api, username, password);
    }

    /**
     * create an instance of UserInfoOutput and set state and user if username and password matches
     * @return return an instance of UserInfoOutput with state and users set
     */
    public UserInfoOutput manipulate(){
        String username = getUsername();
        String password = getPassword();
        DataAccessInterface api  = getApi();

        boolean success = api.login(username, password);
        UserInfoOutput presenter = getPresenter();
        presenter.setState(success);

        if (success){
            User user = new User(username);
            presenter.setUser(user.getUsername());
        }
        return presenter;
    }
}
