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
     * Change content for this note
     * @return return whether the note have been changed
     */
    @Override
    public boolean changeNote(){
        ArrayList<String> target = getNoteInfo();

        String username = getNoteInfo().get(0);
        String category = getNoteInfo().get(1);
        String title = getNoteInfo().get(2);
        String date = getNoteInfo().get(3);
        String content = getNoteInfo().get(4);
        String reference = getNoteInfo().get(5);

        String[] updated_info = {
                username,
                category,
                title,
                date,
                content,
                reference
        };
        return getApi().edit(updated_info, title);
    }

}
