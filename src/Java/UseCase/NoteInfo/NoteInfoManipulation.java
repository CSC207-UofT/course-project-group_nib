package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public abstract class NoteInfoManipulation {
    private final String author;
    private final ArrayList<String> note_info;
    private final NoteInfoDataAccess api;

    public NoteInfoManipulation(NoteInfoDataAccess api, ArrayList<String> note_info, String author) {
        this.author = author;
        this.note_info = note_info;
        this.api = api;
    }

    public boolean ChangeNote(){
        /*TODO: Check whether the action has been done successfully.*/
        return false;
    }

    public ArrayList<String> getNoteInfo(){
        return note_info;
    }

    public String getAuthor(){
        return author;
    }

    public NoteInfoDataAccess getApi(){
        return api;
    }

}
