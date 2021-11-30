package Java.Controller;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NoteCreation;
import Java.UseCase.NoteInfo.NoteInfoManipulation;
import Java.UserInterface.InterfaceEntity.NoteCreateForm;

import java.util.ArrayList;

public class NoteInfoController {
    private String username;
    private int operation;
    private ArrayList<String> note_info;
    private NoteInfoPresenter presenter;
    private NoteInfoAccess api;

    public NoteInfoController(String username, int operation, ArrayList<String> note_info, NoteInfoPresenter presenter) {
        this.username = username;
        this.operation = operation;
        this.note_info = note_info;
        this.presenter = presenter;
        api = new NoteInfoAccess();
        decode();
    }


    public void decode(){
        switch (operation){
            case 1: CreateNote();
                break;
            case 2: EditNote();
                break;
            case 3: DeleteNote();
                break;
        }
    }


    public boolean CreateNote() {
        //TODO: complete this method
        return false;
    }

    public boolean EditNote(){
        //TODO: complete this method
        return false;
    }

    public boolean DeleteNote(){
        //TODO: complete this method
        return false;
    }
}
