package Entity.Note;

import Entity.Note.Notes;

import java.util.ArrayList;


public class LiteratureNotes extends Notes {
    /*Literature*/

    private ArrayList<String> reference_page = new ArrayList<>();

    public LiteratureNotes() {
    }

    public LiteratureNotes(String category, String title, StringBuilder content, double user_rate, boolean editable, boolean commentable, boolean referable, String changes, String comment, String reference, String created_date, String updated_date, ArrayList<String> note_list, ArrayList<String> reference_page) {
        super(category, title, content, user_rate, editable, commentable, referable, changes, comment, reference, created_date, updated_date, note_list);
        this.reference_page = reference_page;
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
