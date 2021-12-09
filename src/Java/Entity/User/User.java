package Java.Entity.User;

public class User {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     * @param username: username of a Niubi user
     * @param password: password of a NIubi user
     */
    private final String username;

    /**
     * initialize username and password
     * @param username the username of the account
     */
    public User(String username) {
        this.username = username;
    }

    /**
     * getter method, get the username
     * @return return username as String type
     */
    public String getUsername(){
        return username;
    }

}


