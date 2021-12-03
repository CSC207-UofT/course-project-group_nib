package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public interface NoteInfoDataAccess {
    boolean create(String[] info_list);
    void delete(String title);
    void edit(String[] info_list, String title);
    ArrayList<String[]> search(String title);
}
