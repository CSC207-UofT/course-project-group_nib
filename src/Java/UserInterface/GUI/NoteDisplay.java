package Java.UserInterface.GUI;

import Java.Controller.UserInfoController;
import Java.Controller.UserInfoPresenter;
import Java.Entity.Note.Notes;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class NoteDisplay extends JFrame implements ActionListener
{

    private JPanel contentPane;
    private JTextField usernamefield;
    private JPasswordField passwordfield;
    Button b1;
    private Component frame;

    /**
     * Create the frame.
     */
    public NoteDisplay(Notes note) {
        String title = note.getTitle();
        String author = note.getAuthor();
        String category = note.getCategory();
        String content = note.getContent();
        String reference = note.getReference();
        String date = note.getDate();
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

        JLabel Jauthor = new JLabel(author);
        Jauthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jauthor.setBounds(97, 43, 250, 33);
        contentPane.add(Jauthor);

        JLabel Jcontent = new JLabel(content);
        Jcontent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jcontent.setBounds(97, 63, 250, 60);
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

    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Button bb=(Button)ae.getSource();
        if(bb==b1)
        {
            dispose();
        }
    }
}