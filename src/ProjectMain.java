import Controller.MainPageController;
import Controller.WelcomePartController;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
public class ProjectMain {

    public static void main(String[] args) {
        WelcomePartController controller = new WelcomePartController();
        if(controller.Finished()){
            MainPageController mpcontroller = new MainPageController();
        }
    }
}