package Java.UseCase.NoteInfo;

import Java.Entity.Note.Notes;

import java.util.ArrayList;
/**
 * create a note
 */
public class NoteCreation extends NoteInfoManipulation {

    /**
     * calling super constructor
     * @param api application programing interface
     * @param note_info an ArrayList of String contains information in each note
     * @param username username of the manipulator
     */
    public NoteCreation(NoteInfoDataAccess api, ArrayList<String> note_info, String username) {
        super(api, note_info, username);
    }

    /**
     * Create new note by using note_info ArrayList, return whether note have been successfully uploaded
     * @return return boolean value, true if changed successfully, false otherwise
     */
    @Override
    public boolean CreateNotes() {
        Notes note = new Notes();

        ArrayList<String> note_info = getNoteInfo();

        note.setAuthor(note_info.get(0));
        note.setCategory(note_info.get(1));
        note.setTitle(note_info.get(2));
        note.setDate(note_info.get(3));
        note.setContent(note_info.get(4));
        note.setReference(note_info.get(5));

        String title = note.getTitle();
        String author = note.getAuthor();
        String category = note.getCategory();
        String content = note.getContent();
        String reference = note.getReference();
        String date = note.getDate();

        String[] s = new String[6];
        s[0] = author;
        s[1] = category;
        s[2] = title;
        s[3] = date;
        s[4] = content;
        s[5] = reference;

        NoteInfoDataAccess api = getApi();
        return api.create(s); /*Return whether the new created note has been uploaded successfully.*/
    }
}