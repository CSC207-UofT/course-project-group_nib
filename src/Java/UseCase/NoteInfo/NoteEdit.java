package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteEdit extends NoteInfoManipulation{
    /**
     * @param api application programing interface
     * @param note_info an ArrayList of String contains information in each note
     * @param username username of the manipulator
     */
    public NoteEdit(NoteInfoDataAccess api, ArrayList<String> note_info, String username){
        super(api, note_info, username);
    }
    /**
     * override the method ChangeNote()
     * @return return false that the note have not been changed
     */
    @Override
    public boolean ChangeNote() {
        return false;
    }

    /**
     * Change content for this note
     * @param new_content the content of the note as Sting type
     * @return return true that the note have been changed
     */
    public boolean ChangeNote(String new_content){
        ArrayList<String> note_info = getNoteInfo();
        note_info.set(4, new_content); //Set the content of the note to the new one.
        NoteInfoDataAccess api = getApi();
        String[] note_i = note_info.toArray(new String[0]);
        api.edit(note_i, note_info.get(2));
        return true;
    }

}
