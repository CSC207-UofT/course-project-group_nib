package Java.UseCase;

import Java.Entity.Note.ComputerNotes;
import Java.Entity.Note.LiteratureNotes;
import Java.Entity.Note.Notes;
import Java.Entity.Note.ScienceNotes;

class NotesFactory {
    public Notes getNote(String notesType) {
        if (notesType.equalsIgnoreCase("Computer")) {
            return new ComputerNotes();
        } else if (notesType.equalsIgnoreCase("Literature")) {
            return new LiteratureNotes();
        } else if (notesType.equalsIgnoreCase("Science")) {
            return new ScienceNotes();
        }
//        return new Notes();
        return null;
    }

}
