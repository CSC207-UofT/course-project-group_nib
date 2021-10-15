package Entity;

import notes.NoteManagement;

public class CategoryB extends NoteManagement {
    /* Thought, Belief, and Behaviour*/
    private double user_rate;
    private boolean editable;
    private boolean commentable;
    private boolean referable;
    private String changes;
    private String comment;
    private String reference;

    public CategoryB(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment){
        super( user_rate,  editable,  commentable,  referable,  changes,  comment);
    }



    @Override
    public void getUserRate(double user_rate) {
        this.user_rate = user_rate;

    }

    public boolean canEdit(boolean editable) {
        this.editable = editable;
        return editable;
    }


    public String getChanges(String changes) {
        this.changes = changes;
        return this.changes;

    }

    public String getLink(String reference) {
        this.reference = reference;
        return reference;
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
