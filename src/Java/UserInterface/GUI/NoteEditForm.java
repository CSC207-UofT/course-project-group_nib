package Java.UserInterface.GUI;

import Java.Controller.NoteInfoController;
import Java.Controller.NoteInfoPresenter;
import Java.Controller.UserInfoController;
import Java.Controller.UserInfoPresenter;
import Java.Entity.Note.Notes;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NoteEditForm extends JFrame implements ActionListener
{

    private JPanel contentPane;
    private JTextArea Jcontent;
    Button b1, b2;
    private Component frame;
    private String title;
    private String author;
    private String category;
    private String content;
    private String reference;
    private String date;

    /**
     * Create the frame.
     */
    public NoteEditForm(Notes note) {
        author = note.getAuthor();
        category = note.getCategory();
        title = note.getTitle();
        date = note.getDate();
        content = note.getContent();
        reference = note.getReference();

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Jtitle = new JLabel(title);
        Jtitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Jtitle.setBounds(152, 11, 250, 40);
        contentPane.add(Jtitle);

        JLabel Jcategory = new JLabel(category);
        Jcategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jcategory.setBounds(97, 43, 250, 33);
        contentPane.add(Jcategory);

        Jcontent = new JTextArea(content);
        Jcontent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jcontent.setBounds(97, 63, 300, 60);
        contentPane.add(Jcontent);

        JLabel Jreference = new JLabel(reference);
        Jreference.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jreference.setBounds(97, 123, 250, 29);
        contentPane.add(Jreference);


        b1 = new Button("Go Back...");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        b1.setBounds(73, 212, 100, 23);
        b1.addActionListener(this);
        contentPane.add(b1);

        b2 = new Button("Submit!");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        b2.setBounds(180, 212, 100, 23);
        b2.addActionListener(this);
        contentPane.add(b2);


    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Button bb=(Button)ae.getSource();
        if(bb==b1)
        {
            dispose();
            MainPage mp = new MainPage(author);
            mp.setVisible(true);
        }
        if(bb==b2)
        {
            ArrayList<String> all_info = new ArrayList<>();
            all_info.add(author);
            all_info.add(category);
            all_info.add(title);
            all_info.add(date);
            String content = Jcontent.getText();
            all_info.add(content);
            all_info.add(reference);

            NoteInfoPresenter presenter = new NoteInfoPresenter();
            NoteInfoController controller = new NoteInfoController(author, 2,
                    all_info, presenter);
            controller.decode();
            if(!presenter.getState())
            {
                JOptionPane.showMessageDialog(frame,"Edit failed. \n " +
                        "It is an unexpected error. Please restart the system :(");
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Note Successfully edited!");
                dispose();

                MainPage page = new MainPage(author);
                page.setVisible(true);
            }
        }
    }
}