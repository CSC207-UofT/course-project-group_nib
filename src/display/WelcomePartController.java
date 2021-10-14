package display;

import data.UserInfo;
import java.util.Scanner;

public class WelcomePartController {
    private final Scanner s;
    private boolean all_finished;
    UserInfo user;

    public WelcomePartController(){
        s = new Scanner(System.in);
        all_finished = false;
        user = new UserInfo();
        System.out.println("Welcome to Group_NiB's resource sharing system!");
        String str = Welcome();

        if (str.equals("login")) {
            Login();
            all_finished = true;
        }
        if (str.equals("register")) {
            Register();
            all_finished = true;
        }
    }

    public String Welcome(){
        System.out.println("Please type 'login' or 'register' to manage your account.");
        return s.nextLine();
    }

    public void Login(){
        boolean login = false;
        while (!login) {
            System.out.println("Please enter your username.");
            String username = s.nextLine();
            System.out.println("Please enter your password");
            String password = s.nextLine();
            login = user.Login(username, password);
            if (!login){
                System.out.println("Login failed. Please try again.");
            }else {
                System.out.println("You are in! We are redirecting you to the user home page.");
            }
        }
    }

    public void Register(){
        boolean registered = false;
        while (!registered){
            System.out.println("Please enter your username.");
            String username = s.nextLine();
            System.out.println("Please enter your password");
            String password = s.nextLine();
            registered = user.Register(username, password);
            if (!registered){
                System.out.println("legacy.Register failed. Usually it is due to the username duplication. " +
                        "Please try another name.");
            }else {
                System.out.println("Registered! We are redirecting you to the user home page.");
            }
        }

    }

    public boolean Finished(){
        return all_finished;
    }

    public static void main(String[] args) {
        WelcomePartController controller = new WelcomePartController();
        System.out.println(controller.Finished());
    }
}


