package Java.UseCase.NoteInfo;

import Java.Entity.Note.Notes;

public class NoteTransformation {
    private final String[] note_info;
    private final Notes note;

    /**
     * initialize note_info and create an instance of Note class
     * @param note_information information of note as String[]
     */
    public NoteTransformation(String[] note_information){
        note_info = note_information;
        note = new Notes();
    }

    /**
     * set information to an instance of Notes
     * @return return a note
     */
    public Notes Transform(){
        note.setAuthor(note_info[0]);
        note.setCategory(note_info[1]);
        note.setTitle(note_info[2]);
        note.setDate(note_info[3]);
        note.setContent(note_info[4]);
        note.setReference(note_info[5]);
        return note;
    }
}
