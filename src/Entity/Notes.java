package Entity;

import java.util.ArrayList;

public abstract class Notes implements INotes {
    public double user_rate;
    public boolean editable;
    public boolean commentable;
    public boolean referable;
    public String changes;
    public String comment;
    public String reference;
    public ArrayList<String> note_list = new ArrayList<>();


//    public NoteManagement(){
//        super();
//    }

    public Notes(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment) {
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
    public void setUserRate(double user_rate) {
        this.user_rate = user_rate;

    }

    public double getUser_rate() {
        return user_rate;
    }

    public void setNote_list(ArrayList<String> note_list) {
        this.note_list = note_list;
    }

    public ArrayList<String> getNote_list() {
        return note_list;
    }

    public void setAll_note(String notes){
        note_list.add(notes);
    }


    public boolean canEdit(boolean editable) {
        this.editable = editable;
        return editable;
    }


    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getChanges(String changes) {
        return this.changes;

    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference(String reference) {

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

    public String getComment() {
        return comment;
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
