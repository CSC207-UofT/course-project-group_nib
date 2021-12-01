package Java.UseCase.NoteInfo;

public abstract class NoteInfoManipulation {
    NoteInfoDataAccess api;
    public NoteInfoManipulation(NoteInfoDataAccess api) {
        this.api = api;
    }

    public NoteInfoManipulation() {

    }

    public boolean ChangeNote(){
        /*Check whether the action has been done successfully.*/
        return false;
    }
}
