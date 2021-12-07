package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteCollection {
    private final NoteInfoDataAccess api;
    public NoteCollection(NoteInfoDataAccess api){
        this.api = api;
    }

    /**
     * get all notes by a form of ArrayList<String[]>
     * @return return a collection of notes
     */
    public ArrayList<String[]> collectNotes(){
        return api.getAllNotes();
    }
}
