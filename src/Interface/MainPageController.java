package Interface;
import data.UserInfo;

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
            case "2":
                ModifyExistingNote();
                all_finished = true;
            case "3":
                CommentOnANote();
                all_finished = true;
            case "4":
                RateANote();
                all_finished = true;
            default:
                System.out.println("Invalid.");
        }
    }

    public String Menu(){
        System.out.println("Which action would you like to take?");
        System.out.println("Enter 1 to Create new note");
        System.out.println("Enter 2 to Modify an existing note");
        System.out.println("Enter 3 to Comment on a note");
        System.out.println("Enter 4 to Rate a note");
        return s.nextLine();
    }

    public void CreateNewNote(){

    }

    public void ModifyExistingNote(){

    }

    public void CommentOnANote(){

    }

    public void RateANote(){

    }


    public boolean Finished(){
        return all_finished;
    }

    public static void main(String[] args) {
        MainPageController controller = new MainPageController();
        controller.Select();
    }

}
