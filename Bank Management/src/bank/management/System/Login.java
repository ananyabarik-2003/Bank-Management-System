package bank.management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public  class Login  extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardTextfield;
    JPasswordField pinTextfield;
    Login(){

        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/Logo.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

       // getContentPane().setBackground(Color.green);

        JLabel text=new JLabel("Welcome to Bank");
        text.setFont(new Font("Onward",Font.BOLD,50));
        text.setBounds(220,40,500,40);
        add(text);

        JLabel Cardno=new JLabel("Card No:");
        Cardno.setFont(new Font("Onward",Font.BOLD,30));
        Cardno.setBounds(150,150,300,40);
        add(Cardno);

        cardTextfield=new JTextField();
        cardTextfield.setBounds(300,150,250,40);
        cardTextfield.setFont(new Font("Railway", Font.BOLD,30));
        add(cardTextfield);


        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Onward",Font.BOLD,30));
        pin.setBounds(150,220,300,40);
        add(pin);

        pinTextfield=new JPasswordField();
        pinTextfield.setBounds(300,220,250,40);
        pinTextfield.setFont(new Font("Railway", Font.BOLD,30));
        add(pinTextfield);


        login = new JButton("SIGN IN");
        login.setBounds(300,290,100,40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450,290,100,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,40);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextfield.setText("");
            pinTextfield.setText("");
        } else if (ae.getSource() == login) {

            Conn cn=new Conn();
            String cardNo=cardTextfield.getText();
            String pinNo=pinTextfield.getText();
            String query=" select * from login where Cardno='" +cardNo+ "' and PIN='" +pinNo+ "'";

           try {

               ResultSet resultSet=cn.s.executeQuery(query);

               if (resultSet.next()){
                   setVisible(false);
                   new Transaction1(pinNo).setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null,"The cardno or PIN is not correct");
               }

           }catch (Exception e){
               System.out.println(e);
           }

            
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup1().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Login();
    }


}