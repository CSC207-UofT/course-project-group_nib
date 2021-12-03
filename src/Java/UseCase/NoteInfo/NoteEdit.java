package Java.UseCase.NoteInfo;

import Java.Entity.Note.Notes;

import java.util.ArrayList;

public class NoteEdit extends NoteInfoManipulation{
    public NoteEdit(NoteInfoDataAccess api, ArrayList<String> note_info, String username){

        super(api, note_info, username);
    }

    @Override
    public boolean ChangeNote() {
        return false;
    }

    public boolean ChangeNote(String content) {
        /*Check*/
        // TODO: Edit the note
        ArrayList<String> note_info = getNoteInfo();
        note_info.set(4, content);

        NoteInfoDataAccess api = getApi();
        String[] note_i = note_info.toArray(new String[0]);
        api.edit(note_i, note_info.get(2));
        return true;
    }

}
