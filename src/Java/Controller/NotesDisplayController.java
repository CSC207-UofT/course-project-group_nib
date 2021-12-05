package Java.Controller;

import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NoteCollection;
import Java.UseCase.NoteInfo.NoteTransformation;

import java.util.ArrayList;

public class NotesDisplayController {
    private final NoteInfoPresenter presenter;
    private final NoteInfoAccess api;

    public NotesDisplayController(NoteInfoPresenter presenter) {
        this.presenter = presenter;
        api = new NoteInfoAccess();

    }

    public void getAllNotes(){
        ArrayList<Notes> transferred_notes = new ArrayList<>();
        NoteCollection collection = new NoteCollection(api);
        ArrayList<String[]> all_notes = collection.CollectNotes();
        for (String[] item : all_notes){
            NoteTransformation transformation = new NoteTransformation(item);
            transferred_notes.add(transformation.Transform());
        }

        presenter.setState(transferred_notes.size() > 0);
        presenter.addInfo(transferred_notes);

    }


}
