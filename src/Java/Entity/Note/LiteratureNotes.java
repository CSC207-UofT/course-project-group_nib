package Java.Entity.Note;

import Java.Entity.Note.Notes;

import java.util.ArrayList;


public class LiteratureNotes extends Notes {
    /* Literature category
     * @param reference_page: source of reference in the note*/

    private ArrayList<String> reference_page = new ArrayList<>();

    public LiteratureNotes(String category, String author, String title, String date, String content, ArrayList<String> reference_page) {
        super(category, author, title, content, date);
        this.reference_page = reference_page;
    }

    public LiteratureNotes(){
        super();
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
