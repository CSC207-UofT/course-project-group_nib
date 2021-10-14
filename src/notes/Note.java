package notes;

import legacy.User;

public abstract class Note extends User implements Ratable, Editable, Codable{
    private double user_rate;
    private boolean editable;
    private String changes;

    public Note(double user_rate, boolean editable, String changes) {
        super();
        this.user_rate = user_rate;
        this.editable = editable;
        this.changes = changes;
    }
    @Override
    public void getUserRate(double user_rate) {
        this.user_rate = user_rate;

    }

    @Override
    public void canEdit(boolean editable) {
        this.editable = editable;
    }

    @Override
    public void getChanges(String changes) {
        this.changes = changes;

    }

}
