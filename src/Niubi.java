import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Niubi{
    Map<Object ,Object> map;

    public static void add_User(User u){
        Map<Object ,Object> map = new HashMap<Object,Object>();
        map.put(u.password, u.user_notes);
    }

    public static void main(String[] args) {
        while (true){
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome to Niubi!");
            System.out.println("Please login with your password, or type 'Exit' to quit the program.");
            String str = s.nextLine();
            if (str.equals("Exit")){
                System.out.println("Program exit. We hope to see you again!");
                break;
            }else{
                if(str.length()<=0) {
                    System.out.println("You didn't enter anything. Would you like to register? (Y/N)");
                    String register_YorN = s.nextLine();
                    if (register_YorN.equals("Y")) {
                        System.out.println("Please set a new password below.");
                        String p = s.nextLine();
                        User new_user = new User();
                        new_user.setPassword(p);
                        add_User(new_user);
                        System.out.println("Your password is set successfully!");
                    }else{
                        System.out.println("Program exit. We hope to see you again!");
                        break;}
                }else{
                    System.out.println("这下面要接着问user进行什么action，具体看Readme，或者自己有想法和建议也可以写！");
                    //这下面要接着问user进行什么action，具体看Readme，或者自己有想法和建议也可以写！
                    //while loop body code继续！！
                }
            }
        }
    }
}