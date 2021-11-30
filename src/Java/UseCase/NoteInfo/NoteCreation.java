package Java.UseCase.NoteInfo;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.ComputerNotes;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NotesFactory;

import java.util.Scanner;

public class NoteCreation extends NoteInfoManipulation {

    public NoteCreation(NoteInfoDataAccess api) {
        super();
    }

    @Override
    public boolean ChangeNote() {
        // TODO: Create a new note
//        api.Create(username, title, content);
        return false;
    }

    //    public Notes createNote(String category, String title, String date, String content, String references, boolean editable, boolean referable, boolean commentable) {
//
//        // Create objects based on the note type
//        Notes note = new NotesFactory().getNote(category);
//
//        note.setCategory(category);
//        note.setTitle(title);
//        note.setCreated_date(date);
//        note.setContent(new StringBuilder(content));
//        note.setReference(references);
//        note.setEditable(editable);
//        note.setReferable(referable);
//        note.setCommentable(commentable);
//
//        return note;
//    }
}
