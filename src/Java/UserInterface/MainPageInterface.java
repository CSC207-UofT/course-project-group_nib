package Java.UserInterface;

import Java.Controller.NoteInfoController;
import Java.Controller.NoteInfoPresenter;
import Java.Data.NoteInfoTable.NoteInfoAccess;
import Java.Entity.Note.Notes;
import Java.UseCase.NoteInfo.NoteInfoDataAccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainPageInterface {
    private final Scanner s;
    private final String username;
    private boolean is_select;
    private final NoteInfoPresenter presenter;

    public MainPageInterface(String username) {
        s = new Scanner(System.in);
        is_select = false;
        this.username = username;
        // TODO: complete the presenter object
        presenter = new NoteInfoPresenter();
        SelectFunction();
    }

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
                case "exit" : {
                    System.out.println("Thank you for using Niubi! See you later!");
                    is_select = true;
                }
                break;
                default : System.out.println("Sorry, we don't understand your command.Please try again.");
            }
        }
    }

    public String Menu() {
        System.out.println("Which action would you like to take next?");
        System.out.println("Enter 1 to create a new note");
        System.out.println("Enter 2 to edit an existing note");
        System.out.println("Enter 3 to delete the selected note");
        System.out.println("Enter 'exit' to exit the program.");
        return s.nextLine();
    }


    public void CreateNote() {
        ArrayList<String> note_info = new ArrayList<>();

        //add front-end verification before next phase
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
        String references = "";
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

//        System.out.println("Is your note editable for other users? Yes/No");
//        boolean e = true;
//        boolean editable = false;
//        while (e) {
//            String editableFlag = s.nextLine();
//            if (editableFlag.equals("Yes")) {
//                editable = true;
//                e = false;
//            } else if (editableFlag.equals("No")) {
//                e = false;
//            } else {
//                System.out.println("Please type in Yes or No.");
//            }
//        }
//        note_ability.add(editable);

//        System.out.println("Is your note referable for other users? Yes/No");
//        boolean referable = true;
//        while (referable) {
//            String referableFlag = s.nextLine();
//            if (referableFlag.equals("Yes")) {
//                referable = true;
//            } else if (referableFlag.equals("No")) {
//                referable = false;
//            } else {
//                System.out.println("Please type in Yes or No.");
//            }
//        }
//        note_ability.add(referable);
//        form.setReferable(false);
        /*
        Deleted "Is this note commentable?" We decide that notes are always commentable.
        */

        // TODO: complete the decode method
        NoteInfoController nic = new NoteInfoController(username,1, note_info, presenter);
        nic.decode();
    }

    public void EditNote() {
        // TODO: implement this method
        ArrayList<String> note_info = new ArrayList<>();
        NoteInfoDataAccess access = new NoteInfoAccess();
        System.out.println("Type in the title of the note that you would like to edit.");
       /*Still need to check whether the note actually exists in the database.*/
        String title = s.nextLine();
        ArrayList<String[]> list_of_search = access.search(title);
        if (list_of_search.size() != 0){
        System.out.println("We found the following notes that fit your title.");
        System.out.println(toString(list_of_search));
        System.out.println("Which one would you like to edit on? Please type in the number at the front of the note.");
        String choose = s.nextLine();
        int i = Integer.parseInt(choose); // Convert the string to integer.
        Collections.addAll(note_info, list_of_search.get(i));
        System.out.println("Please type in the new content that you would like to change to.");
        String new_content = s.nextLine();
        System.out.println("The note has been modified successfully.");}
        /* TODO: We still need to modify the NoteEdit class so that the edition can actually be made. May need to
        *   overload methods.*/
        else{System.out.println("Sorry, we don't find any notes with this title.");}
        NoteInfoController nic = new NoteInfoController(username,2, note_info, presenter);
        nic.decode();
    }

    public void DeleteNote() {
        ArrayList<String> note_info = new ArrayList<>();
        // TODO: implement this method


        NoteInfoController nic = new NoteInfoController(username,3, note_info, presenter);
        nic.decode();

    }

    /*A helper function below*/
    public String toString(ArrayList<String[]> array){
        StringBuilder s = new StringBuilder(new String(""));
        int i = 0;
        for (String[] item : array){
            s.append(i).append(" ").append("Author: ").append(item[0]).append('\n').append("Category: "
            ).append(item[1]).append('\n').append("Title: ").append(item[2]).append('\n').append("Created Date: "
            ).append(item[3]).append('\n').append("Content: ").append(item[4]).append('\n').append("References: "
            ).append(item[5]).append('\n'
            ).append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~").append('\n');

            i++;
        }
        return s.toString();
    }

}
