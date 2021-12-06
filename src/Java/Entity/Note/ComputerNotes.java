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

    /**
     * call the super constructor, and initialize codeType and CodeVersion
     * @param category category of the note
     * @param author author of the note
     * @param title title of the note
     * @param content content of the note
     * @param date date of the note created
     * @param codeType the type of code
     */
    public ComputerNotes(String category, String author, String title, String content,String date, String codeType) {
        super(category, author, title, content, date);
        this.codeType = codeType;
        this.codeVersion = 0.0;
    }

    /**
     * empty constructor, call super
     */
    public ComputerNotes(){
        super();
    }
    /**
     * setter method, set code type
     * @param codeType the type of code as String type, e.g.(Java, Python etc.)
     */
    public void setCodeType(String codeType){
        this.codeType = codeType;
    }

    /**
     * setter method, set the version of the code
     * @param codeVersion the version of the code as double type
     */
    public void setCodeVersion(Double codeVersion) {
        this.codeVersion = codeVersion;
    }

    /**
     * getter method, get the type of code
     * @return return the type of code as String type
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * getter method, get the code version
     * @return return the code version as Double type
     */
    public Double getCodeVersion() {
        return codeVersion;
    }

    /**
     * toString method
     * @return return String representation
     */
    @Override
    public String toString() {
        return super.toString() + "Code Type: " + codeType + '\n' +
                "Code Version: " + codeVersion + '\n';
    }
}



