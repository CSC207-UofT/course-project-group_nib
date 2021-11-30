package Java.Entity.Note;

import java.util.ArrayList;
import java.util.Date;

public class Notes {
    private String category;
    private String title;
    private StringBuilder content;
    private double user_rate;
    private boolean editable;
    private boolean commentable;
    private boolean referable;
    private String changes;
    private String comment;
    private String reference;
    private String created_date;
    private String updated_date;
    private ArrayList<String> note_list = new ArrayList<>();


    public Notes(String category, String title, StringBuilder content, double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String reference, String created_date, String updated_date, ArrayList<String> note_list) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.user_rate = user_rate;
        this.editable = editable;
        this.commentable = commentable;
        this.referable = referable;
        this.changes = changes;
        this.comment = comment;
        this.reference = reference;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.note_list = note_list;
    }

    public Notes() {

    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StringBuilder getContent() {
        return content;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public double getUser_rate() {
        return user_rate;
    }

    public void setUser_rate(double user_rate) {
        this.user_rate = user_rate;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public boolean isReferable() {
        return referable;
    }

    public void setReferable(boolean referable) {
        this.referable = referable;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public ArrayList<String> getNote_list() {
        return note_list;
    }

    public void setNote_list(ArrayList<String> note_list) {
        this.note_list = note_list;
    }

    @Override
    public String toString() {
        return "Category: " + category + '\n' +
                "Title: " + title + '\n' +
                "Content: " + content + '\n' +
                "Rate: " + user_rate + '\n' +
                "Editable: " + editable + '\n' +
                "Commentable: " + commentable + '\n'+
                "Referable: " + referable + '\n' +
                "Changes: " + changes + '\n' +
                "Comment: " + comment + '\n' +
                "Reference: " + reference + '\n' +
                "Created date: " + created_date + '\n' +
                "Updated date: " + updated_date + '\n' +
                "Note list: " + note_list + '\n';
    }
}
