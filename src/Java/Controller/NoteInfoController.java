package Java.Controller;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.*;

import java.util.ArrayList;

public class NoteInfoController {
    private final String username;
    private final int operation;
    private final ArrayList<String> note_info;
    private final NoteInfoPresenter presenter;
    private final NoteInfoAccess api;

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
            case 4:
                SearchNote(this.note_info, this.username);
                break;
        }
    }


    public void CreateNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation usecase = new NoteCreation(api, note_info, username);
        presenter.setState(usecase.ChangeNote());
    }

    public void EditNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation usecase = new NoteEdit(api, note_info, username);
        presenter.setState(usecase.ChangeNote());
    }

    public void SearchNote(ArrayList<String>note_info, String username){
        ArrayList<Notes> transferred_notes = new ArrayList<>();
        NoteInfoManipulation usecase = new NoteSearch(api, note_info, username);
        ArrayList<String[]> all_notes =  usecase.SearchNotes(note_info.get(0));
        for (String[] item : all_notes){
            NoteTransformation transformation = new NoteTransformation(item);
            transferred_notes.add(transformation.Transform());
        }
        presenter.setState(transferred_notes.size()>0);
        presenter.addInfo(transferred_notes);
    }


    public void DeleteNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation usecase = new NoteDeletion(api, note_info, username);
        presenter.setState(usecase.ChangeNote());
    }
}
