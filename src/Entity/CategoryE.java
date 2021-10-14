package Entity;

import notes.Note;

public class CategoryE extends Note {
    /* The Physical and Mathematical Universes  */
    private double user_rate;
    private boolean editable;
    private boolean commentable;
    private boolean referable;
    private String changes;
    private String comment;
    private String reference;
    //    public CategoryA(){
//        super();
//    }
    public CategoryE(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment){
        super( user_rate,  editable,  commentable,  referable,  changes,  comment);
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
