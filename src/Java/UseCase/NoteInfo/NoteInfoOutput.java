package Java.UseCase.NoteInfo;

import java.util.ArrayList;


/**
 * an interface which implemented by NoteInfoPresenter,to follow Dependency Inversion principle
 * and pass state and note information to presenter
 */
public interface NoteInfoOutput {
    /**
     * declare method getState() which returns true for success, false for fail
     * @return return current state as boolean type that true for success, false for fail
     */
    boolean getState();
    ArrayList<Object> getAllInfo();
}
