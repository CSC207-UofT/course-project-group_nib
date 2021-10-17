package Entity;

public interface INotes {

    void canComment (boolean commentable);
    void addComment (String comment);
    void setUserRate(double UserRate);

    void canRefer (boolean referable);

}
