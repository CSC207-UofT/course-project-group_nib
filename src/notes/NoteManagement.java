package notes;

import com.sun.jdi.StringReference;
import legacy.User;

public abstract class NoteManagement implements Ratable, Codable, Commentable, Referable {
    private double user_rate;
    private boolean editable;
    private boolean commentable;
    private boolean referable;
    private String changes;
    private String comment;
    private String reference;

//    public NoteManagement(){
//        super();
//    }

    public NoteManagement(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment) {
        super();
        this.user_rate = user_rate;
        this.editable = editable;
        this.commentable = commentable;
        this.referable = referable;
        this.changes = changes;
        this.comment = comment;
        this.reference = "Original";
    }
    @Override
    public void getUserRate(double user_rate) {
        this.user_rate = user_rate;

    }


    public abstract boolean canEdit(boolean editable);


    public abstract String getChanges(String changes) ;

    public abstract String getLink(String reference) ;

    @Override
    public void canComment(boolean commentable) {
        this.commentable = commentable;
    }

    @Override
    public void addComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void canRefer(boolean referable) {
        this.referable = referable;
    }



}
