package Java.Controller;

import Java.UseCase.NoteInfo.NoteInfoOutput;

import java.util.ArrayList;

public class NoteInfoPresenter implements NoteInfoOutput {
    private ArrayList<Object> all_info;
    private boolean action_state;

    public NoteInfoPresenter(){
        all_info = new ArrayList<>();
        action_state = false;
    }

    public void setState(boolean state){
        this.action_state = state;
    }

    public void addInfo(Object any){
        all_info.add(any);
    }

    @Override
    public boolean getState() {
        return action_state;
    }

    @Override
    public ArrayList<Object> getAllInfo() {
        return all_info;
    }
}
