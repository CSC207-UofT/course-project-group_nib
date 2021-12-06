package Java.UserInterface.GUI;

import javax.swing.*;

public class RegisterPage {
    public static void main(String[] args) {
    JFrame frame = new JFrame("Register Page");
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
        JLabel userLabel = new JLabel("New Username:");
        userLabel.setBounds(0,40,100,25);
        panel.add(userLabel);

        JLabel passwordLabel = new JLabel("New Password:");
        passwordLabel.setBounds(0,80,100,25);
        panel.add(passwordLabel);

        JTextField userText = new JTextField(30);
        userText.setBounds(100,40,200,30);
        panel.add(userText);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,80,200,30);
        panel.add(passwordText);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 150, 100, 40);
        panel.add(registerButton);
    }
}
