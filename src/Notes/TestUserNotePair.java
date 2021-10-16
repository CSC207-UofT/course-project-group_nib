package Notes;

import Entity.CategoryA;
import Entity.Notes;
import users.User;

import java.util.ArrayList;

public class TestUserNotePair {
    public static void main(String[] args) {
        User u = new User("Emily", "zhan7289");
        ArrayList<Notes> n = new ArrayList<>();
        CategoryA note = new CategoryA(1, true, true, true, "Nice",
                "Great");
        n.add(note);
        UserNotePair b = new UserNotePair.Builder(u).getCreated(n).build();
        System.out.println(b);
    }
}
