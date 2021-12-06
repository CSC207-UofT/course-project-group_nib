package Java.Main;

import Java.UserInterface.CommandLineInterface;
import Java.UserInterface.MainPageInterface;

public class ProjectMain {
    /**
     * the main method of this project
     */
    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        CLI.userAuthentication();
        MainPageInterface MPI = new MainPageInterface(CLI.getUsername());
    }
}