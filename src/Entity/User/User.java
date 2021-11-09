package Entity.User;

public class User {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     */
    String username;
    String password;
    Object user_notes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}


