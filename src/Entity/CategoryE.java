package Entity;

public class CategoryE extends Notes {
    /* computer science  */

    //    public CategoryA(){
//        super();
//    }
    private String codeType;

    public CategoryE(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String codeType) {
        super(user_rate, editable, commentable, referable, changes, comment);
        this.codeType = codeType;
    }
    public void setCodeType(String codeType){
        this.codeType = codeType;
    }

    public String getCodeType() {
        return codeType;
    }

    @Override
    public String toString() {
        return super .toString();
    }
}



