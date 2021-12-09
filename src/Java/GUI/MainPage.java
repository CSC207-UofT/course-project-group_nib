package Java.GUI;

import Java.Controller.NoteInfoController;
import Java.Controller.NoteInfoPresenter;
import Java.Controller.NotesDisplayController;
import Java.Entity.Note.Notes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Objects;


public class MainPage extends JFrame implements ActionListener
{

    private final JPanel contentPane;
    private int index;
    final JList<String> list;
    final Button b1;
    final Button b2;
    final Button b3;
    final Button b4;
    final Button b5;
    private ArrayList<Notes> all_note;
    public static String name;
    private Component frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainPage frame = new MainPage(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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

        b5 = new Button("View Note");
        b5.setBounds(100, 300, 106, 20);
        b5.addActionListener(this);
        contentPane.add(b5);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(100, 100, 200, 200);
        contentPane.add(scrollPane);
        list=new JList<>();
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(e -> index = list.getSelectedIndex());

        scrollPane.setViewportView(list);

        NoteInfoPresenter presenter = new NoteInfoPresenter();
        NotesDisplayController ndc = new NotesDisplayController(presenter);
        ndc.getAllNotes();
        ArrayList<Object> all_info = presenter.getAllInfo();
        all_note = new ArrayList<>();
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
        if(bb==b1)
        {
            dispose();
            NoteCreationForm ncf=new NoteCreationForm(name);

            ncf.setVisible(true);

        }
        if(bb==b5)
        {
            Notes note = all_note.get(index);
            NoteDisplay nd=new NoteDisplay(note);
            nd.setVisible(true);
        }
        if(bb==b2)
        {
            Notes note = all_note.get(index);
            if (!Objects.equals(note.getAuthor(), name)){
                JOptionPane.showMessageDialog(frame,"This is not your note!");
            }
            else {
                dispose();
                NoteEditForm nef = new NoteEditForm(note);
                nef.setVisible(true);

            }

        }
        if(bb==b3)
        {
            Notes note = all_note.get(index);
            if (!Objects.equals(note.getAuthor(), name)){
                JOptionPane.showMessageDialog(frame,"This is not your note!");
            }
            else {
                int result = JOptionPane.showConfirmDialog(null,"Notes cannot be recovered. Are you sure?",
                        "Deletion Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == 0){
                    ArrayList<String> instruction = new ArrayList<>();
                    instruction.add(note.getTitle());
                    NoteInfoPresenter presenter = new NoteInfoPresenter();
                    NoteInfoController controller = new NoteInfoController(note.getAuthor(), 3,
                            instruction, presenter);
                    controller.decode();

                    if (presenter.getState()){
                        JOptionPane.showMessageDialog(frame,"Note deleted!");
                        dispose();
                        MainPage mp=new MainPage(name);        //restart
                        mp.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame,"Deletion failed. \n " +
                                "It is an unexpected error. Please restart the system :(");
                    }

                }
            }

        }
        if(bb==b4)
        {
            dispose();
            LoginPage p=new LoginPage();        //Log out
            p.setVisible(true);
        }

    }
}