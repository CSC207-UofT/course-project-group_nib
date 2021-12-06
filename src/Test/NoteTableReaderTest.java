package Test;

import Java.Data.NoteInfoTable.NoteTableReader;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteTableReaderTest {

    @Test
    public void testUpdateTable() {
        ArrayList<String[]> note_info_list = helper.helper_provideNoteInfoList();

        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        assertTrue(ntr.updateNoteInfoList(note_info_list, "src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv"));
    }
}
