package Test;

import Java.Entity.Note.Notes;
import Java.UseCase.NoteCreation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NotesCreationTest {


    @Test
    void testSuccessfulCreation() {

        // If the input type is not science, computer, literature, a null pointer exception will occur
        NoteCreation noteCreation = new NoteCreation();
        Notes note = noteCreation.createNote(
                "science",
                "test",
                "2021-11-15",
                "hello world",
                "XXX",
                true,
                true,
                true);
        String expected_1 =  "Category: science\n" +
                "Title: test\n" +
                "Content: hello world\n" +
                "Rate: 0.0\n" +
                "Editable: true\n" +
                "Commentable: true\n" +
                "Referable: true\n" +
                "Changes: null\n" +
                "Comment: null\n" +
                "Reference: XXX\n" +
                "Created date: 2021-11-15\n" +
                "Updated date: null\n" +
                "Note list: []\n";
        String result_1 = note.toString();

        assertEquals(expected_1, result_1);

    }




    @Test
    void testFailedCreation() {

        // If the input type is not science, computer, literature, a null pointer exception will occur
        NoteCreation noteCreation = new NoteCreation();
        try {
            Notes note = noteCreation.createNote(
                    "errTest",
                    "test",
                    "2021-11-15",
                    "hello world",
                    "XXX",
                    true,
                    true,
                    true);
        } catch (NullPointerException e) {
            System.out.println(e.toString());
            System.out.println("Exception occur");

        }
//    @org.junit.jupiter.api.Test
//    void testCreateNote(){
//        NoteCreation noteCreation = new NoteCreation(){
//
//        }
//    }
    }


}

