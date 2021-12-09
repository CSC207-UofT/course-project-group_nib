package Java.UserInterface.GUI;

import Java.Controller.UserInfoController;
import Java.Controller.UserInfoPresenter;

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

public class LoginPage extends JFrame implements ActionListener
{

    private final JTextField usernamefield;
    private final JPasswordField passwordfield;
    Button b1,b2,b3;
    String username;
    String password;
    private Component frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage frame = new LoginPage();
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
    public LoginPage() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("WELCOME!");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblLogin.setBounds(152, 11, 150, 52);
        contentPane.add(lblLogin);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(97, 83, 78, 33);
        contentPane.add(lblName);

        usernamefield = new JTextField();
        usernamefield.setBounds(202, 87, 160, 29);
        contentPane.add(usernamefield);
        usernamefield.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(97, 137, 115, 29);
        contentPane.add(lblPassword);

        passwordfield = new JPasswordField();
        passwordfield.setBounds(202, 141, 160, 29);
        contentPane.add(passwordfield);
        passwordfield.setColumns(10);

        b1 = new Button("Register");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        b1.setBounds(73, 212, 89, 23);
        b1.addActionListener(this);
        contentPane.add(b1);

        b2= new Button("Login");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        b2.setBounds(172, 212, 89, 23);
        b2.addActionListener(this);
        contentPane.add(b2);

        b3= new Button("Exit");
        b3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        b3.setBounds(273, 212, 89, 23);
        b3.addActionListener(this);
        contentPane.add(b3);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Button bb=(Button)ae.getSource();
        if(bb==b1)                  //Register
        {
            dispose();
            RegisterPage re=new RegisterPage();
            re.setVisible(true);
        }

        if(bb==b2)                     //Login
        {
            try
            {
                username = usernamefield.getText();
                password = String.valueOf(passwordfield.getPassword());
                UserInfoController user = new UserInfoController(true, username, password);
                UserInfoPresenter presenter = user.decode();
                if(presenter.returnProgress())
                {
                    JOptionPane.showMessageDialog(frame,"you are successfully logged in!");
                    dispose();
                    MainPage m=new MainPage(username);

                    m.setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Your userid or password is incorrect");

                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        if(bb==b3)
            System.exit(0);

    }
}