package Entity.User;
import Entity.Note.Notes;

import java.util.ArrayList;
import java.util.List;
import java.util.Dictionary;

public class User {
    /* The user who use the Niubi System. It should override the setPassword method from legacy.Register interface.
     */
    String username;
    String password;
    List<List<Notes>> user_notes;
    //Constants for index in user_notes list:
    //CREATE = 1
    //EDIT = 2
    //COMMENT = 3
    //RATE = 4

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.user_notes = new ArrayList<>();
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


