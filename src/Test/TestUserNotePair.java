package Test;

import Java.Entity.Note.LiteratureNotes;
import Java.Entity.Note.Notes;
import Entity.User.User;
import Java.UseCase.UserNotePair.UserNotePair;

import java.util.ArrayList;

public class TestUserNotePair {
    public static void main(String[] args) {
        User u = new User("Emily", "zhan7289");
        ArrayList<Notes> n = new ArrayList<>();
//        LiteratureNotes note = new LiteratureNotes(1, true, true, true, "Nice",
//                "Great");
//        n.add(note);
        UserNotePair b = new UserNotePair.Builder(u).getCreated(n).build();
        System.out.println(b);
    }
}

/*The UserNotePair is currently not used in our design, but in order for a backup, we haven't deleted it as a back up.*/
