package UseCase.CourseManager;

import Entity.Note.Notes;

public class CategoryB extends Notes {
    /* Thought, Belief, and Behaviour*/


    public CategoryB(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment) {
        super(user_rate, editable, commentable, referable, changes, comment);

    }

    @Override
    public String toString() {
        return super.toString();

    }
}
