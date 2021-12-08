package Test;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Data.NoteInfoTable.NoteTableReader;
import Java.UseCase.NoteInfo.NoteDeletion;
import Java.UseCase.NoteInfo.NoteInfoDataAccess;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class NoteDeletionTest {

    @Test
    public void testNoteDeletion(){
        ArrayList<String[]> note_info = helper.helper_provideNoteInfoList();
        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        ArrayList<String> note = new ArrayList<>(){};
        note.add("TestUser");
        note.add("science");
        note.add("test");
        note.add("2021-12-05");
        note.add("Hello World");
        note.add("Original");
        NoteInfoDataAccess api = new NoteInfoAccess(ntr, note_info);
        NoteDeletion delete = new NoteDeletion(api, note, "TestUser");
        assertTrue(delete.changeNote());
    }
}
