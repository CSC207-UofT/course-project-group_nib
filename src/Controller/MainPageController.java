package Controller;
import Data.UserInfo;

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
                CreateNewNote();
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
        System.out.println("Enter 1 to Create new note");
        System.out.println("Enter 2 to Modify an existing note");
        System.out.println("Enter 3 to Comment on a note");
        System.out.println("Enter 4 to Rate a note");
        System.out.println("Enter 'exit' to exit the program.");
        return s.nextLine();
    }
/*TODO: Replace the println in the following methods with appropriate code body.*/
    public void CreateNewNote(){
        System.out.println("Create Note!!");
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
