package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public class NoteCollection {
    private final NoteInfoDataAccess api;
    public NoteCollection(NoteInfoDataAccess api){
        this.api = api;
    }

    public ArrayList<String[]> CollectNotes(){
        return api.getAllNotes();
    }
}
