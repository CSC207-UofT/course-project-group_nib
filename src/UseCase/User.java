package UseCase;

import java.util.HashMap;
import java.util.Map;

public class User implements Register {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     */
    String username;
    String password;
    Object user_notes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void setPassword(String p) {
        this.password = p;
    }
}


