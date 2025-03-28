package CabBooking;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tf, tf1, tf2, tf3;
    private JButton b1, b2;
    private JComboBox comboBox;

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Signup(){
        setBounds(600, 250, 700, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your nickname?", "Your lucky number?", "Your favorite superHero?", "Your childhood name?"}));
        comboBox.setBounds(265, 202, 148, 20);
        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        tf = new JTextField();
        tf.setBounds(265, 91, 148, 20);
        contentPane.add(tf);
        tf.setColumns(10);

        tf1 = new JTextField();
        tf1.setColumns(10);
        tf1.setBounds(265, 128, 148, 20);
        contentPane.add(tf1);

        tf2 = new JTextField();
        tf2.setColumns(10);
        tf2.setBounds(265, 165, 148, 20);
        contentPane.add(tf2);

        tf3 = new JTextField();
        tf3.setColumns(10);
        tf3.setBounds(265, 239, 148, 20);
        contentPane.add(tf3);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
    
        try{
            Conn con = new Conn();

            if(ae.getSource() == b1){
                String username = tf.getText();
                String name = tf1.getText();
                String password = tf2.getText();
                String question = (String) comboBox.getSelectedItem();
                String answer = tf3.getText();

                String sq1 = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
                con.s.executeUpdate(sq1);
                JOptionPane.showMessageDialog(null, "Account Create Successfully");

                new Login().setVisible(true);
                setVisible(false);
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
