package UseCase.CourseManager;

import Entity.Note.Notes;

public class ComputerNotes extends Notes {
    /* computer science  */

    //    public CategoryA(){
//        super();
//    }
    private String codeType;
    private Double codeVersion;

    public ComputerNotes(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String codeType) {
        super(user_rate, editable, commentable, referable, changes, comment);
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
        return super .toString();
    }
}



