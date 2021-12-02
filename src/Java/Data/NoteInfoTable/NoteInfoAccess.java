package Java.Data.NoteInfoTable;

import Java.UseCase.NoteInfo.NoteInfoDataAccess;

import java.util.ArrayList;

public class NoteInfoAccess implements NoteInfoDataAccess {
    private NoteTableReader ntr;
    private ArrayList<String[]> nil;

    public NoteInfoAccess(){
        NoteTableReader ntr = new NoteTableReader();
        nil = ntr.getNoteInfoList();
    }


    @Override
    public void create(String[] info_list) {
        if (title_not_duplicated(info_list[2])){
            nil.add(info_list);
            ntr.updateNoteInfoList(nil);
        }
    }

    @Override
    public void delete(String title) {
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
        delete(title);
        create(info_list);
    }

    @Override
    public ArrayList<String[]> search(String search_item) {
        ArrayList<String[]> search_result = new ArrayList<>();
        String curr_title;
        for (String[] item : nil){
            curr_title = item[2];
            if (curr_title.contains(search_item)){
                search_result.add(item);
            }
        }
        return search_result;
    }

    public boolean title_not_duplicated(String title){
        for(String[] item : nil){
            if(item[2].equals(title)){
                return false;
            }
        }
        return true;
    }
}
