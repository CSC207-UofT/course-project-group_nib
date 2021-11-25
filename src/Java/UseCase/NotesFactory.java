package Java.UseCase;

import Entity.Note.ComputerNotes;
import Entity.Note.LiteratureNotes;
import Entity.Note.Notes;
import Entity.Note.ScienceNotes;

class NotesFactory {
    public Notes getNote(String notesType){
        if(notesType == null){
            return null;
        }
        if(notesType.equalsIgnoreCase("Computer")){
            return new ComputerNotes();
        } else if(notesType.equalsIgnoreCase("Literature")){
            return new LiteratureNotes();
        } else if(notesType.equalsIgnoreCase("Science")){
            return new ScienceNotes();
        }
        return null;
    }
}
