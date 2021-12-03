package Java.Controller;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NoteCreation;
import Java.UseCase.NoteInfo.NoteDeletion;
import Java.UseCase.NoteInfo.NoteEdit;
import Java.UseCase.NoteInfo.NoteInfoManipulation;

import java.util.ArrayList;

public class NoteInfoController {
    private String username;
    private int operation;
    private ArrayList<String> note_info;
    private NoteInfoPresenter presenter;
    private NoteInfoAccess api;

    public NoteInfoController(String username, int operation, ArrayList<String> note_info,
                              NoteInfoPresenter presenter) {
        this.username = username;
        this.operation = operation;
        this.note_info = note_info;
        this.presenter = presenter;
        api = new NoteInfoAccess();
        decode();
    }


    public void decode() {
        switch (operation) {
            case 1:
                CreateNote(this.note_info, this.username);
                break;
            case 2:
                EditNote(this.note_info, this.username);
                break;
            case 3:
                DeleteNote(this.note_info, this.username);
                break;
        }
    }


    public boolean CreateNote(ArrayList<String>note_info, String username) {
        //TODO: complete this method
        NoteInfoManipulation usercase = new NoteCreation(api, note_info, username);
        return usercase.ChangeNote();
    }

    public boolean EditNote(ArrayList<String>note_info, String username) {
        //TODO: complete this method
        NoteInfoManipulation usercase = new NoteEdit(api, note_info, username);
        return usercase.ChangeNote();
    }

    public boolean DeleteNote(ArrayList<String>note_info, String username) {
        //TODO: complete this method
        NoteInfoManipulation usercase = new NoteDeletion(api, note_info, username);
        return usercase.ChangeNote();
    }
}
