package Java.Entity.Note;

import Java.Entity.Note.Notes;

import java.util.ArrayList;

public class ComputerNotes extends Notes {
    /* computer science  */

    private String codeType;
    private Double codeVersion;

    public ComputerNotes() {
    }

    public ComputerNotes(String category, String title, StringBuilder content, double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String reference, String created_date, String updated_date, ArrayList<String> note_list, String codeType) {
        super(category, title, content, user_rate, editable, commentable, referable, changes, comment, reference, created_date, updated_date, note_list);
        this.codeType = codeType;
    }

    public void setCodeType(String codeType){
        this.codeType = codeType;
    }

    public void setCodeVersion(Double codeVersion) {
        this.codeVersion = codeVersion;
    }

    public String getCodeType() {
        return codeType;
    }

    public Double getCodeVersion() {
        return codeVersion;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}



