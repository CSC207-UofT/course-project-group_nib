package Java.Main;

import Java.UserInterface.CommandLineUI.CommandLineInterface;
//import Java.UserInterface.CommandLineUI.MainPageInterface;

public class ProjectMain {
    /**
     * The main method of this project. Run this file to start the programing.
     */
    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        CLI.userAuthentication();
//        MainPageInterface MPI = new MainPageInterface(CLI.getUsername());
    }
}