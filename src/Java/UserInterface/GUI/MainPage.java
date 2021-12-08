package Java.UserInterface.GUI;

import Java.Controller.NoteInfoPresenter;
import Java.Controller.NotesDisplayController;
import Java.Entity.Note.Notes;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class MainPage extends JFrame implements ActionListener
{

    private JPanel contentPane;
    Button b1,b2,b3,b4;
    public static String name;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainPage frame = new MainPage(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    @SuppressWarnings("unchecked")
    public MainPage(String n)
    {
        name = n;
        setResizable(false);
        //System.out.println(name);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel welcome = new JLabel("Welcome!");
        welcome.setBounds(100, 15, 150, 30);
        welcome.setFont(new Font("Calibri", Font.PLAIN, 20));
        contentPane.add(welcome);

        JLabel curr_user = new JLabel("Current active user: " + name);
        curr_user.setBounds(330, 20, 150, 19);
        curr_user.setFont(new Font("Calibri", Font.PLAIN, 12));
        contentPane.add(curr_user);

        b1 = new Button("Create Note");
        b1.setBounds(370, 111, 106, 44);
        b1.addActionListener(this);
        contentPane.add(b1);

        b2 = new Button("Edit Note");
        b2.setBounds(370, 181, 106, 44);
        b2.addActionListener(this);
        contentPane.add(b2);

        b3 = new Button("Delete Note");
        b3.setBounds(370, 251, 106, 44);
        b3.addActionListener(this);
        contentPane.add(b3);

        b4=new Button("LogOut");
        b4.addActionListener(this);
        b4.setFont(new Font("Calibri", Font.ITALIC, 10));
        b4.setBounds(500, 20, 54, 19);
        contentPane.add(b4);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(100, 100, 200, 200);
        contentPane.add(scrollPane);
        JList<String> list=new JList<>();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane.setViewportView(list);

        NoteInfoPresenter presenter = new NoteInfoPresenter();
        NotesDisplayController ndc = new NotesDisplayController(presenter);
        ndc.getAllNotes();
        ArrayList<Object> all_info = presenter.getAllInfo();
        ArrayList<Notes> all_note = new ArrayList<>();
        if (all_info.get(0) instanceof ArrayList){
            all_note = (ArrayList<Notes>) all_info.get(0);
        }

        String[] listData=new String[all_note.size()];
        int count = 0;

        for (Notes note : all_note){
            listData[count] = note.getAuthor() + ": " + note.getTitle();
            count ++;
        }
        list.setListData(listData);

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Button bb=(Button)ae.getSource();
//        if(bb==b1)
//        {
//            dispose();
//            View_profile nam=new View_profile(name);
//            View_profile le=new View_profile();  //View Profile
//
//            le.setVisible(true);
//
//        }
//        if(bb==b2)
//        {
//            dispose();
//            Edit_proile nam=new Edit_proile(name);
//            Edit_proile ep=new Edit_proile();   //Edit Profile
//            ep.setVisible(true);
//        }
//
        if(bb==b4)
        {
            dispose();
            LoginPage p=new LoginPage();        //Logs us out ie. gets us back to Page1(Login page)
            p.setVisible(true);
        }

    }
}