package Java.UserInterface;

import Java.Controller.UserInfoController;
import Java.Controller.UserInfoPresenter;

import java.util.Scanner;

/**
 * the command line User Interface for user login and register
 */
public class CommandLineInterface {
    private boolean is_login;
    private final Scanner s;
    private String username;
    private String password;

    /**
     * initialize is_login and scanner s
     */
    public CommandLineInterface(){
        is_login = false;
        s = new Scanner(System.in);
    }

    /**
     * command line for user authentication
     */
    public void userAuthentication(){
        System.out.println("Welcome to Group_NiB's resource sharing system!");

        getUserDecision();
        UserInfoController user = new UserInfoController(is_login, username, password);
        UserInfoPresenter presenter = user.decode();

        while(!presenter.returnProgress()){
            if (is_login){
                System.out.println("Login unsuccessful. Please try again.");
            }else {
                System.out.println("Your username has been registered by other users. Please try another name.");
            }
            getUserDecision();
            user = new UserInfoController(is_login, username, password);
            presenter = user.decode();
        }

        System.out.println("Success! We are redirecting you to your home page.");
        username = presenter.returnUser();
    }

    /**
     * command line for login or register
     */
    public void getUserDecision(){
        System.out.println("Please type 'login' or 'register' to manage your account, " +
                "or any other keys to exit");
        String str = s.nextLine();
        if (str.equals("login")) {
            is_login = true;
            System.out.println("Please enter your username.");
            username = s.nextLine();
            System.out.println("Please enter your password");
            password = s.nextLine();
        }
        else if (str.equals("register")) {
            is_login = false;
            System.out.println("Please create your username.");
            username = s.nextLine();
            System.out.println("Please create your password");
            password = s.nextLine();
        }else{
            System.out.println("Invalid input. The system is quitting.");
            System.exit(0);
        }
    }

    /**
     * getter method to get username
     * @return return the username as String type
     */
    public String getUsername(){
        return username;
    }



}
