package Entity;

import notes.Note;

public class CategoryB extends Note {
    /* Thought, Belief, and Behaviour*/
    private double user_rate;
    private boolean editable;
    private boolean commentable;
    private boolean referable;
    private String changes;
    private String comment;

    public CategoryB(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment){
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
