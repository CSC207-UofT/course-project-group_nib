package Main;

import Controller.MainPageController;
import UserInterface.CommandLineInterface;
import UserInterface.MainPageInterface;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
public class ProjectMain {

    public static void main(String[] args) {
        CommandLineInterface CLI = new CommandLineInterface();
        CLI.userAuthentication();
        MainPageInterface MPI = new MainPageInterface(CLI.getUsername());
    }
}