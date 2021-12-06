package Test;

import java.util.ArrayList;

public class helper {

    public helper(){
    }
    public static ArrayList<String[]> helper_provideNoteInfoList() {
        ArrayList<String[]> note_info_list = new ArrayList<>();
        String[] note_1 = new String[6];
        String[] note_2 = new String[6];
        note_1[0] = "admin";
        note_1[1] = "Bio";
        note_1[2] = "test Bio Title";
        note_1[3] = "2021-12-05";
        note_1[4] = "Test content Bio111!";
        note_1[5] = "https://googlescholar.com";

        note_2[0] = "admin";
        note_2[1] = "Computer Science";
        note_2[2] = "test note Computer Science";
        note_2[3] = "2021-12-05";
        note_2[4] = "Test content Computer Science!";
        note_2[5] = "https://wikipedia.com";
        note_info_list.add(note_1);
        note_info_list.add(note_2);

        String[] note = new String[6];
        note[0] = "TestUser";
        note[1] = "Science";
        note[2] = "test";
        note[3] = "2021-12-05";
        note[4] = "Hello World";
        note[5] = "Original";
        note_info_list.add(note);

        return note_info_list;
    }
}
