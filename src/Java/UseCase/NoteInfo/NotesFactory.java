package Java.UseCase.NoteInfo;

import Java.Entity.Note.ComputerNotes;
import Java.Entity.Note.LiteratureNotes;
import Java.Entity.Note.Notes;
import Java.Entity.Note.ScienceNotes;

public class NotesFactory { //TODO: Consider if we still need this class.
    //TODO: Depends on whether to implement 3 types of notes
    public Notes getNote(Notes note) {
        if (note.getCategory() != null) {
            return note;
        }
        return null;
    }


//    public Notes getNote(String notesType) {
//        if (notesType.equalsIgnoreCase("Computer")) {
//            return new ComputerNotes();
//        } else if (notesType.equalsIgnoreCase("Literature")) {
//            return new LiteratureNotes();
//        } else if (notesType.equalsIgnoreCase("Science")) {
//            return new ScienceNotes();
//        }
//        return null;
//    }

}