package Java.Data.NoteInfoTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NoteTableReader {
    private ArrayList<String[]> note_info_list;

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

    public ArrayList<String[]> getNoteInfoList() {
        return note_info_list;
    }

    public boolean updateNoteInfoList(ArrayList<String[]> NoteInfoList){
        note_info_list = NoteInfoList;
        UpdateTable();
        return true;
    }


    public void UpdateTable(){
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
        System.out.println("The TestOnly.csv has been updated.");
    }

    public static void main(String[] args){
        NoteTableReader ntr = new NoteTableReader();
        ArrayList<String[]> nil = ntr.getNoteInfoList();
        String[] info = {"admin", "csc", "csc110notes", "20211202","testcontent", "https://google.com"};
        nil.add(info);
        ntr.updateNoteInfoList(nil);

    }

}
