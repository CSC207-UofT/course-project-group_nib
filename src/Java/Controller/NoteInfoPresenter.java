package Java.Controller;

import Java.UseCase.NoteInfo.NoteInfoOutput;

import java.util.ArrayList;

/**
 * present the current state after operate note.
 *
 * It is composed of a presenter state and a piece of information.
 *
 * state: the 'action_state' variable. Reflects whether the operation the controller input
 * is successful or not.
 *
 * information: the 'all_info' list. Reflects any extra information the system is going to provide.
 * sometimes it provides nothing then there is nothing in the list; sometimes the usecase returns some
 * notes then there is an array of notes in the list.
 *
 * it is initialized as Arraylist<Object> because we want it to be open to extension. Anything
 * in future implementation can be returned by this presenter.
 *
 */
public class NoteInfoPresenter implements NoteInfoOutput {
    private final ArrayList<Object> all_info;
    private boolean action_state;

    /**
     * initialize all_info and action_state
     */
    public NoteInfoPresenter(){
        all_info = new ArrayList<>();
        action_state = false;
    }

    /**
     * set current state
     * @param state return current state as boolean type, true for success, false for fail
     */
    public void setState(boolean state){
        this.action_state = state;
    }

    /**
     * add information
     * @param any information as object type
     */
    public void addInfo(Object any){
        all_info.add(any);
    }

    /**
     *
     * @return current state true for success, false for failure
     */
    @Override
    public boolean getState() {
        return action_state;
    }

    /**
     * return all the information
     * @return return ArrayList of Object which contains information
     */
    @Override
    public ArrayList<Object> getAllInfo() {
        return all_info;
    }
}