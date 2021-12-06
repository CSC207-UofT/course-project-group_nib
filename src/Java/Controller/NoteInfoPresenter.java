package Java.Controller;

import Java.UseCase.NoteInfo.NoteInfoOutput;

import java.util.ArrayList;

/**
 * present the current state after operate note
 */
public class NoteInfoPresenter implements NoteInfoOutput {
    private final ArrayList<ArrayList<String[]>> all_info;
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
    public void addInfo(ArrayList<String[]> any){all_info.add(any);
    }


    /**
     *
     * @return current state true for success, false for fail
     */
    @Override
    public boolean getState() {
        return action_state;
    }

    /**
     * return all information
     * @return return ArrayList of Object which contains information
     */
    @Override
    public ArrayList<ArrayList<String[]>> getAllInfo() {
        return all_info;
    }
}
