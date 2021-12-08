package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public abstract class NoteInfoManipulation {
    private final String author;
    private final ArrayList<String> note_info;
    private final NoteInfoDataAccess api;

    /**
     * @param author author of the note as a String type
     * @param note_info the information of the note as an array list of String
     * @param api application programing interface*/

    public NoteInfoManipulation(NoteInfoDataAccess api, ArrayList<String> note_info, String author) {
        this.author = author;
        this.note_info = note_info;
        this.api = api;
    }

    public boolean changeNote(){
        return false;
    }



    public ArrayList<String[]> searchNotes(String str){
        return null;
    }
    /*
     * search the note
     * @param str string for searching
     * @return return null
     */


    public ArrayList<String> getNoteInfo(){
        return note_info;
    }
    /*
     * declare a method which return the note_info
     * @return return the information of note as ArrayList of String
     */

    public String getAuthor(){
        return author;
    }
    /*
     * declare a function which return the author
     * @return return the note author as String type
     */

    public NoteInfoDataAccess getApi(){
        return api;
    }
    /*
     * declare a function which returns the api
     * @return return the api as noteInfoDataAccess
     */


}
