package Java.Entity.Note;

import Java.Entity.Note.Notes;
import org.junit.runner.Computer;

import java.util.ArrayList;

public class ComputerNotes extends Notes {
    /* Computer science category
    * @param codeType: type of the code,like python ,java,C or C++
    * @param codeVersion: version of code ,like python3.9 or python 2.7.
    */
    private String codeType;
    private double codeVersion;

    public ComputerNotes(String category, String author, String title, String content, String codeType) {
        super(category, author, title, content);
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



