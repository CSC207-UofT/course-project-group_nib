package Test;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Data.NoteInfoTable.NoteTableReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NoteInfoAccessTest {

    @Test
    public void test_create(){
        ArrayList<String[]> note_info_list = new ArrayList<>();
        String[] note_1 = new String[6];
        String[] note_2 = new String[6];
        note_1[0] = "admin";
        note_1[1] = "ScienceNotes";
        note_1[2] = "test note 1";
        note_1[3] = "2021-12-04";
        note_1[4] = "Test content 111!";
        note_1[5] = "https://googlescholar.com";
        note_info_list.add(note_1);

        note_2[0] = "admin";
        note_2[1] = "ComputerNotes";
        note_2[2] = "test note 2";
        note_2[3] = "2021-12-04";
        note_2[4] = "Test content 222!";
        note_2[5] = "https://wikipedia.com";
        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        NoteInfoAccess nia = new NoteInfoAccess(ntr, note_info_list);
        assertTrue(nia.create(note_info_list, note_2, ntr)); //Success note creation
        ArrayList<String[]> list = helper.helper_provideNoteInfoList();
        for (String[] item : list){
        assertTrue(nia.create(note_info_list, item, ntr));}
        assertFalse(nia.create(note_info_list, note_1, ntr)); //Failed note creation

    }

    @Test
    public void test_edit(){
        //TODO: Implement
    }

    @Test
    public void test_delete(){
        //TODO: Implement
    }

    @Test
    public void test_search(){
        //TODO: Implement
    }
}
