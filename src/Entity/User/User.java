package Entity.User;
import Entity.Note.Notes;
import java.util.List;
import java.util.Dictionary;

public class User {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     */
    String username;
    String password;
    Dictionary<String, List<Notes>> user_notes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
//        this.user_notes.put("Created Notes", null);
//        this.user_notes.put("Edited Notes", null);
//        this.user_notes.put("Commented Notes", null);
//        this.user_notes.put("Rated Notes", null);
    }

        public String getUsername () {
            return username;
        }

        public String getPassword () {
            return password;
        }

        public Object getUser_notes () {
            return user_notes;
        }
    }


