package Java.Entity.Note;

import java.util.Arrays;

public class Notes {
    /*@param category: Category of the note
     * @param author: Author of the note, usually the username who logged in first and created it.
     * @param title: Title of the note
     * @param content: Content of the note
     * @param comment: comment of the rate
     * @param reference: reference of the rate
     * */
    private String category;
    private String author;
    private String title;
    private String content;
    private String date;
    private String[] comment;
    private String reference;



    /**
     * initialize category, author, content, comment, reference and date
     * @param category category of the note
     * @param author author of the note
     * @param title title of the note
     * @param content content of the note
     * @param date date of the note created
     */
    public Notes(String category, String author, String title, String content, String date) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.content = content;
        this.comment = null;
        this.reference = null;
        this.date = date;
    }

    /**
     * empty constructor
     */
    public Notes() {

    }

    /**
     * getter method, get date
     * @return return created date as String type
     */
    public String getDate() {return date;}

    /**
     * set method, set date
     * @param date date of the note created
     */
    public void setDate(String date) {this.date = date;}

    /**
     * getter method, get category
     * @return return the category of this note as String type
     */
    public String getCategory() {
        return category;
    }

    /**
     * setter method, set category
     * @param category the category of the note
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * getter method, get title
     * @return return the title of the note as String type
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter method, set title
     * @param title the title of the note
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getter method, get the name of author
     * @return return the author's name as String type
     */
    public String getAuthor() {return author;}

    /**
     * setter method, set the name of author
     * @param author the name of note's author
     */
    public void setAuthor(String author){this.author = author;}

    /**
     * getter method, get the content
     * @return return the note's content as String type
     */
    public String getContent() {
        return content;
    }

    /**
     * setter method, set the content
     * @param content the content of the note
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * getter method, get comment of the note
     * @return return a list of string if comments
     */
    public String[] getComment() {
        return comment;
    }

    /**
     * setter method, set comment of the note
     * @param comment a list of comment
     */
    public void setComment(String[] comment) {
        this.comment = comment;
    }

    /**
     * getter method, get the reference
     * @return return reference of the note as String type
     */
    public String getReference() {
        return reference;
    }

    /**
     * setter method, set the reference of the note
     * @param reference the reference of the note
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * toString method
     * @return String representation
     */
    @Override
    public String toString() {
        return "Category: " + category + '\n' +
                "Title: " + title + '\n' +
                "Content: " + content + '\n' +
                "Comment: " + Arrays.toString(comment) + '\n' +
                "Reference: " + reference + '\n';
    }
}
