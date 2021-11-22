package UserInterface.InterfaceEntity;

public class NoteCreateForm {
    private String category;
    private String title;
    private String date;
    private String content;
    private String references;
    private boolean editable;
    private boolean referable;
    private boolean commentable;

    public NoteCreateForm() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isReferable() {
        return referable;
    }

    public void setReferable(boolean referable) {
        this.referable = referable;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    @Override
    public String toString() {
        return "NoteCreateForm{" +
                "category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", references='" + references + '\'' +
                ", editable=" + editable +
                ", referable=" + referable +
                ", commentable=" + commentable +
                '}';
    }
}
