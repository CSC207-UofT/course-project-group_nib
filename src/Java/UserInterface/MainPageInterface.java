package Java.UserInterface;

import Java.Controller.NoteInfoController;
import Java.Controller.NoteInfoPresenter;
import Java.Entity.Note.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPageInterface {
    private final Scanner s;
    private String username;
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

        System.out.println("Choose Title for your note.");
        String title = s.nextLine();
        note_info.add(title);

        System.out.println("Enter the date.");
        String date = s.nextLine();
        note_info.add(date);

        System.out.println("Type in your content for the note.");
        String content = s.nextLine();
        note_info.add(content);

        System.out.println("Do you have any references for your note? Yes/No");
        boolean ref = true;
        String references = "";
        while (ref) {
            String referencesFlag = this.s.nextLine();
            if (referencesFlag.equals("Yes")) {
                System.out.println("Add your references by typing in the URL or the title.");
                references = s.nextLine();
                ref = false;
            } else if (referencesFlag.equals("No")) {
                references = "Original";
                ref = false;
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
        ArrayList<String> note_info = new ArrayList<>();
        // TODO: implement this method


        NoteInfoController nic = new NoteInfoController(username,2, note_info, presenter);
        nic.decode();
        System.out.println("Edit Note!!");
    }

    public void DeleteNote() {
        ArrayList<String> note_info = new ArrayList<>();
        // TODO: implement this method


        NoteInfoController nic = new NoteInfoController(username,3, note_info, presenter);
        nic.decode();
        System.out.println("Delete Note!!");

    }

}
