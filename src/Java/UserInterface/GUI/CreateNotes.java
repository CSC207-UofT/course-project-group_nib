package Java.UserInterface.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateNotes {
    public static void main(String[] args) {
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
        JLabel titleLabel = new JLabel("Username:");
        titleLabel.setBounds(20,40,80,25);
        panel.add(titleLabel);

        panel.setLayout(null);
        JLabel authorLabel = new JLabel("Category:");
        authorLabel.setBounds(20,80,80,25);
        panel.add(authorLabel);

        panel.setLayout(null);
        JLabel TitleLabel = new JLabel("Title:");
        TitleLabel.setBounds(20,120,80,25);
        panel.add(TitleLabel);

        panel.setLayout(null);
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(20,160,80,25);
        panel.add(dateLabel);

        panel.setLayout(null);
        JLabel ContentLabel = new JLabel("Content:");
        ContentLabel.setBounds(20,200,80,25);
        panel.add(ContentLabel);

        panel.setLayout(null);
        JLabel refLabel = new JLabel("Reference:");
        refLabel.setBounds(20,650,80,25);
        panel.add(refLabel);


        JTextField UsernameText = new JTextField(30);
        UsernameText.setBounds(100,40,200,30);
        panel.add(UsernameText);

        JTextField CategoryText = new JTextField(30);
        CategoryText.setBounds(100,80,200,30);
        panel.add(CategoryText);

        JTextField titleText = new JTextField(30);
        titleText.setBounds(100,120,200,30);
        panel.add(titleText);

        JTextField DateText = new JTextField(30);
        DateText.setBounds(100,160,200,30);
        panel.add(DateText);

        JTextField contentText = new JTextField(30);
        contentText.setBounds(100,200,400,400);
        panel.add(contentText);

        JTextField ReferenceText = new JTextField(30);
        ReferenceText.setBounds(100,650,200,30);
        panel.add(ReferenceText);

        JButton createButton = new JButton("Create Notes");
        createButton.setBounds(800, 300, 100, 40);
        panel.add(createButton);
    }

}

