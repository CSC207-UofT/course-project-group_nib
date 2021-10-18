package Interface;

import data.UserInfo;
import java.util.Scanner;

public class WelcomePartController {
    private final Scanner s;
    private boolean all_finished;
    UserInfo user;

    public WelcomePartController() {
        s = new Scanner(System.in);
        all_finished = false;
    }

    public void Login_or_Register(){
        user = new UserInfo();
        System.out.println("Welcome to Group_NiB's resource sharing system!");
        String str = Welcome();

        if (str.equals("login")) {
            Login();
            all_finished = true;
        }
        else if (str.equals("register")) {
            Register();
            all_finished = true;
        }else{
        System.out.println("We will exit the program. Thank you!");}
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
            login = user.Login(username, password);// Recursion
            if (!login){
                System.out.println("Login failed. Please try again by press enter, or type 'exit' to exit.");
                String next = s.nextLine();
                if (next.equals("exit")){
                    break;
                }else if (next.length() <= 0){
                    Login();
                }
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
            registered = user.Register(username, password);//Recursion
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
        controller.Login_or_Register();
    }
}


