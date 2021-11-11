package Controller;

import Data.UserInfo;
import Entity.Note.Notes;
import UseCase.NoteCreation;

import java.util.Scanner;

public class MainPageController {
    private final Scanner s;
    private boolean all_finished;
    UserInfo user;

    public MainPageController() {
        s = new Scanner(System.in);
        all_finished = false;
        Select();
    }

    public void Select() {
        String str;
        while (!all_finished) {
            str = Menu();
            switch (str) {
                case "1":
                    CreateNote();
                case "2":
                    ModifyExistingNote();
                case "3":
                    CommentOnANote();
                case "4":
                    RateANote();
                case "exit": {
                    System.out.println("Thank you for using Niubi! See you later!");
                    all_finished = true;
                }
                default:
                    System.out.println("Sorry, we don't understand your command.Please try again.");
            }
        }
    }

    public String Menu() {
        System.out.println("Which action would you like to take next?");
        System.out.println("Enter 1 to create a new note");
        System.out.println("Enter 2 to Modify an existing note");
        System.out.println("Enter 3 to Comment on a note");
        System.out.println("Enter 4 to Rate a note");
        System.out.println("Enter 'exit' to exit the program.");
        return s.nextLine();
    }

    /*TODO: Replace the println in the following methods with appropriate code body.*/
    public void CreateNote() {
        NoteCreation create = new NoteCreation();
        System.out.println("Choose Category for your note.");
        create.category(s.nextLine());

        System.out.println("Choose Title for your note.");
        create.title(s.nextLine());

        System.out.println("Enter the date.");
        create.date(s.nextLine());

        System.out.println("Type in your content for the note.");
        create.content(s.nextLine());

        System.out.println("Do you have any references for your note? Yes/No");

        boolean ref = true;
        while (ref) {
            String referencesFlag = this.s.nextLine();
            if (referencesFlag.equals("Yes")) {
                System.out.println("Add your references by typing in the URL or the title.");
                create.references(s.nextLine());
                ref = false;
            } else if (referencesFlag.equals("No")) {
                create.references("Original");
                ref = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
        System.out.println("Is your note editable for other users? Yes/No");

        boolean e = true;
        while (e) {
            String editableFlag = s.nextLine();
            if (editableFlag.equals("Yes")) {
                create.editable(true);
                e = false;
            } else if (editableFlag.equals("No")) {
                create.editable(false);
                e = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }

        System.out.println("Is your note referable for other users? Yes/No");

        boolean r = true;
        while (r) {
            String referableFlag = s.nextLine();
            if (referableFlag.equals("Yes")) {
                create.referable(true);
                r = false;
            } else if (referableFlag.equals("No")) {
                create.referable(false);
                r = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }

        System.out.println("Is your note commentable? Yes/No");

        boolean c = true;
        while (c) {
            String commentableFlag = s.nextLine();
            if (commentableFlag.equals("Yes")) {
                create.commentable(true);
                c = false;
            } else if (commentableFlag.equals("No")) {
                create.commentable(false);
                c = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
//        System.out.println(note);
        Notes notes = create.getNotes();
        System.out.println(notes);
    }

    public void ModifyExistingNote() {
        System.out.println("Modify Note!!");

    }

    public void CommentOnANote() {
        System.out.println("Comment Note!!");

    }

    public void RateANote() {
        System.out.println("Rate Note!!");

    }


    public boolean Finished() {
        return all_finished;
    }

    public static void main(String[] args) {
        MainPageController controller = new MainPageController();
        controller.Select();
    }

}
