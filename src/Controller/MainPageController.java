package Controller;
import Data.UserInfo;
import Entity.Note.Notes;

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
        note.category = create.category(s);
        System.out.println("Choose Title for your note.");
        note.title = create.title(s);
        System.out.println("Enter the date.");
        note.updated_date = create.date(s);
        System.out.println("Type in your content for the note.");
        note.content = new StringBuilder(create.content(s));
        System.out.println("Do you have any references for your note? Yes/No");
        note.reference = create.reference(s);
        boolean ref = true;
        while (ref){
        if (note.reference.equals("Yes")){
            System.out.println("Add your references by typing in the URL or the title.");
            note.reference = s.nextLine();
            ref = false;
        }else if (note.reference.equals("No")){
            note.reference = "Original";
            ref = false;
        }else{
            System.out.println("Please type in Yes or No.");
        }

    }
        System.out.println("Is your note editable for other users? Yes/No");
        String edit = create.editable(s);
        boolean e = true;
        while (e) {
            if (edit.equals("Yes")) {
                note.editable = true;
                e = false;
            } else if (edit.equals("No")) {
                note.editable = false;
                e = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }

        System.out.println("Is your note referable for other users? Yes/No");
        String re = create.referable(s);
        boolean r = true;
        while (r) {
            if (re.equals("Yes")) {
                note.referable = true;
                r = false;
            } else if (re.equals("No")) {
                note.referable = false;
                r = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }

        System.out.println("Is your note commentable? Yes/No");
        String co = create.referable(s);
        boolean c = true;
        while (c) {
            if (co.equals("Yes")) {
                note.commentable = true;
                c = false;
            } else if (co.equals("No")) {
                note.commentable = false;
                c = false;
            } else {
                System.out.println("Please type in Yes or No.");
            }
        }
        System.out.println(note);
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
