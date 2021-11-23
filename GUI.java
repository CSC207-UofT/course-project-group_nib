import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
    public static void main(String[] args){
        JFrame frame = new JFrame("Login page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JPanel panel = new JPanel();
        JButton button1 = new JButton("Login");
        button1.setBounds(100,100,100, 40);
        panel.add(button1);
        JButton button2 = new JButton("Register");
        button2.setBounds(500,100,100, 40);
        panel.add(button2);
        frame.add(panel);
        frame.setVisible(true);
        }

}