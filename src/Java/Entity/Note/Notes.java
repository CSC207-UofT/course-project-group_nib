package Java.Entity.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Notes {
    /*@param category: Category of the note
     * @param author: Author of the note, usually the username who logged in first and created it.
     * @param title: Title of the note
     * @param content: Content of the note
     * @param user_rate: Rate of the note
     * @param comment: comment of the rate
     * @param reference: reference of the rate
     * */
    private String category;
    private String author;
    private String title;
    private String content;
    private double user_rate;
    private String date;

    private String[] comment;
    private String reference;



    public Notes(String category, String author, String title, String content, String date) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.content = content;
        this.user_rate = 0.0;
        this.comment = null;
        this.reference = null;
        this.date = date;
    }

    public Notes() {

    }
    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

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

    public String getAuthor() {return author;}

    public void setAuthor(String author){this.author = author;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getUser_rate() {
        return user_rate;
    }

    public void setUser_rate(double user_rate) {
        this.user_rate = user_rate;
    }

    public String[] getComment() {
        return comment;
    }

    public void setComment(String[] comment) {
        this.comment = comment;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Category: " + category + '\n' +
                "Title: " + title + '\n' +
                "Content: " + content + '\n' +
                "Rate: " + user_rate + '\n' +
                "Comment: " + Arrays.toString(comment) + '\n' +
                "Reference: " + reference + '\n';
    }
}
