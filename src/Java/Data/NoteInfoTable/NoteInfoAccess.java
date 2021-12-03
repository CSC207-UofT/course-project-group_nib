package Java.Data.NoteInfoTable;

import Java.UseCase.NoteInfo.NoteInfoDataAccess;

import java.util.ArrayList;

public class NoteInfoAccess implements NoteInfoDataAccess {
    private NoteTableReader ntr;
    private final ArrayList<String[]> nil;

    public NoteInfoAccess(){
        NoteTableReader ntr = new NoteTableReader();
        nil = ntr.getNoteInfoList();
    }


    @Override
    public boolean create(String[] info_list) {
        /*Add the new info_list to the Note Info Table database.*/
        boolean flag = title_not_duplicated(info_list[2]);

        if (flag){
            nil.add(info_list);
            ntr.updateNoteInfoList(nil);
        }
        return flag;
    }

    @Override
    public void delete(String title) {
        /*Remove the note from csv file.*/
        int count = 0;
        for (String[] item : nil){
            if (item[2].equals(title)){
                break;
            }
            count ++;
        }
        nil.remove(count);
        ntr.updateNoteInfoList(nil);
    }

    @Override
    public void edit(String[] info_list, String title) {
        /*Edit an existing note from our csv file. However, we separate this into two steps: Remove the original one
        * first, and then add the new note to the csv file.*/
        delete(title);
        create(info_list);
    }

    @Override
    public ArrayList<String[]> search(String search_item) {
        /*Search for a note in the csv file.*/
        ArrayList<String[]> search_result = new ArrayList<>();
        for (String[] item : nil){
            if (item[2].equals(search_item)){
                search_result.add(item);
            }
        }
        return search_result;
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
}
