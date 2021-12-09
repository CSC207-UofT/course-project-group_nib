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
    }


    /**
     * match operation to their related function
     */
    public void decode() {
        switch (operation) {
            case 1 : createNote(this.note_info, this.username);
                break;
            case 2 : editNote(this.note_info, this.username);
                break;
            case 3 : deleteNote(this.note_info, this.username);
                break;
            case 4 : searchNote(this.note_info, this.username);
                break;
        }
    }


    /**
     * create an instance of NoteInfoManipulation to create a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void createNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation usecase = new NoteCreation(api, note_info, username);
        presenter.setState(usecase.changeNote());
    }

    /**
     * create an instance of NoteInfoManipulation to edit a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void editNote(ArrayList<String>note_info, String username) {
        NoteInfoManipulation usecase = new NoteEdit(api, note_info, username);
        presenter.setState(usecase.changeNote());
    }

    /**
     * create an instance of NoteInfoManipulation to edit a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void searchNote(ArrayList<String>note_info, String username){
        ArrayList<Notes> transferred_notes = new ArrayList<>();
        NoteInfoManipulation usecase = new NoteSearch(api, note_info, username);
        ArrayList<String[]> all_notes =  usecase.searchNotes(note_info.get(0));
        for (String[] item : all_notes){
            NoteTransformation transformation = new NoteTransformation(item);
            transferred_notes.add(transformation.transform());
        }
        presenter.setState(transferred_notes.size()>0);
        presenter.addInfo(transferred_notes);
    }

    /**
     * create an instance of NoteInfoManipulation to edit a note
     * @param note_info information of a note
     * @param username name of user
     */
    public void deleteNote(ArrayList<String>note_info, String username) {
        System.out.println("1");
        NoteInfoManipulation usecase = new NoteDeletion(api, note_info, username);
        presenter.setState(usecase.changeNote());
    }
}