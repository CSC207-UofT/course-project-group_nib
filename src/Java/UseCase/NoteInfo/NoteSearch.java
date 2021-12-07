package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteSearch extends NoteInfoManipulation{
    /**
     * calling super constructor
     * @param api application programing interface
     * @param note_info an ArrayList of String contains information in each note
     * @param author author of the note
     */
    public NoteSearch(NoteInfoDataAccess api, ArrayList<String> note_info, String author) {
        super(api, note_info, author);
    }

    /**
     * search a note by using one keyword and author
     * @param keyword a word for searching
     * @return return a collection of notes
     */
    public ArrayList<String[]> searchNotes(String keyword){
        return getApi().search(keyword, getAuthor());
    }
}
