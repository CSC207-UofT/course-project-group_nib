package Java.UseCase.NoteInfo;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.ComputerNotes;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NotesFactory;
import Java.UserInterface.MainPageInterface;

import java.util.Scanner;

public class NoteCreation extends NoteInfoManipulation {
    public Notes note;

    public NoteCreation(NoteInfoDataAccess api) {
        super(api);
    }

    @Override
    public boolean ChangeNote() {
        // TODO: Create a new note
        String title = note.getTitle();
        String author = note.getAuthor();
        String category = note.getCategory();
        String content = note.getContent();
        String[] comment = note.getComment();
        String[] reference = note.getReference();
        double rate = note.getUser_rate();
        api.create(title, author, category, content, comment, reference, rate);
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
