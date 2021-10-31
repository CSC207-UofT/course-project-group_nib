package UseCase.CourseManager;

import Entity.Note.Notes;

import java.util.ArrayList;


public class LiteratureNotes extends Notes {
    /*Literature*/

    private ArrayList<String> reference_page = new ArrayList<>();

    public LiteratureNotes(double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment){
        super( user_rate,  editable,  commentable,  referable,  changes,  comment);
    }

    public void addReferencePage(String reference){
        reference_page.add(reference);
        System.out.println("reference: "+ reference+" Has been added");
    }
    public void removeAllReference(){
        reference_page.clear();
        System.out.println("Deleted all references");

    }

    public void removesSingleReference(int index){
        reference_page.remove(index);
        System.out.println(index+"th reference has been removed");

    }


    @Override
    public String toString() {
        return super.toString();
    }
}
