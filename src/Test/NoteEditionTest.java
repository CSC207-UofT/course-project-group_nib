package Test;
import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Data.NoteInfoTable.NoteTableReader;
import Java.UseCase.NoteInfo.NoteEdit;
import Java.UseCase.NoteInfo.NoteInfoDataAccess;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NoteEditionTest {
    @Test
    public void testNoteEdit(){
        ArrayList<String[]> note_info_list = helper.helper_provideNoteInfoList();
        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        ArrayList<String> note_1 = new ArrayList<>(){};
        note_1.add("TestUser");
        note_1.add("science");
        note_1.add("test");
        note_1.add("2021-12-05");
        note_1.add("Hello World");
        note_1.add("Original");
        NoteInfoDataAccess api = new NoteInfoAccess(ntr, note_info_list);
        NoteEdit edit = new NoteEdit(api, note_1, "TestUser");
        assertTrue(edit.EditNotes("New Content"));
        assertFalse(edit.EditNotes());
    }
}
