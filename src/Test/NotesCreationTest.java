package Tests;

import Entity.Note.Notes;
import UseCase.NoteCreation;
import org.junit.jupiter.api.Test;


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
        System.out.println(note);
    }

    @Test
    void testFailedCreation(){

        // If the input type is not science, computer, literature, a null pointer exception will occur
        NoteCreation noteCreation = new NoteCreation();
        Notes note = noteCreation.createNote(
                "errTest",
                "test",
                "2021-11-15",
                "hello world",
                "XXX",
                true,
                true,
                true);
        System.out.println(note);

    }
}
