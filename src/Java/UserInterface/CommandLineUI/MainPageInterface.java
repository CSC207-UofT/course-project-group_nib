package Java.UserInterface.CommandLineUI;

import Java.Controller.NoteInfoController;
import Java.Controller.NoteInfoPresenter;

import java.util.*;

/**
 * the command line User Interface for operate note
 */
public class MainPageInterface {
    private final Scanner s;
    private final String username;
    private boolean is_select;
    private final NoteInfoPresenter presenter;

    /**
     * initialize username, is_select, presenter and create a scanner s
     * @param username username as String type
     */
    public MainPageInterface(String username) {
        s = new Scanner(System.in);
        is_select = false;
        this.username = username;
        presenter = new NoteInfoPresenter();
        SelectFunction();
    }

    /**
     * command line for selecting operations
     */
    public void SelectFunction() {
        String str;
        while (!is_select) {
            str = Menu();
            switch (str) {
                case "1" : CreateNote();
                break;
                case "2" : EditNote();
                break;
                case "3" : DeleteNote();
                break;
                case "4" : SearchNote();
                break;
                case "exit" : {
                    System.out.println("Thank you for using NB! See you later!");
                    is_select = true;
                    break;
                }
                default : System.out.println("Sorry, we don't understand your command.Please try again.");
            }
        }
    }

    /**
     * the menu of operating note
     * @return return user's input
     */
    public String Menu() {
        System.out.println("Which action would you like to take next?");
        System.out.println("Enter 1 to create a new note");
        System.out.println("Enter 2 to edit an existing note");
        System.out.println("Enter 3 to delete the selected note");
        System.out.println("Enter 4 to search a note");
        System.out.println("Enter 'exit' to exit the program.");
        return s.nextLine();
    }


    /**
     * command line for setting information to note
     */
    public void CreateNote() {
        ArrayList<String> note_info = new ArrayList<>();

        //Add front-end verification before next phase
        note_info.add(username);

        System.out.println("Choose Category for your note.");
        String category = s.nextLine();
        note_info.add(category);

        System.out.println("Give a Title for your note.");
        String title = s.nextLine();
        note_info.add(title);

        System.out.println("Enter the date.");
        String date = s.nextLine();
        note_info.add(date);

        System.out.println("Type in your content for the note.");
        String content = s.nextLine();
        note_info.add(content);

        System.out.println("Do you have any references for your note? Yes/No");
        String references;
        while (true) {
            String referencesFlag = this.s.nextLine();
            if (referencesFlag.equals("Yes")) {
                System.out.println("Add your references by typing in the URL or the title.");
                references = s.nextLine();
                break;
            } else if (referencesFlag.equals("No")) {
                references = "Original";
                break;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
        note_info.add(references);
        NoteInfoController nic = new NoteInfoController(username,1, note_info, presenter);
        nic.decode();
    }

    /**
     * command line for edit note
     */
    public void EditNote() {
        ArrayList<String> note_info = new ArrayList<>();
        System.out.println("Type in the title of the note that you would like to edit.");
        String title = s.nextLine();
        note_info.add(title);
        NoteInfoController nic = new NoteInfoController(username,4, note_info, presenter); //Search first...
        nic.decode();
        ArrayList<ArrayList<String[]>> search = presenter.getAllInfo();
        ArrayList<String[]> list_of_search = toAL_StringArray(search);
        if (list_of_search.size() != 0){
            System.out.println("We found the following notes that fit your title.");
            System.out.println(ALtoString(list_of_search));
            System.out.println("Which one would you like to edit on? Please choose one by typing the number at front.");
            String choose = s.nextLine();
            int i = Integer.parseInt(choose);
            String[] wanted = list_of_search.get(i);
            ArrayList<String> note_in = new ArrayList<>(Arrays.asList(wanted));
            System.out.println("Please type in the new content that you would like to change to.");
            String new_content = s.nextLine();
            note_in.set(4, new_content);
            nic.setNew_content(new_content);
            nic.EditNote(note_in, username); //Then edit.
            System.out.println("The note has been modified successfully.");}
        else{
            System.out.println("Sorry, we don't find any notes with this title.");
            System.out.println(presenter.getState());
        }
    }

    /**
     * command line for search note
     */
    public void SearchNote() {
        ArrayList<String> note_info = new ArrayList<>();
        System.out.println("Please type in the title of the note that your are looking for.");
        String title = s.nextLine();
        note_info.add(title);
        NoteInfoController nic = new NoteInfoController(username, 4, note_info, presenter);
        nic.decode();
        ArrayList<ArrayList<String[]>> in = presenter.getAllInfo();
        ArrayList<String[]> info = toAL_StringArray(in);
        if (info.size() != 0) {
            System.out.println("We found the following notes that matches.");
            System.out.println(ALtoString(info));
            System.out.println("Do you find the one you are looking for? (Yes/No)");
            while (true) {
                String answer = s.nextLine();
                if (Objects.equals(answer, "Yes")) {
                    System.out.println("Thank you very much! We are glad to help you.");
                    break;
                } else if (Objects.equals(answer, "No")) {
                    System.out.println("We are sorry to hear that :( Please try again later.");
                    break;
                } else {
                    System.out.println("Please type in 'Yes' or 'No' :)");
                }
            }
        }else{System.out.println("Sorry! We can't find anything that matches. Please try again later.");}
    }

    /**
     * command line for delete note
     */
    public void DeleteNote() {
        ArrayList<String> note_info = new ArrayList<>();
        System.out.println("Please type in the title of the note that you would like to delete.");
        String note_title = s.nextLine();
        note_info.add(note_title);
        NoteInfoController nic = new NoteInfoController(username,4, note_info, presenter); //Search first
        nic.decode();
        ArrayList<ArrayList<String[]>> in = presenter.getAllInfo();
        ArrayList<String[]> info = toAL_StringArray(in);
        if(info.size() > 0){
            System.out.println("We found the following notes that matches.");
            System.out.println(ALtoString(info));
            System.out.println("Which one would you like to delete? Please choose one by typing the number at front.");
            int choice = s.nextInt();
            Collections.addAll(note_info, info.get(choice));
            nic.DeleteNote(note_info, username); //Then delete
            System.out.println("Note has been deleted successfully!");
        }
        else{System.out.println("Sorry you do not have access to the note or we can not find such note.");}

    }

    /*A helper function below*/

    /**
     * helper function
     * @param array ArrayList of String[]
     * @return return a String of note information
     */
    public String ALtoString(ArrayList<String[]> array){
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (String[] item : array){
            s.append(i).append(" ").append("Author: ").append(item[0]).append('\n').
                    append("Category: ").append(item[1]).append('\n').
                    append("Title: ").append(item[2]).append('\n').
                    append("Created Date: ").append(item[3]).append('\n').
                    append("Content: ").append(item[4]).append('\n').
                    append("References: ").append(item[5]).append('\n').
                    append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~").append('\n');
            i++;

        }
        return s.toString();
    }

    /**
     * Convert the object array list to an array list of string array
     * @param obj object array list
     * @return return an array list of string array
     */
    public ArrayList<String[]> toAL_StringArray(ArrayList<ArrayList<String[]>> obj){

            ArrayList<String[]> all = new ArrayList<>();
            for (ArrayList<String[]> item : obj){
                all.addAll(item);
                }
            return all;
        }
    }
