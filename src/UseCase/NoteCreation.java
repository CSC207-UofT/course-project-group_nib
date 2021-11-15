package UseCase;

import Entity.Note.ComputerNotes;
import Entity.Note.Notes;

import java.util.Scanner;

public class NoteCreation {

    private Notes notes;

    public NoteCreation() {

    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public void category(String nextLine) {
        notes = new NotesFactory().getNote(nextLine);
        notes.setCategory(nextLine);
    }

    public void title(String nextLine) {
        notes.setTitle(nextLine);
    }

    public void date(String s) {
        notes.setCreated_date(s);
    }

    public void content(String nextLine) {
        notes.setContent(new StringBuilder(nextLine));
    }

    public void references(String nextLine) {
        notes.setReference(nextLine);
    }

    public void editable(boolean b) {
        notes.setEditable(b);
    }

    public void referable(boolean b) {
        notes.setReferable(b);
    }

    public void commentable(boolean b) {
        notes.setCommentable(b);
    }
}
