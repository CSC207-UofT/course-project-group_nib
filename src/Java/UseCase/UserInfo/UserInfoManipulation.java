package Java.UseCase.UserInfo;

public abstract class UserInfoManipulation {
    private final UserInfoOutput presenter;
    private final String username;
    private final String password;
    private final DataAccessInterface api;

    /**
     * initializing presenter, api, username and password
     * @param presenter contains the states and information for creating user
     * @param api application programing interface
     * @param username the name of user as String
     * @param password the password for user as String
     */
    public UserInfoManipulation(UserInfoOutput presenter, DataAccessInterface api, String username, String password){
        this.username = username;
        this.password = password;
        this.presenter = presenter;
        this.api = api;
    }

    /**
     * declare method manipulate() returns presenter
     * @return a presenter with UserInfoOutput type which contains the states and information for creating user
     */
    public UserInfoOutput manipulate(){
        return presenter;
    }

    /**
     * getter method get the username
     * @return name of user as String type
     */
    public String getUsername(){
        return username;
    }

    /**
     * getter method get the password
     * @return password as String type
     */
    public String getPassword(){
        return password;
    }

    /**
     * getter method get the presenter
     * @return a presenter with UserInfoOutput type which contains the states and information for creating user
     */
    public UserInfoOutput getPresenter(){
        return presenter;
    }

    /**
     * getter method get api
     * @return api as DataAccessInterface type
     */
    public DataAccessInterface getApi(){
        return api;
    }

}
