package Controller;
import Data.UserInfo;
import Entity.Note.Notes;
import UseCase.NoteManager.Create.CreateNewNote;

import java.util.Scanner;

public class MainPageController {
    private final Scanner s;
    private boolean all_finished;
    UserInfo user;

    public MainPageController() {
        s = new Scanner(System.in);
        all_finished = false;
    }

    public void Select(){
        String str = Menu();
        switch (str) {
            case "1":
                CreateNote();
                all_finished = true;
                break;
            case "2":
                ModifyExistingNote();
                all_finished = true;
                break;
            case "3":
                CommentOnANote();
                all_finished = true;
                break;
            case "4":
                RateANote();
                all_finished = true;
            case "exit":
                System.out.println("Thank you for using Niubi! See you later!");
                break;
            default:
                System.out.println("Sorry, we don't understand your command.Please try again.");
        }
    }

    public String Menu(){
        System.out.println("Which action would you like to take?");
        System.out.println("Enter 1 to create a new note");
        System.out.println("Enter 2 to Modify an existing note");
        System.out.println("Enter 3 to Comment on a note");
        System.out.println("Enter 4 to Rate a note");
        System.out.println("Enter 'exit' to exit the program.");
        return s.nextLine();
    }
/*TODO: Replace the println in the following methods with appropriate code body.*/
    public void CreateNote(){
        CreateNewNote create = new CreateNewNote(s);
        Notes note = new Notes();
        System.out.println("Choose Category for your note.");
        note.category = s.nextLine();
        System.out.println("Choose Title for your note.");
        note.title = s.nextLine();
        System.out.println("Enter the date.");
        note.updated_date = s.nextLine();
        System.out.println("Type in your content for the note.");
        note.content = new StringBuilder(s.nextLine());

        create.reference(s, note);
        create.editable(s, note);
        create.referable(s, note);
        create.commentable(s, note);

        System.out.println(note);/*TODO: Need to store this note in the user account who created it.*/
    }

    public void ModifyExistingNote(){
        System.out.println("Modify Note!!");

    }

    public void CommentOnANote(){
        System.out.println("Comment Note!!");

    }

    public void RateANote(){
        System.out.println("Rate Note!!");

    }


    public boolean Finished(){
        return all_finished;
    }

    public static void main(String[] args) {
        MainPageController controller = new MainPageController();
        controller.Select();
    }

}
