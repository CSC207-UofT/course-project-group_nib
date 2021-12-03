package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteDeletion extends NoteInfoManipulation{

    public NoteDeletion(NoteInfoDataAccess api, ArrayList<String> note_info, String username){
        super(api, note_info, username);
    }

    @Override
    public boolean ChangeNote() {
        // TODO: Delete the note
        return false;
    }
}
