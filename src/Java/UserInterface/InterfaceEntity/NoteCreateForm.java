package Java.UserInterface.InterfaceEntity;

public class NoteCreateForm {
    private String category;
    private String title;
    private String date;
    private String content;
    private String references;
    private boolean editable;
    private boolean referable;
    private boolean commentable;

    /**
     * empty constructor
     */
    public NoteCreateForm() {
    }

    /**
     * getter method, get the category
     * @return return category as String type
     */
    public String getCategory() {
        return category;
    }

    /**
     * setter method, set category
     * @param category category of note
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * getter method, get title
     * @return return the title of note
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter method, set the title of note
     * @param title the title of note
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter method, get the date of note
     * @return return the date of note as String type
     */
    public String getDate() {
        return date;
    }
    /**
     * setter method, set the date of note
     * @param date the date of note created
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getter method, get the content of the note
     * @return return the content of the note as Strong type
     */
    public String getContent() {
        return content;
    }

    /**
     * setter method, set content of the note
     * @param content the content of the note
     */
    public void setContent(String content) {
        this.content = content;
    }

//    public String getReferences() {
//        return references;
//    }
//
//    public void setReferences(String references) {
//        this.references = references;
//    }
//
//    public boolean isEditable() {
//        return editable;
//    }
//
//    public void setEditable(boolean editable) {
//        this.editable = editable;
//    }
//
//    public boolean isReferable() {
//        return referable;
//    }
//
//    public void setReferable(boolean referable) {
//        this.referable = referable;
//    }
//
//    public boolean isCommentable() {
//        return commentable;
//    }
//
//    public void setCommentable(boolean commentable) {
//        this.commentable = commentable;
//    }

    /**
     * toString method
     * @return String representation
     */
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
