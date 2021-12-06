package Java.Data.NoteInfoTable;

import Java.UseCase.NoteInfo.NoteInfoDataAccess;

import java.util.ArrayList;

public class NoteInfoAccess implements NoteInfoDataAccess {
    private final NoteTableReader ntr;
    private final ArrayList<String[]> nil;

    public NoteInfoAccess(){
        ntr = new NoteTableReader();
        nil = ntr.getNoteInfoList();
    }

    /*Polymorphism on constructor just for testing.*/
    public NoteInfoAccess(NoteTableReader n, ArrayList<String[]> list){
        ntr = n;
        nil = list;
    }


    @Override
    public boolean create(String[] info_list) {
        /*Add the new info_list to the Note Info Table database.*/
        boolean flag = title_not_duplicated(info_list[2]);

        if (flag){
            nil.add(info_list);
            ntr.updateNoteInfoList(nil);
            return true;
        }
        return false;
    }


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

    @Override
    public boolean edit(String[] info_list, String title) {
        /*Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
         * first, and then add the new note to the csv file.*/
        delete(title);
        return create(info_list);
    }

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

    @Override
    public ArrayList<String[]> getAllNotes(){
        return nil;
    }

    public boolean title_not_duplicated(String title){
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
    public boolean create(ArrayList<String[]> list, String[] note, NoteTableReader read) {
        /*Add the new info_list to the Note Info Table database.*/

        boolean flag = title_not_duplicated(note[2]);

        if (flag){
            list.add(note);
            read.updateNoteInfoList(list, "src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
            return true;
        }
        return false;
    }



    public void delete(ArrayList<String[]> list, String title, NoteTableReader read) {
        /*Remove the note from csv file.*/
        int count = 0;
        for (String[] item : list){
            if (item[2].equals(title)){
                break;
            }
            count ++;
        }
        list.remove(count);
        read.updateNoteInfoList(list, "src/Java/Data/NoteInfoTable/TestNoteInfoTable.csv");
    }


    public boolean edit(ArrayList<String[]> list, String[] info_list, String title, NoteTableReader read) {
        /*Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
         * first, and then add the new note to the csv file.*/
        delete(list, title, read);
        return create(list, info_list, read);
    }


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

    public boolean title_not_duplicated(ArrayList<String[]> list, String title){
        /*Check whether there are notes with duplicated titles.*/
        for(String[] item : list){
            if(item[2].equals(title)){
                return false;
            }
        }
        return true;
    }
}
