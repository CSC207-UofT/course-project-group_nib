package Java.UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreatNotes {public static void main(String[] args) {
    JFrame frame = new JFrame("Notes Create");
    // Setting the width and height of frame
    frame.setSize(1000, 1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);
    placeComponents(panel);
    frame.setVisible(true);
}

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20,40,80,25);
        panel.add(titleLabel);

        panel.setLayout(null);
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(20,140,80,25);
        panel.add(authorLabel);

        panel.setLayout(null);
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(20,240,80,25);
        panel.add(categoryLabel);

        panel.setLayout(null);
        JLabel ContentLabel = new JLabel("Content:");
        ContentLabel.setBounds(20,340,80,25);
        panel.add(ContentLabel);


        JTextField titleText = new JTextField(30);
        titleText.setBounds(100,40,200,30);
        panel.add(titleText);

        JTextField authorText = new JTextField(30);
        authorText.setBounds(100,140,200,30);
        panel.add(authorText);

        JTextField categoryText = new JTextField(30);
        categoryText.setBounds(100,240,200,30);
        panel.add(categoryText);

        JTextField contentText = new JTextField(30);
        contentText.setBounds(100,340,500,400);
        panel.add(contentText);

        JButton createButton = new JButton("Creat");
        createButton.setBounds(800, 300, 100, 40);
        panel.add(createButton);
    }

}

