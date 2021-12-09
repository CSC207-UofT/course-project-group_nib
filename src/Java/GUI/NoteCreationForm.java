package Java.GUI;
import Java.Controller.NoteInfoController;
import Java.Controller.NoteInfoPresenter;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class NoteCreationForm extends JFrame implements ActionListener
{

    private final JTextField catField;
    private final JTextField titleField;
    private final JTextField dateField;
    private final JTextArea contentField;
    private final JTextField refField;
    final Button b1;
    final Button b2;
    private final String username;
    private Component frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                NoteCreationForm frame = new NoteCreationForm("Test");
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public NoteCreationForm(String username)
    {
        this.username = username;
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 520);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel note_creation = new JLabel("Note Creation");
        note_creation.setFont(new Font("Tahoma", Font.PLAIN, 20));
        note_creation.setBounds(112, 11, 129, 44);
        contentPane.add(note_creation);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Tahoma", Font.PLAIN, 16));
        category.setBounds(53, 66, 100, 30);
        contentPane.add(category);

        catField = new JTextField(" ");
        catField.setBounds(178, 73, 110, 20);
        contentPane.add(catField);
        catField.setColumns(10);

        JLabel title = new JLabel("Title:");
        title.setFont(new Font("Tahoma", Font.PLAIN, 16));
        title.setBounds(53, 102, 67, 30);
        contentPane.add(title);

        titleField = new JTextField(" ");
        titleField.setBounds(178, 102, 110, 20);
        contentPane.add(titleField);
        titleField.setColumns(10);

        JLabel date = new JLabel("Date:");
        date.setFont(new Font("Tahoma", Font.PLAIN, 16));
        date.setBounds(53, 138, 139, 14);
        contentPane.add(date);

        dateField = new JTextField(" ");
        dateField.setBounds(178, 138, 110, 20);
        contentPane.add(dateField);
        dateField.setColumns(10);

        JLabel content = new JLabel("Content:");
        content.setFont(new Font("Tahoma", Font.PLAIN, 16));
        content.setBounds(53, 169, 96, 20);
        contentPane.add(content);

        contentField = new JTextArea(" ");
        contentField.setBounds(178, 169, 110, 220);
        contentPane.add(contentField);
        contentField.setColumns(10);

        JLabel reference = new JLabel("Reference:");
        reference.setFont(new Font("Tahoma", Font.PLAIN, 16));
        reference.setBounds(53, 410, 86, 20);
        contentPane.add(reference);

        refField = new JTextField(" ");
        refField.setBounds(178, 410, 110, 20);
        contentPane.add(refField);
        refField.setColumns(10);

        b1= new Button("Submit");
        b1.addActionListener(this);
        b1.setBounds(192, 438, 90, 23);
        contentPane.add(b1);

        b2 = new Button("Back");
        b2.addActionListener(this);
        b2.setBounds(90, 438, 90, 23);
        contentPane.add(b2);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {

        Button bb=(Button)ae.getSource();
        if(bb==b1)                  //submit
        {

            try
            {
                ArrayList<String> all_info = new ArrayList<>();
                all_info.add(username);

                String category = catField.getText();
                all_info.add(category);
                String title = titleField.getText();
                all_info.add(title);
                String date = dateField.getText();
                all_info.add(date);
                String content = contentField.getText();
                all_info.add(content);
                String reference = refField.getText();
                all_info.add(reference);

                NoteInfoPresenter presenter = new NoteInfoPresenter();
                NoteInfoController controller = new NoteInfoController(username, 1,
                        all_info, presenter);
                controller.decode();
                if(!presenter.getState())
                {
                    JOptionPane.showMessageDialog(frame,"Creation failed. \n Check if you have notes with duplicated name. :(");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Note Successfully created!");
                    dispose();

                    MainPage page = new MainPage(username);
                    page.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(bb==b2)
        {
            dispose();
            LoginPage p=new LoginPage();         //gets us back to Page1 ie. Login page
            p.setVisible(true);
        }

    }
}
