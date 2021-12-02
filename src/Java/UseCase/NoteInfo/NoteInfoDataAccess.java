package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public interface NoteInfoDataAccess {
    public void create(String[] info_list);
    public void delete(String title) ;
    public void edit(String[] info_list, String title);
    public ArrayList<String[]> search(String title) ;
}
