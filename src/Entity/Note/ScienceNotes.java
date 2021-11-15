package Entity.Note;

import Entity.Note.Notes;

import java.util.ArrayList;

public class ScienceNotes extends Notes {
    /*Physics & Math */
    private String relatedDefinition;

    public ScienceNotes() {
    }

    public ScienceNotes(String category, String title, StringBuilder content, double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String reference, String created_date, String updated_date, ArrayList<String> note_list, String relatedDefinition) {
        super(category, title, content, user_rate, editable, commentable, referable, changes, comment, reference, created_date, updated_date, note_list);
        this.relatedDefinition = relatedDefinition;
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



