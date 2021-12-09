package Java.GUI;

import Java.Controller.UserInfoController;
import Java.Controller.UserInfoPresenter;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegisterPage extends JFrame implements ActionListener
{

    private final JTextField textField;
    private final JPasswordField password_field;
    private final JPasswordField password_retype;
    final Button b1;
    final Button b2;
    private Component frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RegisterPage frame = new RegisterPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RegisterPage()
    {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRegister = new JLabel("Register");
        lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblRegister.setBounds(122, 11, 129, 44);
        contentPane.add(lblRegister);

        JLabel lblName = new JLabel("Username");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(73, 75, 70, 30);
        contentPane.add(lblName);

        textField = new JTextField();
        textField.setBounds(218, 75, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(73, 105, 67, 30);
        contentPane.add(lblPassword);

        password_field = new JPasswordField();
        password_field.setBounds(218, 108, 86, 20);
        contentPane.add(password_field);
        password_field.setColumns(10);

        JLabel lblConfirmPassword = new JLabel("Re-enter Password");
        lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblConfirmPassword.setBounds(73, 135, 139, 30);
        contentPane.add(lblConfirmPassword);

        password_retype = new JPasswordField();
        password_retype.setBounds(218, 140, 86, 20);
        contentPane.add(password_retype);
        password_retype.setColumns(10);

        b1= new Button("Register!");
        b1.addActionListener(this);
        b1.setBounds(200, 180, 90, 23);
        contentPane.add(b1);

        b2 = new Button("Back");
        b2.addActionListener(this);
        b2.setBounds(90, 180, 90, 23);
        contentPane.add(b2);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {

        Button bb=(Button)ae.getSource();
        if(bb==b1)                  //Register
        {

            try
            {
                String username = textField.getText();
                String password = String.valueOf(password_field.getPassword());
                String retype_pw = String.valueOf(password_retype.getPassword());

                if(username.length() == 0 || password.length() == 0 || retype_pw.length() == 0)
                {
                    JOptionPane.showMessageDialog(frame,"Name/Password field cannot be left blank!");
                }
                else if(!retype_pw.equals(password)){
                    JOptionPane.showMessageDialog(frame,"Password fields dont match");
                }
                else {
                    UserInfoController user = new UserInfoController(false, username, password);
                    UserInfoPresenter presenter = user.decode();
                    if(!presenter.returnProgress())               //duplicate name exists
                    {
                        JOptionPane.showMessageDialog(frame,"Username already exists");
                    }
                    else
                    {
                            JOptionPane.showMessageDialog(frame,"Profile Successfully created!");
                            dispose();
                            LoginPage page = new LoginPage();
                            page.setVisible(true);
                    }
                }
            }
            catch(Exception e)
            {
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