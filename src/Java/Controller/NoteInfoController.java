package Java.Controller;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.*;

import java.util.ArrayList;
/**
 * controlling note data from user input to use case
 */
public class NoteInfoController {
    private final String username;
    private final int operation;
    private final ArrayList<String> note_info;
    private final NoteInfoPresenter presenter;
    private final NoteInfoAccess api;
    private String new_content;

    /**
     * Initialize username, operation, note_info anf presenter
     * @param username username as String type
     * @param operation the operation that user chose
     * @param note_info information of note
     * @param presenter the present state
     */
    public NoteInfoController(String username, int operation, ArrayList<String> note_info,
                              NoteInfoPresenter presenter) {
        this.username = username;
        this.operation = operation;
        this.note_info = note_info;
        this.presenter = presenter;
        api = new NoteInfoAccess();
        this.new_content = null;
        decode();
    }

    /**
     * match operation to their related function
     */
    public void decode() {
        switch (operation) {
            case 1 : CreateNote(this.note_info, this.username);
            break;
            case 2 : EditNote(this.note_info, this.username);
            break;
            case 3 : DeleteNote(this.note_info, this.username);
            break;
            case 4 : SearchNote(this.note_info, this.username);
            break;
        }
    }

    /**
     * create an instance of NoteInfoManipulation to create a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void CreateNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation use_case = new NoteCreation(api, note_info, username);
        presenter.setState(use_case.CreateNotes());
    }


    public void setNew_content(String nc){
        new_content = nc;
    }


    /**
     * create an instance of NoteInfoManipulation to edit a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void EditNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation use_case = new NoteEdit(api, note_info, username);
        presenter.setState(use_case.EditNotes(new_content));
    }

    /**
     * create an instance of NoteInfoManipulation to edit a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void SearchNote(ArrayList<String>note_info, String username){
        ArrayList<Notes> transferred_notes = new ArrayList<>();
        NoteInfoManipulation use_case = new NoteSearch(api, note_info, username);
        ArrayList<String[]> all_notes =  use_case.SearchNotes(note_info.get(0));
        presenter.setState(all_notes.size() > 0);
        presenter.addInfo(all_notes);
//        for (String[] item : all_notes){
//            NoteTransformation transformation = new NoteTransformation(item);
//            transferred_notes.add(transformation.Transform());
//        }
//        presenter.setState(transferred_notes.size()>0);
//        presenter.addInfo(transferred_notes); //Here the whole arraylist<Notes> object is added to the presenter.
        //We need to transform each Notes object in transferred_notes to ArrayList<String>
    }

    /**
     * create an instance of NoteInfoManipulation to edit a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void DeleteNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation use_case = new NoteDeletion(api, note_info, username);
        presenter.setState(use_case.DeleteNotes());
    }
}
