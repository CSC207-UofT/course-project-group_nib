package Entity;

public class CategoryD extends Notes {
    /*Phisics & Math */
    private String relatedDefinition;


    public CategoryD(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String relatedDefinition) {
        super(user_rate, editable, commentable, referable, changes, comment);
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



