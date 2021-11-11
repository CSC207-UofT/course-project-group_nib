package Tests;

import Entity.Note.LiteratureNotes;
import Entity.Note.Notes;
import Entity.User.User;
import UseCase.UserNotePair.UserNotePair;

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
