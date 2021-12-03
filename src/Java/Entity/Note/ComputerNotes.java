package Java.Entity.Note;

import Java.Entity.Note.Notes;
import org.junit.runner.Computer;

import java.util.ArrayList;

public class ComputerNotes extends Notes {
    /* Computer science category
     * @param codeType: code type of the note
     * @param codeVersion: code version of the note*/

    private String codeType;
    private double codeVersion;

    public ComputerNotes(String category, String author, String title, String content,String date, String codeType) {
        super(category, author, title, content, date);
        this.codeType = codeType;
        this.codeVersion = 0.0;
    }

    public ComputerNotes(){
        super();
    }

    //category, title, content, user_rate, comment, reference
    //String category, String title, String content, double user_rate, String[] comment, String[] reference,

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
        return super.toString() + "Code Type: " + codeType + '\n' +
                "Code Version: " + codeVersion + '\n';
    }
}



