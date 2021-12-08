package Java.Data.NoteInfoTable;

import Java.UseCase.NoteInfo.NoteInfoDataAccess;

import java.util.ArrayList;

/**
 * manage data passed from use case by using NoteInfoDataAccess interface
 */
public class NoteInfoAccess implements NoteInfoDataAccess {
    private final NoteTableReader ntr;
    private final ArrayList<String[]> nil;

    /**
     * initialize nil and ntr
     */
    public NoteInfoAccess(){
        ntr = new NoteTableReader();
        nil = ntr.getNoteInfoList();
    }

    /*Polymorphism on constructor just for testing.*/

    /**
     * access csv file
     * @param n NoteTableReader
     * @param list note information
     */
    public NoteInfoAccess(NoteTableReader n, ArrayList<String[]> list){
        ntr = n;
        nil = list;
    }

    /**
     * Add the new info_list to the Note Info Table database
     * @param info_list a list of note information and content
     * @return a boolean value whether created or not
     */
    @Override
    public boolean create(String[] info_list) {
        /*Add the new info_list to the Note Info Table database.*/
        boolean flag = titleNotDuplicated(info_list[2]);

        if (flag){
            nil.add(info_list);
            ntr.updateNoteInfoList(nil);
            System.out.println("1");
            return true;
        }
        return false;
    }

    /**
     * Remove the note from csv file
     * @param title title of the note as String type
     */
    @Override
    public boolean delete(String title) {
        /*Remove the note from csv file.*/
        int count = 0;
        for (String[] item : nil){
            if (item[2].equals(title)){
                break;
            }
            count ++;
        }
        nil.remove(count);
        return ntr.updateNoteInfoList(nil);
    }

    /**
     * Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
     * first, and then add the new note to the csv file
     * @param info_list a list of note information and content
     * @param title title of the note
     * @return call create() and return a boolean value.
     */
    @Override
    public boolean edit(String[] info_list, String title) {
        /*Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
         * first, and then add the new note to the csv file.*/
        delete(title);
        return create(info_list);
    }

    /**
     * Search for a note in the csv file
     * @param search_item the item for searching as String type
     * @param username username of the manipulator
     * @return return all matched items as ArrayList<String[]>
     */
    @Override
    public ArrayList<String[]> search(String search_item, String username) {
        /*Search for a note in the csv file.*/
        ArrayList<String[]> search_result = new ArrayList<>();
        for (String[] item : nil){
            if (item[2].equals(search_item) && item[0].equals(username)){
                search_result.add(item);
            }
        }
        return search_result;
    }

    /**
     * get all notes
     * @return return all notes as ArrayList<String[]>
     */
    @Override
    public ArrayList<String[]> getAllNotes(){
        return nil;
    }

    /**
     * Check whether there are notes with duplicated titles
     * @param title title of the note
     * @return return true if title match, vice versa
     */
    public boolean titleNotDuplicated(String title){
        /*Check whether there are notes with duplicated titles.*/
        for(String[] item : nil){
            if(item[2].equals(title)){
                return false;
            }
        }
        return true;
    }


    /*Overloading methods for testing only.
    *
    *
    *
    *
    * */
    /**
     * Add the new info_list to the Note Info Table database
     * @param list a list of note
     * @param note information of the note
     * @param read  NoteTableReader
     * @return return boolean type, true for created, false for failed
     */
    public boolean create(ArrayList<String[]> list, String[] note, NoteTableReader read) {
        /*Add the new info_list to the Note Info Table database.*/

        boolean flag = titleNotDuplicated(list, note[2]);

        if (flag){
            list.add(note);
            read.updateNoteInfoList(list, "src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
            return true;
        }
        return false;
    }


    /**
     * Remove the note from csv file
     * @param list  a list of note
     * @param title the title of note
     * @param read NoteTableReader
     */
    public boolean delete(ArrayList<String[]> list, String title, NoteTableReader read) {
        /*Remove the note from csv file.*/
        int count = 0;
        for (String[] item : list){
            if (item[2].equals(title)){
                break;
            }
            count ++;
        }
        list.remove(count);
        return read.updateNoteInfoList(list, "src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
    }

    /**
     * Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
     * first, and then add the new note to the csv file.
     * @param list a list of note
     * @param info_list list of information of note
     * @param title the title of note
     * @param read NoteTableReader
     * @return return a boolean value whether edit successfully or not
     */
    public boolean edit(ArrayList<String[]> list, String[] info_list, String title, NoteTableReader read) {
        /*Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
         * first, and then add the new note to the csv file.*/
        delete(list, title, read);
        return create(list, info_list, read);
    }

    /**
     * Search for a note in the csv file
     * @param list a list of note
     * @param search_item the item for searching as String type
     * @param username the name of user
     * @return return a search result as ArrayList<String[]> for its type
     */
    public ArrayList<String[]> search(ArrayList<String[]> list, String search_item, String username) {
        /*Search for a note in the csv file.*/
        ArrayList<String[]> search_result = new ArrayList<>();
        for (String[] item : list){
            if (item[2].equals(search_item) && item[0].equals(username)){
                search_result.add(item);
            }
        }
        return search_result;
    }

    /**
     * Check whether there are notes with duplicated titles
     * @param list a list of note
     * @param title the title of note
     * @return return a boolean value whether the title is duplicate or not
     */
    public boolean titleNotDuplicated(ArrayList<String[]> list, String title){
        /*Check whether there are notes with duplicated titles.*/
        for(String[] item : list){
            if(item[2].equals(title)){
                return false;
            }
        }
        return true;
    }
}
