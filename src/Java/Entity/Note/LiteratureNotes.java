package Java.Entity.Note;

import Java.Entity.Note.Notes;

import java.util.ArrayList;


public class LiteratureNotes extends Notes {
    /* Literature category
     * @param reference_page: source of reference in the note*/

    private ArrayList<String> reference_page = new ArrayList<>();

    /**
     * call the super constructor, and initialize reference_page
     * @param category category of the note
     * @param author author of the note
     * @param title title of the note
     * @param content content of the note
     * @param date date of the note created
     * @param reference_page a ArrayList of reference page
     */
    public LiteratureNotes(String category, String author, String title, String date, String content, ArrayList<String> reference_page) {
        super(category, author, title, content, date);
        this.reference_page = reference_page;
    }

    /**
     * empty constructor, call super
     */
    public LiteratureNotes(){
        super();
    }

    /**
     * add reference page to the ArrayList of string
     * @param reference single reference as String type
     */
    public void addReferencePage(String reference){
        reference_page.add(reference);
        System.out.println("reference: "+ reference+" Has been added");
    }

    /**
     * remove all reference
     */
    public void removeAllReference(){
        reference_page.clear();
        System.out.println("Deleted all references");

    }

    /**
     * remove a single reference
     * @param index the index of reference located in ArrayList of references
     */
    public void removesSingleReference(int index){
        reference_page.remove(index);
        System.out.println(index+"th reference has been removed");

    }


    /**
     * toString method
     * @return String representation
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
