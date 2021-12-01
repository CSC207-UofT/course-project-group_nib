package Java.Entity.User;

public class User {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     */
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String name){
        this.username = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}


