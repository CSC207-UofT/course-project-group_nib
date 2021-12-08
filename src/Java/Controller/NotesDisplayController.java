package Java.Controller;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NoteCollection;
import Java.UseCase.NoteInfo.NoteTransformation;

import java.util.ArrayList;

/**
 * fetch the all the notes in the database (current state of the system)
 */
public class NotesDisplayController {
    private final NoteInfoPresenter presenter;
    private final NoteInfoAccess api;
    /**
     * initialize controller
     * @param presenter contains the states and information
     */
    public NotesDisplayController(NoteInfoPresenter presenter) {
        this.presenter = presenter;
        api = new NoteInfoAccess();

    }

    /**
     * get all notes and set presenter
     */
    public void getAllNotes(){
        ArrayList<Notes> transferred_notes = new ArrayList<>();
        NoteCollection collection = new NoteCollection(api);
        ArrayList<String[]> all_notes = collection.collectNotes();
        for (String[] item : all_notes){
            NoteTransformation transformation = new NoteTransformation(item);
            transferred_notes.add(transformation.transform());
        }

        presenter.setState(transferred_notes.size() > 0);
        presenter.addInfo(transferred_notes);

    }


}