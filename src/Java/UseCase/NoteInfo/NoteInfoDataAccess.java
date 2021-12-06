package Java.UseCase.NoteInfo;

import java.util.ArrayList;

public interface NoteInfoDataAccess {
    public boolean create(String[] info_list);

    public boolean delete(String title);

    public boolean edit(String[] info_list, String title);

    public ArrayList<String[]> search(String title, String username);

    public ArrayList<String[]> getAllNotes();
}
