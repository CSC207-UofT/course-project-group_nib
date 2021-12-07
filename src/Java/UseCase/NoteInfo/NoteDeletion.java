package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteDeletion extends NoteInfoManipulation{
    /**
     * delete a note
     * @param api application programing interface
     * @param note_info an ArrayList of String contains information in each note
     * @param username username of the manipulator
     */

    public NoteDeletion(NoteInfoDataAccess api, ArrayList<String> note_info, String username){
        super(api, note_info, username);
    }

    /**
     * find the target note and delete it's title
     * @return return boolean value true after runs function ChangeNote
     */
    @Override
    public boolean DeleteNotes() {
        ArrayList<String> target = getNoteInfo();
        NoteInfoDataAccess api = getApi();
        return api.delete(target.get(2));
    }
}
