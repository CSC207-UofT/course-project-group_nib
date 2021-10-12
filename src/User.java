import java.util.HashMap;
import java.util.Map;

public class User implements Register {
    /* The user who use the Niubi System.
     */
    String password;
    Object user_notes;

    public User() {
        Map<Object, Object> user_notes = new HashMap<Object, Object>();
        this.password = null;
    }

    @Override
    public void setPassword(String p) {
        this.password = p;
    }
}


