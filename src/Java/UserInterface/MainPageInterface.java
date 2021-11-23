package Java.UserInterface;

import Java.Controller.MainPageController;
import Entity.Note.Notes;
import Java.UseCase.NoteCreation;
import UserInterface.InterfaceEntity.NoteCreateForm;

import java.util.Scanner;

public class MainPageInterface {
    private final Scanner s;
    private boolean is_select;
    private MainPageController pageController;

    public MainPageInterface(String username) {
        s = new Scanner(System.in);
        is_select = false;
        pageController = new MainPageController(username);
        SelectFunction();
    }

    public void SelectFunction() {
        String str;
        while (!is_select) {
            str = Menu();
            switch (str) {
                case "1":
                    CreateNote();
                    break;
                case "2":
                    ModifyExistingNote();
                    break;
                case "3":
                    CommentOnANote();
                    break;
                case "4":
                    RateANote();
                    break;
                case "exit": {
                    System.out.println("Thank you for using Niubi! See you later!");
                    is_select = true;
                    break;
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


    public void CreateNote() {
        NoteCreateForm form = new NoteCreateForm();

        //add front-end verification before next phase

        System.out.println("Choose Category for your note.");
        String category = s.nextLine();
        form.setCategory(category);

        System.out.println("Choose Title for your note.");
        String title = s.nextLine();
        form.setTitle(title);

        System.out.println("Enter the date.");
        String date = s.nextLine();
        form.setDate(date);

        System.out.println("Type in your content for the note.");
        String content = s.nextLine();
        form.setContent(content);

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
        form.setReferences(references);

        System.out.println("Is your note editable for other users? Yes/No");
        boolean e = true;
        boolean editable = false;
        while (e) {
            String editableFlag = s.nextLine();
            if (editableFlag.equals("Yes")) {
                editable = true;
                e = false;
            } else if (editableFlag.equals("No")) {
                e = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
        form.setEditable(editable);

        System.out.println("Is your note referable for other users? Yes/No");
        boolean r = true;
        boolean referable = false;
        while (r) {
            String referableFlag = s.nextLine();
            if (referableFlag.equals("Yes")) {
                referable = true;
                r = false;
            } else if (referableFlag.equals("No")) {
                r = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
        form.setReferable(false);

        System.out.println("Is your note commentable? Yes/No");
        boolean c = true;
        boolean commentable = false;
        while (c) {
            String commentableFlag = s.nextLine();
            if (commentableFlag.equals("Yes")) {
                commentable = true;
                c = false;
            } else if (commentableFlag.equals("No")) {
                c = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
        form.setCommentable(commentable);

        Notes note = pageController.createNote(form);
        System.out.println(note);
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

}
