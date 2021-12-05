package Test;

import Java.UseCase.NoteInfo.NoteCreation;
import Java.UseCase.NoteInfo.NoteInfoDataAccess;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NotesCreationTest {
    private NoteInfoDataAccess api;



    @Test
    void testSuccessfulCreation() {
        ArrayList<String> note_info_1 = new ArrayList<>(){};
        note_info_1.add("User1");
        note_info_1.add("science");
        note_info_1.add("test");
        note_info_1.add("2021-11-15");
        note_info_1.add("Hello World");
        note_info_1.add("XXX");

        NoteCreation noteCreation = new NoteCreation(api, note_info_1, "TestUser");
        assertEquals(noteCreation.ChangeNote(), false);


    }

    @Test
    void testFailedCreation() {
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

