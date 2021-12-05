package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteSearch extends NoteInfoManipulation{
    public NoteSearch(NoteInfoDataAccess api, ArrayList<String> note_info, String author) {
        super(api, note_info, author);
    }

    public ArrayList<String[]> SearchNotes(String keyword){
        return getApi().search(keyword, getAuthor());
    }
}
