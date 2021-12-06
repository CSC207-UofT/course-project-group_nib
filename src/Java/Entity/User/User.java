package Java.Entity.User;

public class User {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     * @param username: username of a Niubi user
     * @param password: password of a NIubi user
     */
    private String username;
    private String password;

    /**
     * initialize username and password
     * @param username the username of the account
     * @param password the passeord of the account
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * getter method, get the username
     * @return return username as String type
     */
    public String getUsername(){
        return username;
    }

    /**
     * setter method, set the username
     * @param name the username of the account
     */
    public void setUsername(String name){
        this.username = name;
    }

    /**
     * getter method, get the password
     * @return return passeord as String type
     */
    public String getPassword(){
        return password;
    }

    /**
     * setter method, set the password
     * @param password the password of the account
     */
    public void setPassword(String password){
        this.password = password;
    }
}


