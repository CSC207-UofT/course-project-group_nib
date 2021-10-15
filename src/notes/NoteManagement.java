package notes;

public abstract class NoteManagement implements INotes {
    public double user_rate;
    public boolean editable;
    public boolean commentable;
    public boolean referable;
    public String changes;
    public String comment;
    public String reference;

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

    @Override
    public String toString() {
        return "NoteManagement{" +
                "user_rate=" + user_rate +
                ", editable=" + editable +
                ", commentable=" + commentable +
                ", referable=" + referable +
                ", changes='" + changes + '\'' +
                ", comment='" + comment + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
