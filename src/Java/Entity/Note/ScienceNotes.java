package Java.Entity.Note;

import Java.Entity.Note.Notes;

import java.util.ArrayList;

public class ScienceNotes extends Notes {
    /*Physics & Math category
     * @param relatedDefinition: Related definition for the science note.*/
    private String relatedDefinition;

    public ScienceNotes(String category, String author, String title, String content, String date, String relatedDefinition) {
        super(category, author, title, content, date);
        this.relatedDefinition = relatedDefinition;
    }

    public ScienceNotes() {
        super();
    }

    public void setRelatedDefinition(String relatedDefinition) {
        this.relatedDefinition = relatedDefinition;
    }

    public String getRelatedDefinition() {
        return relatedDefinition;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}



