package Test;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Data.NoteInfoTable.NoteTableReader;
import Java.UseCase.NoteInfo.NoteCreation;
import Java.UseCase.NoteInfo.NoteInfoDataAccess;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class NotesCreationTest {
    @Test
    void testSuccessfulCreation() {
        ArrayList<String[]> note_info_list = helper.helper_provideNoteInfoList();

        ArrayList<String> note_info_1 = new ArrayList<>(){};
        note_info_1.add("TestUser");
        note_info_1.add("new");
        note_info_1.add("test");
        note_info_1.add("2021-11-15");
        note_info_1.add("Hello World");
        note_info_1.add("XXX");
        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        NoteInfoDataAccess api = new NoteInfoAccess(ntr, note_info_list);
        NoteCreation noteCreation = new NoteCreation(api, note_info_1, "TestUser");
        assertFalse(noteCreation.changeNote());
    }



    @Test
    void testFailedCreation() {
        ArrayList<String[]> note_info_list = helper.helper_provideNoteInfoList();
        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        NoteInfoDataAccess api = new NoteInfoAccess(ntr, note_info_list);
        try {
            ArrayList<String> note_info_2 = new ArrayList<>() {
            };
            note_info_2.add("User1");
            note_info_2.add("InvalidInput");
            note_info_2.add("test");
            note_info_2.add("2021-11-15");
            note_info_2.add("Hello World");
            note_info_2.add("XXX");
            NoteCreation noteCreation = new NoteCreation(api, note_info_2, "TestUser");
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }


}

