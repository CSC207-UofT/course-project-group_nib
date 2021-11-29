import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Page");
        // Setting the width and height of frame
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20,40,80,25);
        panel.add(userLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20,80,80,25);
        panel.add(passwordLabel);

        JTextField userText = new JTextField(30);
        userText.setBounds(100,40,200,30);
        panel.add(userText);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,80,200,30);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 40);
        panel.add(loginButton);
    }

}
