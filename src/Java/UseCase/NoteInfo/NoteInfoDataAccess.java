package Java.UseCase.NoteInfo;

import java.util.ArrayList;

/**
 * an interface which implemented by NoteAccess in Data package to make changes from usecase to csv
 */
public interface NoteInfoDataAccess {
    /**
     * declare a method create()
     * @param info_list a list of note information and content
     * @return return a boolean value whether created or not
     */
    boolean create(String[] info_list);

    /**
     * declare a method delete() with no return value
     * @param title title of the note as String type
     */
    boolean delete(String title);

    /**
     * declare a method edit()
     * @param info_list a list of note information and content
     * @param title title of the note as String type
     * @return return a boolean value whether teh note have been edited or not
     */
    boolean edit(String[] info_list, String title);

    /**
     *
     * @param title title of the note as String type
     * @param username username of the manipulator
     * @return return the searched note's information in an ArrayList of String
     */
    ArrayList<String[]> search(String title, String username);

    /**
     *
     * @return return an ArrayList of Sting[] of notes
     */
    ArrayList<String[]> getAllNotes();
}
