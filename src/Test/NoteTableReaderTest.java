package Test;

import Java.Data.NoteInfoTable.NoteTableReader;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteTableReaderTest {

    @Test
    public void testUpdateTable() {
        ArrayList<String[]> note_info_list = new ArrayList<>();
        String[] note_1 = new String[6];
        String[] note_2 = new String[6];
        note_1[0] = "admin";
        note_1[1] = "ScienceNotes";
        note_1[2] = "test note 1";
        note_1[3] = "2021-12-04";
        note_1[4] = "Test content 111!";
        note_1[5] = "https://googlescholar.com";

        note_2[0] = "admin";
        note_2[1] = "ComputerNotes";
        note_2[2] = "test note 2";
        note_2[3] = "2021-12-04";
        note_2[4] = "Test content 222!";
        note_2[5] = "https://wikipedia.com";
        note_info_list.add(note_1);
        note_info_list.add(note_2);

        NoteTableReader ntr = new NoteTableReader("src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
        assertTrue(ntr.updateNoteInfoList(note_info_list, "src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv"));

    }
}
