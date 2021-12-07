package Java.Data.NoteInfoTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * access the database
 */
public class NoteTableReader {
    private ArrayList<String[]> note_info_list;

    /**
     * read the csv file and split the item by comma
     */
    public NoteTableReader(){
        note_info_list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Java/Data/NoteInfoTable/NoteInfoTable.csv")); // filename here
            reader.readLine(); //Ignore line 1
            String line;
            while((line=reader.readLine())!=null){
                String[] item = line.split(","); //split the items by comma

                note_info_list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Polymorphism on constructor for testing only.

    /**
     * read the csv file with given filename and split the item by comma
     * @param filename the name of file as String type
     */
    public NoteTableReader(String filename){
        note_info_list = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); // filename here
            reader.readLine(); //Ignore line 1
            String line;
            while((line=reader.readLine())!=null){
                String[] item = line.split(","); //split the items by comma

                note_info_list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get the note_info_list with items of the note information
     * @return an ArrayList of String[] contains items of the note information
     */
    public ArrayList<String[]> getNoteInfoList() {
        return note_info_list;
    }

    /**
     * update the note_info_list
     * @param NoteInfoList a ArrayList of String[] of note information
     * @return return a boolean value true for successfully updated
     */
    public boolean updateNoteInfoList(ArrayList<String[]> NoteInfoList){
        note_info_list = NoteInfoList;
        updateTable();
        return true;
    }


    /**
     * update the database
     */
    public void updateTable(){
        try {
            File csv = new File("src/Java/Data/NoteInfoTable/NoteInfoTable.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
            bw.write("Author,Category,Title,Date,Content，Reference");
            for (String[] line: note_info_list){
                bw.newLine();
                bw.write(
                        line[0]+"," +
                                line[1] + "," +
                                line[2] + "," +
                                line[3] + "," +
                                line[4] + "," +
                                line[5]);
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The NoteInfoTable.csv has been updated.");
    }
    
    /*Overloading methods for testing.*/

    /**
     * Overloading methods for testing
     * @param NoteInfoList a ArrayList of String[] of note information
     * @param filename the path of csv file
     * @return a boolean value true represents update successfully
     */
    public boolean updateNoteInfoList(ArrayList<String[]> NoteInfoList, String filename){
        note_info_list = NoteInfoList;
        updateTable(filename);
        return true;
    }

    /**
     * update the database
     * @param filename the pass of csv file
     */
    public void updateTable(String filename){
        try {
            File csv = new File(filename);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
            bw.write("Author,Category,Title,Date,Content，Reference");
            for (String[] line: note_info_list){
                bw.newLine();
                bw.write(
                        line[0]+"," +
                                line[1] + "," +
                                line[2] + "," +
                                line[3] + "," +
                                line[4] + "," +
                                line[5]);
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The TestNoteInfoTable.csv has been updated.");
    }


    /**
     * main method
     */
    public static void main(String[] args){
        NoteTableReader ntr = new NoteTableReader();
        ArrayList<String[]> nil = ntr.getNoteInfoList();
        String[] info = {"admin", "csc", "csc110notes", "20211202","testcontent", "https://google.com"};
        nil.add(info);
        ntr.updateNoteInfoList(nil);

    }

}
