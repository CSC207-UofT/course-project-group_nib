package Java.Entity.Note;

import Java.Entity.Note.Notes;

import java.util.ArrayList;

public class ScienceNotes extends Notes {
    /*Physics & Math category
     * @param relatedDefinition: Related definition for the science note.*/
    private String relatedDefinition;

    /**
     * call the super constructor, and initialize relatedDefinition
     * @param category category of the note
     * @param author author of the note
     * @param title title of the note
     * @param content content of the note
     * @param date date of the note created
     * @param relatedDefinition the definition which related to the content
     */
    public ScienceNotes(String category, String author, String title, String content, String date, String relatedDefinition) {
        super(category, author, title, content, date);
        this.relatedDefinition = relatedDefinition;
    }

    /**
     * empty constructor, call super
     */
    public ScienceNotes() {
        super();
    }

    /**
     * setter method, set the related definition
     * @param relatedDefinition the definition which related to the content
     */
    public void setRelatedDefinition(String relatedDefinition) {
        this.relatedDefinition = relatedDefinition;
    }

    /**
     * getter method, get the related definition
     * @return return related definition as String type
     */
    public String getRelatedDefinition() {
        return relatedDefinition;
    }

    /**
     * toString method
     * @return String representation
     */
    @Override
    public String toString() {
        return super.toString();
    }
}



